/*<listing chapter="4" number="6">*/
package KW.CH04;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.NoSuchElementException;

/** Class that can evaluate a postfix expression.
 *  @author Koffman &amp; Wolfgang
 **/
public class PostfixEvaluator {
    
    private PostfixEvaluator() {}

    // Nested Class
    /** Class to report a syntax error. */
    @SuppressWarnings("serial")
    public static class SyntaxErrorException extends RuntimeException {

        /**
         * Construct a SyntaxErrorException with the specified
         * message.
         * @param message The message
         */
        SyntaxErrorException(String message) {
            super(message);
        }
    }
    // Constant
    /** A list of operators. */
    private static final String OPERATORS = "+-*/%";

    // Methods
    /**
     * Evaluates the current operation.
     * This function pops the two operands off the operand
     * stack and applies the operator.
     * @param op A character representing the operator
     * @param operandStack the current stack of operands
     * @return The result of applying the operator
     * @throws NoSuchElementException if pop is attempted on
     *         an empty stack
     */
    private static int evalOp(char op, Deque<Integer> operandStack) {
        // Pop the two operands off the stack.
        int rhs = operandStack.pop();
        int lhs = operandStack.pop();
        int result = 0;
        // Evaluate the operator.
        switch (op) {
            case '+':
                result = lhs + rhs;
                break;
            case '-':
                result = lhs - rhs;
                break;
            case '/':
                result = lhs / rhs;
                break;
            case '*':
                result = lhs * rhs;
                break;
            case '%':
                result = lhs % rhs;
                break;
        }
        return result;
    }

    /**
     * Determines whether a character is an operator.
     * @param op The character to be tested
     * @return true if the character is an operator
     */
    private static boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    /**
     * Evaluates a postfix expression.
     * @param expression The expression to be evaluated
     * @return The value of the expression
     * @throws SyntaxErrorException if a syntax error is detected
     */
    public static int eval(String expression) throws SyntaxErrorException {
        // Create an empty stack.
        Deque<Integer> operandStack = new ArrayDeque<>();

        // Process each token.
        String[] tokens = expression.split("\\s+");
        try {
            for (String nextToken : tokens) {
                // Does it start with a digit?
                if (Character.isDigit(nextToken.charAt(0))) {
                    // Get the integer value.
                    int value = Integer.parseInt(nextToken);
                    // Push value onto operand stack.
                    operandStack.push(value);
                } // Is it an operator?
                else if (isOperator(nextToken.charAt(0))) {
                    // Evaluate the operator.
                    int result = evalOp(nextToken.charAt(0), operandStack);
                    // Push result onto the operand stack.
                    operandStack.push(result);
                } else {
                    // Invalid character.
                    throw new SyntaxErrorException(
                            "Invalid character encountered");
                }
            } // End while.

            // No more tokens - pop result from operand stack.
            int answer = operandStack.pop();
            // Operand stack should be empty.
            if (operandStack.isEmpty()) {
                return answer;
            } else {
                // Indicate syntax error.
                throw new SyntaxErrorException(
                        "Syntax Error: Stack should be empty");
            }
        } catch (NoSuchElementException ex) {
            // Pop was attempted on an empty stack.
            throw new SyntaxErrorException(
                    "Syntax Error: The stack is empty");
        }
    }
}
/*</listing>*/
