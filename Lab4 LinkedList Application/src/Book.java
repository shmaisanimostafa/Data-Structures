package lab3;

public class Book implements Comparable<Book> {
	private int price;
	private long isbn;
	private String name;

	public Book() {
	}

	public Book(int price, long isbn, String name) {
		setPrice(price);
		setIsbn(isbn);
		setName(name);
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public long getIsbn() {
		return isbn;
	}

	public void setIsbn(long isbn) {
		this.isbn = isbn;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String toString() {
		return "Name:" + name + "\nISBN:" + isbn + "\nPrice:" + price + "\n";
	}

	@Override
	public int compareTo(Book o) {
		if (o == null)
			throw new NullPointerException();
		if (price > o.price)
			return 1;
		else if (price < o.price)
			return -1;
		return 0;
	}

}
