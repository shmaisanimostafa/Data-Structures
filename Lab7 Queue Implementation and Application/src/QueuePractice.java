package lab6;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class QueuePractice {

	public static void reverse() {
		Queue<Integer> queue = new LinkedList<>();
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		while (num != -1) {
			queue.offer(num);
			num = in.nextInt();
		}
		System.out.println(queue);
		Deque<Integer> stack = new ArrayDeque<>();
		while (!queue.isEmpty()) {
			stack.push(queue.peek());
			queue.remove();
		}
		while (!stack.isEmpty()) {
			queue.offer(stack.pop());
		}
		System.out.println(queue);
	}

	public static boolean isPrime(int n) {
		int divisors = 0;
		for (int i = 2; i <= n / 2; i++) {
			if (n % i == 0)
				divisors++;
		}
		return divisors == 0;
	}

	public static void removePrime() {
		Queue<Integer> queue = new LinkedList<>();
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		while (num != -1) {
			queue.offer(num);
			num = in.nextInt();
		}
		System.out.println(queue);
		int size = queue.size();
		for (int i = 0; i < size; i++) {
			int n = queue.remove();
			if (!isPrime(n))
				queue.offer(n);
		}
		System.out.println("After removing prime numbers:");
		System.out.println(queue);
	}

	public static void main(String[] args) {
		// reverse();
		removePrime();
	}

}
