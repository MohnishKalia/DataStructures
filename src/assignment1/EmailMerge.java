package assignment1;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.List;
import java.util.stream.Collectors;
/**
 * @author Mohnish Kalia
 */
public class EmailMerge {
	
	public static void main(String[] args) throws IOException {
		// Transferring lines of text into entries in a list (unmodifiable list)
		List<String> template = Files.readAllLines(Paths.get("src/assignment1/template.txt"));
		List<String> people = Files.readAllLines(Paths.get("src/assignment1/people.txt"));

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

			String dir = "src/assignment1/%s%s.txt"; // template format string for filename
			Path path = Paths.get(String.format(dir, info[0], "")); // generates path with just the name (ex."John.txt")

			// loop to check if there are any file collisions, replacing the standard path
			// with an indexed path (ex. "John-2.txt")
			if (Files.exists(path))
				for (int i = 1; Files.exists(path); i++)
					path = Paths.get(String.format(dir, info[0], "-" + i));

			Files.write(path, email); // writes the text lines to the now cleared filepath
		}
	}

}
