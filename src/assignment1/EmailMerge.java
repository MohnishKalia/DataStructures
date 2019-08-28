package assignment1;

import java.io.IOException;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.stream.Collectors;

public class EmailMerge {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<String> template = Files.readAllLines(Paths.get("src/assignment1/template.txt"));
		List<String> people = Files.readAllLines(Paths.get("src/assignment1/people.txt"));
		for (String person : people) {
			String[] info = person.split(" ");
			List<String> email = template.stream().map(
					line -> line.replaceAll("<<N>>", info[0]).replaceAll("<<A>>", info[1]).replaceAll("<<G>>", info[2]))
					.collect(Collectors.toList());

			String dir = "src/assignment1/%s";
			Path path = Paths.get(String.format(dir + ".txt", info[0]));
			if (Files.exists(path))
				for (int i = 1; Files.exists(path); i++)
					path = Paths.get(String.format(dir + "-" + i + ".txt", info[0]));

			Files.write(path, email);
		}
	}

}
