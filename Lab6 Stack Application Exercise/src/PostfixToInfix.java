package KW.CH04;

import java.util.Deque;
import java.util.NoSuchElementException;

/** Class to convert from postfix to infix.
 *  @author Koffman &amp; Wolfgang
 **/
/*<exercise chapter="4" type="programming-project" number="2">*/
public class PostfixToInfix {
    
    private PostfixToInfix() {}

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
    private static String evalOp(char op, Deque<String> operandStack) {
        // Pop the two operands off the stack.
        String rhs = operandStack.pop();
        String lhs = operandStack.pop();
        // Evaluate the operator.
        return String.format("(%s %s %s)",  lhs, Character.toString(op), rhs);
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
     * Converts a postfix expression.
     * @param expression The expression to be evaluated
     * @return Infix equivalent of expressing
     * @throws SyntaxErrorException if a syntax error is detected
     */
    public static String convert(String expression) throws SyntaxErrorException {
        // Create an empty stack.
        Deque<String> operandStack = new java.util.ArrayDeque<>();

        // Process each token.
        String[] tokens = expression.split("\\s+");
        try {
            for (String nextToken : tokens) {
                // Does it start with a digit?
                if (isOperator(nextToken.charAt(0))) {
                    // Evaluate the operator.
                    String result = evalOp(nextToken.charAt(0), operandStack);
                    // Push result onto the operand stack.
                    operandStack.push(result);
                } else {
                    operandStack.push(nextToken);
                }
            } // End while.

            // No more tokens - pop result from operand stack.
            String answer = operandStack.pop();
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
/*</exercise>*/
