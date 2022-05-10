package lab6;

import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Scanner;
import java.util.Iterator;

public class DequePractice {

	public static void numericOrNot() {

		Deque<Integer> deque = new ArrayDeque<>();
		int numOther = 0;
		int numNumber = 0;
		Scanner in = new Scanner(System.in);
		int num = in.nextInt();
		while (num != 0) {

			if (num < 0) {
				deque.addLast(num);
				numNumber++;
			} else {
				deque.addFirst(num);
				numOther++;
			}
			num = in.nextInt();
		}

		Iterator<Integer> itr = deque.iterator();
		System.out.println("Integers that are positive");
		int i = 0;
		while (i < numOther && itr.hasNext()) {
			System.out.println(itr.next());
			i++;
		}
		System.out.println("Integers that are negative");
		while (itr.hasNext()) {
			System.out.println(itr.next());
		}
	}

	public static void reverse() {
		System.out.println("Enter a string of characters");
		Scanner scan = new Scanner(System.in);
		String line = scan.nextLine();
		Deque<Character> deque1 = new ArrayDeque<>();
		for (int i = 0; i < line.length(); i++) {
			deque1.offer(line.charAt(i));
		}
		System.out.println("Contents of deque");
		System.out.println(deque1);
		Deque<Character> deque2 = new ArrayDeque<>();
		for (char c : deque1) {
			deque2.push(c);
		}
		var itr1 = deque1.iterator();
		var itr2 = deque2.iterator();
		System.out.println("deque1\tdeque2");
		while (itr1.hasNext()) {
			Character c1 = itr1.next();
			Character c2 = itr2.next();
			System.out.println(c1.toString() + '\t' + c2.toString());
		}
	}

	public static void main(String[] args) {
		reverse();
		numericOrNot();
	}
}
