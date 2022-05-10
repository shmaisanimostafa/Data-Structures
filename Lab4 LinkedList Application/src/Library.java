package lab3;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class Library {
	
	private List<Book> booksList;
	
	public Library(){
		booksList = new LinkedList<>();
	}
	
	public int numberOfBooks() {
		return booksList.size();
	}
	
	public void printBooksOnSale(int price) {
		Iterator<Book> iter = booksList.iterator();		
		while(iter.hasNext()) {
			Book b = iter.next();
			if(b.getPrice() < price)
				System.out.println(b);
		}
	}
	
	public LinkedList<Book> deleteExpensiveBooks(int price) {
		Iterator<Book> iter = booksList.iterator();	
		LinkedList<Book> removedList = new LinkedList<>();
		while(iter.hasNext()) {
			Book b = iter.next();
			if(b.getPrice() > price) {
				removedList.add(b);
				iter.remove();
			}
		}
		return removedList;
	}
	
	public Book searchIsbn(long isbn) {
		Iterator<Book> iter = booksList.iterator();		
		while(iter.hasNext()) {
			Book b = iter.next();
			if(b.getIsbn() == isbn) {
				return b;
			}				
		}
		return null;
	}
	
	@Override
	public String toString() {
		Iterator<Book> iter = booksList.iterator();
		StringBuilder sb = new StringBuilder();
		sb.append("Library Books:\n");
		while(iter.hasNext()) {
			sb.append(iter.next().toString());
			sb.append("\n");
		}
		return sb.toString();
	}
	
	public void addBook(Book b) {
		ListIterator<Book> iter = booksList.listIterator();
		while (iter.hasNext()) {
			Book item = iter.next();
			if (item.compareTo(b) > 0) { // found element > new one
				iter.previous(); // back up by one
				iter.add(b); // add new one
				return; // done
			}
		}
		iter.add(b); // will add at end
	}

}
