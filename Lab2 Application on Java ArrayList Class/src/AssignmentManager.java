package lab1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class AssignmentManager {

	private List<Assignment> assignmentsList = new ArrayList<>();

	public void addNewAssignment(int id, String desc, LocalDate date) {
		assignmentsList.add(new Assignment(id, desc, date));
	}

	public Assignment removeAssignment(int id) {
		int index = assignmentsList.indexOf(new Assignment(id, "", null));
		if (index == -1)
			return null;
		Assignment toRemove = assignmentsList.get(index);
		assignmentsList.remove(index);
		return toRemove;
	}

	public void listAssignments() {
		System.out.println("Assignments List:");
		for (int i = 0; i < assignmentsList.size(); i++)
			System.out.println(assignmentsList.get(i));
	}

	public Assignment findEarliest() {
		if (assignmentsList.size() > 0) {
			Assignment earliest = assignmentsList.get(0);
			for (int i = 1; i < assignmentsList.size(); i++) {
				Assignment current = assignmentsList.get(i);
				if (current.isErlier(earliest))
					earliest = current;
			}
			return earliest;
		} else
			return null;
	}

	// To be provided to students so they would know the prototype of the methods
	public static void main(String[] args) {

		AssignmentManager list = new AssignmentManager();

		int id;
		String description;
		LocalDate date;

		// Assignment 1
		id = 1;
		description = "C++ Decision Statements";
		date = LocalDate.parse("2021-11-10");
		list.addNewAssignment(id, description, date);

		// Assignment 2
		id = 2;
		description = "C++ Basics";
		date = LocalDate.parse("2021-10-31");
		list.addNewAssignment(id, description, date);

		// Assignment 3
		id = 3;
		description = "English Essay 1";
		date = LocalDate.parse("2021-09-06");
		list.addNewAssignment(id, description, date);

		list.listAssignments();

		// find earliest
		Assignment ass = list.findEarliest();
		if(ass != null)
			System.out.println("The earliest assignment is\n" + ass);
		else
			System.out.println("The assignments list is empty");

		// remove it if its due date has passed
		if (ass != null) {
			if (ass.getDueDate().isBefore(LocalDate.now())) {
				list.removeAssignment(ass.getId());
			}
			System.out.println("After removing the earliest if its due date has passed ==>");
			list.listAssignments();
		}

	}

}
