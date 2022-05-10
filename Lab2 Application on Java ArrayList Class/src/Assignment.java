package lab1;

import java.time.LocalDate;

public class Assignment {

	private int id;
	private String description;
	private LocalDate dueDate;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Assignment() {
	}

	public Assignment(int id, String desc, LocalDate date) {
		this.id = id;
		description = desc;
		dueDate = date;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (obj.getClass() == this.getClass()) {
			Assignment a = (Assignment) obj;
			return a.getId() == this.getId();
		} else
			return false;
	}

	@Override
	public String toString() {
		String result = "";
		result += "Assignment " + id + ":\n";
		result += "Description: " + description + "\n";
		result += "Due Date: " + dueDate + "\n";
		return result;
	}

	public boolean isErlier(Assignment ass) {
		return this.dueDate.isBefore(ass.dueDate);
	}

	// To be provided to students so they would know the prototype of the methods
	public static void main(String[] args) {
		Assignment a1 = new Assignment(1, "C++ Basics", LocalDate.parse("2021-10-30"));
		Assignment a2 = new Assignment(2, "C++ Decision Statements", LocalDate.parse("2021-11-30"));
		
		//test toString
		System.out.println(a1);
		System.out.println(a2);
		
		//test isEarlier
		System.out.println(a1.isErlier(a2));
		
		//test equals
		System.out.println(a1.equals(a2));
		System.out.println(a1.equals(new Assignment(1,"",null)));
	}
}
