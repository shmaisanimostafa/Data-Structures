package lab4;

import java.util.ArrayDeque;
import java.util.Deque;

public class Program1 {
	
	public static void main(String[] args) {
		
		Deque<Integer> stack1 = new ArrayDeque<>();
		stack1.push(-1);
		stack1.push(15);
		stack1.push(23);
		stack1.push(44);
		stack1.push(4);
		stack1.push(99);
		
		Deque<Integer> stack2 = new ArrayDeque<>();
		stack2.push(-1);
		stack2.push(15);
		stack2.push(23);
		stack2.push(44);
		stack2.push(4);
		stack2.push(99);
		
		Deque<Integer> stack3 = new ArrayDeque<>();
		while(!stack1.isEmpty()) {
			stack3.push(stack1.pop());
		}
		
		while(!stack2.isEmpty() && !stack3.isEmpty()) {
			int num1, num2;
			num1 = stack2.pop();
			num2 = stack3.pop();
			System.out.println(num1 + "\t" + num2);
		}
		
	}

}
