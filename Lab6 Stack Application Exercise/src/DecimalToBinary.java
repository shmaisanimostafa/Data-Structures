package lab5;

import java.util.ArrayDeque;
import java.util.Deque;

public class DecimalToBinary {

	public static String convert(int decimal) {

		Deque<Integer> stack = new ArrayDeque<>();
		while (decimal > 0) {
			stack.push(decimal % 2);
			decimal /= 2;
		}		
		if(stack.isEmpty())
			return "0";
		StringBuilder binary = new StringBuilder();
		while (!stack.isEmpty())
			binary.append(stack.pop());
		return binary.toString();
	}

	public static void main(String[] args) {
		for (int i = 0; i < 20;i++)
			System.out.println(DecimalToBinary.convert(i));
	}

}
