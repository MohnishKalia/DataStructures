package singlelinked;

import java.util.stream.IntStream;

public class TestSList {

	public static void main(String[] args) {
		SList<String> myList = new SList<>();
		IntStream.rangeClosed('A', 'E').forEach(c -> myList.add("" + (char) c)); // uses streams to generate the letters A to Z, then adds them to the SList
		System.out.println(myList);

		SList<String> sameList = new SList<>() {
			{
				insertLast("E");
				insertLast("D");
				insertLast("C");
				insertLast("B");
				insertLast("A");
			}
		}; // "double brace" initialization for sameList
		System.out.println(sameList);
		System.out.println(myList.equals(sameList)); // should be true because its the same list but with the inverse order (using inverse method)

		SList<String> shortList = new SList<>();
		IntStream.rangeClosed('A', 'C').forEach(c -> shortList.add("" + (char) c));
		System.out.println(shortList);
		System.out.println(myList.equals(shortList)); // false because the list does not have the same elements or the same # of elements
		
		SList<String> nullCheck = new SList<>();
		nullCheck.add(null);
		nullCheck.add("First");
		nullCheck.insertLast("Last");
		System.out.println(nullCheck); // checks to make sure that null can be a valid input
		System.out.println(myList.equals(nullCheck));

		myList.removeFirst();
		System.out.println(myList); // should be D-->C-->B-->A
		myList.remove("D");
		System.out.println(myList); // should be C-->B-->A, testing to make sure that the first element will get removed
		myList.remove("B");
		System.out.println(myList);	// should be C-->A, testing an intermediate element

		sameList.remove("A");
		System.out.println(sameList); // should be E-->D-->C-->B, testing removal of the final element

		sameList.remove("This should not remove anything");
		System.out.println(sameList); // should be E-->D-->C-->B, no change

		System.out.println(sameList.equals(null)); // returns false because null cannot be equal to an object
		System.out.println(sameList.equals(sameList)); // returns true because of reflection
		System.out.println(sameList.equals(new SList<String>() {
			{
				insertLast("E");
				insertLast("D");
				insertLast("C");
				insertLast("B");
			}
		})); // should be true because they have the same contents
	}

}
