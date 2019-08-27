package assignment1;

import java.util.*;
import java.io.*;

public class EmailMerge {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		// TODO Auto-generated method stub
		/*
		 * 1 line of people.txt includes a person's info Store in string[] and iterate
		 * {Name} {Age} {Gender} As a result, .split(" ") and 0=N, 1=A, 2=G Then send
		 * message using message template and .replaceAll
		 */

		List<String> persons = new ArrayList<String>();
		List<String> message = new ArrayList<String>();
		try (Scanner template = new Scanner(new File("src/assignment1/template.txt"));
				Scanner people = new Scanner(new File("src/assignment1/people.txt"))) {
			while (template.hasNextLine())
				message.add(template.nextLine() + "\n");

			while (people.hasNextLine())
				persons.add(people.nextLine());

			for (String person : persons)
				printPersonalizedMessage(message, person);
		}
	}

	private static void printPersonalizedMessage(List<String> message, String personalInformation)
			throws FileNotFoundException, IOException {
		List<String> template = new ArrayList<String>();
		for (String line : message)
			template.add(line);
		String[] info = personalInformation.split(" ");
		for (int i = 0; i < template.size(); i++)
			template.set(i, template.get(i).replaceAll("<<N>>", info[0]).replaceAll("<<A>>", info[1])
					.replaceAll("<<G>>", info[2]));
		String email = "";
		for (String line : template)
			email += line;

		System.out.println(email);
		// Save message to local storage here
		String path = "src/assignment1/%s";
		File file = new File(String.format(path + ".txt", info[0]));
		if (!file.createNewFile())
			for (int i = 1; !file.createNewFile(); i++)
				file = new File(String.format(path + "-" + i + ".txt", info[0]));
		try (PrintWriter output = new PrintWriter(new FileOutputStream(file))) {
			output.println(email);
		}
	}
}
