package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

public class PalindromeFinder {
	/**
	 * Fills a stack of characters from an input string.
	 * 
	 * @param inputString the string to be checked
	 * @return a stack of characters in inputString
	 */
	private static Deque<Character> fillStack(String inputString) {
		Deque<Character> charStack = new ArrayDeque<>();
		for (int i = 0; i < inputString.length(); i++) {
			charStack.push(inputString.charAt(i));
		}
		return charStack;

	}

	/**
	 * Builds the reverse of a string by calling fillsStack to push its characters
	 * onto a stack and then popping them and appending them to a new string.
	 * 
	 * @post The stack is empty.
	 * @return The string containing the characters in the stack
	 */
	private static String buildReverse(String inputString) {
		Deque<Character> charStack = fillStack(inputString);
		StringBuilder result = new StringBuilder();
		while (!charStack.isEmpty()) {
			// Remove top item from stack and append it to result.
			result.append(charStack.pop());
		}
		return result.toString();
	}

	/**
	 * Calls buildReverse and compares its result to inputString
	 * 
	 * @param inputString the string to be checked
	 * @return true if inputString is a palindrome, false if not
	 */
	public static boolean isPalindrome(String inputString) {
		return inputString.equalsIgnoreCase(buildReverse(inputString));
	}
	
	
	// Lab 4 exercise
	public static boolean isPalindromeLettersOnly(String input) {		
		Deque<Character> stack = new ArrayDeque<>();
		StringBuilder string = new StringBuilder();
		
		for(int i = 0; i < input.length();i++) {
			Character c = input.charAt(i);
			if(Character.isLetter(c)) {
				stack.push(c);
				string.append(c);
			}
		}
		StringBuilder reverse = new StringBuilder();
		while(!stack.isEmpty())
			reverse.append(stack.pop());		
		
		return string.toString().equals(reverse.toString());
	}
	
	public static void main(String[] args) {
		if(isPalindromeLettersOnly("I1saw2wasX"))
			System.out.println("is palindrome");
		else
			System.out.println("not palindrome");
	}

}