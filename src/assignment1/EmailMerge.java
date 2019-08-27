package assignment1;

import java.util.*;
import java.io.*;
import java.nio.file.*;

public class EmailMerge {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		List<String> template = Files.readAllLines(Paths.get("src/assignment1/template.txt"));
		List<String> people = Files.readAllLines(Paths.get("src/assignment1/people.txt"));
		for (String person : people) {
			String[] info = person.split(" ");
			List<String> email = new ArrayList<>(template);			
			for (ListIterator<String> i = email.listIterator(); i.hasNext();)
				i.set(i.next().replaceAll("<<N>>", info[0]).replaceAll("<<A>>", info[1]).replaceAll("<<G>>", info[2]));
			
			String dir = "src/assignment1/%s";
			Path path = Paths.get(String.format(dir + ".txt", info[0]));
			if (Files.exists(path))
				for (int i = 1; Files.exists(path); i++)
					path = Paths.get(String.format(dir + "-" + i + ".txt", info[0]));
			
			Files.write(path, email);
		}
	}

}
