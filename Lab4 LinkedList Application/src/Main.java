package lab3;

import java.util.Iterator;
import java.util.LinkedList;

public class Main {

	public static void main(String[] args) {
		Book b1 = new Book(1005, 4324524, "Book 1");
		Book b2 = new Book(250, 6573353, "Book 2");
		Book b3 = new Book(50, 5758246, "Book 3");

		Library library = new Library();
		library.addBook(b1);
		library.addBook(b2);
		library.addBook(b3);

		System.out.println(library);

		System.out.println("Books on sale:");
		library.printBooksOnSale(100);

		System.out.println("Delete books whose price > 1000");
		LinkedList<Book> deleted = library.deleteExpensiveBooks(1000);
		System.out.println(library);
		System.out.println("The deleted books are:");
		Iterator<Book> iter = deleted.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		Book b = library.searchIsbn(6573353);
		System.out.println("Search for 6573353 ....\n");
		if(b!= null)
			System.out.println("Found:\n" + b);
		else
			System.out.println("Not found!\n");

	}

}
