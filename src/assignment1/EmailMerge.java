package assignment1;

import java.util.*;
import java.io.*;

public class EmailMerge {

	public static void main(String[] args) throws FileNotFoundException {
		// TODO Auto-generated method stub
		/*
		 * 1 line of people.txt includes a person's info Store in string[] and iterate
		 * {Name} {Age} {Gender} As a result, .split(" ") and 0=N, 1=A, 2=G Then send
		 * message using message template and .replaceAll
		 */

		ArrayList<String> persons = new ArrayList<String>();
		String message = "";
		Scanner template = new Scanner(new File("src/assignment1/template.txt"));
		Scanner people = new Scanner(new File("src/assignment1/people.txt"));

		while (template.hasNextLine())
			message += template.nextLine();
		System.out.println(message);

		while (people.hasNextLine())
			persons.add(people.nextLine());

		for (String person : persons) {
			String[] info = person.split(" ");
			String temp = message;
			temp = temp.replaceAll("<<N>>", info[0]);
			temp = temp.replaceAll("<<A>>", info[1]);
			temp = temp.replaceAll("<<G>>", info[2]);
			System.out.println(temp);
		}

	}

}
