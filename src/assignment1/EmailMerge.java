package assignment1;

import java.util.*;
import java.io.*;

/**
 * @author Mohnish Kalia
 */
public class EmailMerge {
	public static void main(String[] args) throws IOException, FileNotFoundException {
		List<String> persons = new ArrayList<String>();
		String message = "";
		try (Scanner templateScanner = new Scanner(new File("src/assignment1/template.txt"));
				Scanner peopleScanner = new Scanner(new File("src/assignment1/people.txt"))) {
			while (templateScanner.hasNextLine())
				message += templateScanner.nextLine() + "\n";

			while (peopleScanner.hasNextLine())
				persons.add(peopleScanner.nextLine());

			for (String person : persons)
				printPersonalizedMessage(message, person);
		}
	}

	/**
	 * Replaces the placeholders within a standard template email with personalized
	 * information.
	 * 
	 * @param template            The template message used for the desired email
	 *                            format (Name is <<N>>, Age is <<A>>, Gender is
	 *                            <<G>>)
	 * @param personalInformation A line of text that includes the Name, Age, and
	 *                            Gender of a person, respectively, separated by
	 *                            spaces
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void printPersonalizedMessage(String template, String personalInformation)
			throws IOException, FileNotFoundException {
		String[] info = personalInformation.split(" ");
		template = template.replaceAll("<<N>>", info[0]).replaceAll("<<A>>", info[1]).replaceAll("<<G>>", info[2]);
		// Save message to local storage here
		saveMessage(template, info[0]);
	}

	/**
	 * Saves a personalized email to local storage.
	 * 
	 * @param desiredEmail Finalized text to be saved within a file
	 * @param name         The name of the recipient
	 * @throws IOException
	 * @throws FileNotFoundException
	 */
	private static void saveMessage(String desiredEmail, String name) throws IOException, FileNotFoundException {
		String path = "src/assignment1/%s";
		File file = new File(String.format(path + ".txt", name));
		if (!file.createNewFile())
			for (int i = 1; !file.createNewFile(); i++)
				file = new File(String.format(path + "-" + i + ".txt", name));
		try (PrintWriter output = new PrintWriter(new FileOutputStream(file))) {
			output.println(desiredEmail);
		}
	}
}
