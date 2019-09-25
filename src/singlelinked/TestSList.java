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
		System.out.println(myList.equals(sameList));

		SList<String> shortList = new SList<>();
		IntStream.rangeClosed('A', 'C').forEach(c -> shortList.add("" + (char) c));
		System.out.println(shortList);
		System.out.println(myList.equals(shortList));
		
		SList<String> nullCheck = new SList<>();
		nullCheck.add(null);
		nullCheck.add("First");
		nullCheck.insertLast("Last");
		System.out.println(nullCheck);
		System.out.println(myList.equals(nullCheck));
	}

}
