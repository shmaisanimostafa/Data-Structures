package lab4;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Program2 {
	
	public static void main(String[] args) {
		String sentence;
		
		Scanner in = new Scanner(System.in);
		sentence = in.nextLine();
		
		String[] words = sentence.split(" ");
		
		Deque<String> stack = new ArrayDeque<>(); 
		
		for(String s: words) {
			stack.push(s);
		}
		
		StringBuilder sb = new StringBuilder();
		while(!stack.isEmpty()) {
			String s = stack.pop();
			sb.append(s);
			sb.append(" ");
		}
		
		System.out.println(sb.toString());
	}
}
