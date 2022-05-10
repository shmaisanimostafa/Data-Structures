/*<listing chapter="4" number="7">*/
package KW.CH04;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringJoiner;

/**
 * Translates an infix expression to a postfix expression.
 * @author Koffman and Wolfgang
 */
public class InfixToPostfix {

    // Insert nested class SyntaxErrorException. See Listing 4.6
    /** Class to report a syntax error. */
    @SuppressWarnings("serial")
    public static class SyntaxErrorException extends RuntimeException {

        /** 
         * Construct a SyntaxErrorException with the specified message.
         * @param message The message
         */
        SyntaxErrorException(String message) {
            super(message);
        }
    }
    // Data Fields
    /** The operator stack */
    private final Deque<Character> operatorStack = new ArrayDeque<>();
    /** The operators */
    private static final String OPERATORS = "-+*/";
    /** The precedence of the operators, matches order in OPERATORS. */
    private static final int[] PRECEDENCE = {1, 1, 2, 2};
    /** The postfix string */
    private final StringJoiner postfix = new StringJoiner(" ");

    /**
     * Convert a string from infix to postfix.
     * @param infix The infix expression
     * @throws SyntaxErrorException if syntax error is detected
     * @return the equivalent postfix expression.
     */
    public static String convert(String infix) {
        InfixToPostfix infixToPostfix = new InfixToPostfix();
        infixToPostfix.convertToPostfix(infix);
        return infixToPostfix.getPostfix();
    }

    /**
     * Return the final postfix string.
     * @return The final postfix string
     */
    public String getPostfix() {
        return postfix.toString();
    }

    /**
     * Convert a string from infix to postfix. 
     * Uses a stack to convert an infix expression to postfix
     * preperator stack is empty
     * postpostFix contains postfix expression and stack is empty
     * @param infix the string to convert to postfix
     * @throws SyntaxErrorException if argument is invalid
     */
    private void convertToPostfix(String infix) {
        String[] tokens = infix.split("\\s+");
        // Process each token in the infix string.
        for (String nextToken : tokens) {
            char firstChar = nextToken.charAt(0);
            // Is it an operand?
            if (Character.isDigit(firstChar)) {
                postfix.add(nextToken);
            } // Is it an operator? -- Yes, it has to be
            else if (isOperator(firstChar)) {
                processOperator(firstChar);
            } else {
                throw new SyntaxErrorException("Unexpected Character Encountered: " + firstChar);
            }
        } // End while.

            // Pop any remaining operators and
        // append them to postfix.
        while (!operatorStack.isEmpty()) {
            char op = operatorStack.pop();
            postfix.add(Character.toString(op));
        }
        // assert: Stack is isEmpty, return result.
    }

    /**
     * Method to process operators.
     * @param op The operator
     */
    private void processOperator(char op) {
        if (operatorStack.isEmpty()) {
            operatorStack.push(op);
        } else {
            // Peek the operator stack and
            // let topOp be top operator.
            char topOp = operatorStack.peek();
            if (precedence(op) > precedence(topOp)) {
                operatorStack.push(op);
            } else {
                // Pop all stacked operators with equal
                // or higher precedence than op.
                while (!operatorStack.isEmpty()
                        && precedence(op) <= precedence(topOp)) {
                    operatorStack.pop();
                    postfix.add(Character.toString(topOp));
                    if (!operatorStack.isEmpty()) {
                        // Reset topOp.
                        topOp = operatorStack.peek();
                    }
                }
                // assert: Operator stack is isEmpty or
                //         current operator precedence >
                //         top of stack operator precedence.
                operatorStack.push(op);
            }
        }
    }

    /**
     * Determine whether a character is an operator.
     * @param ch The character to be tested
     * @return true if ch is an operator
     */
    private static boolean isOperator(char ch) {
        return OPERATORS.indexOf(ch) != -1;
    }

    /**
     * Determine the precedence of an operator.
     * @param op The operator
     * @return the precedence
     */
    private static int precedence(char op) {
        return PRECEDENCE[OPERATORS.indexOf(op)];
    }
}
/*</listing>*/
