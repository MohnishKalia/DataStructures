package assignment1;
import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Generates a set of emails with personalized information inserted. 
 * Requires a people.txt and template.txt file within the same directory level as this program. 
 * Resulting emails are saved within the same directory level as text (.txt) files.
 * Uses standard duplicate naming conventions.
 *
 * @author Mohnish Kalia
 */
public class EmailMerge {
	
	public static void main(String[] args) throws IOException {
		// Transferring lines of text into entries in a list (unmodifiable list)
		List<String> template = Files.readAllLines(Paths.get("template.txt"));
		List<String> people = Files.readAllLines(Paths.get("people.txt"));

		for (String person : people) {
			String[] info = person.split(" "); // splits info string into [name, age, gender]

			// the following code leverages the stream API to create a copy of the
			// unmodifiable list with placeholders filled
			List<String> email = template.stream()
					.map(line -> line
					.replaceAll("<<N>>", info[0])
					.replaceAll("<<A>>", info[1])
					.replaceAll("<<G>>", info[2]))
					.collect(Collectors.toList());

			String dir = info[0] + "%s.txt"; // template format string for filename
			Path path = Paths.get(String.format(dir, "")); // generates path with just the name (ex."John.txt")

			// loop to check if there are any file collisions, replacing the standard path
			// with an indexed path (ex. "John-2.txt")
			if (Files.exists(path))
				for (int i = 1; Files.exists(path); i++)
					path = Paths.get(String.format(dir, "-" + i));

			Files.write(path, email); // writes the text lines to the now cleared filepath
		}
	}

}
