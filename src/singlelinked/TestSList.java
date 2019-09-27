package singlelinked;

import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSList {

	private SList<String> myList = new SList<>();
	{
		IntStream.rangeClosed('A', 'E').forEach(c -> myList.add("" + (char) c)); // uses streams to generate the letters
																					// A to Z, then adds them to the
																					// SList
	}
	private SList<String> sameList = new SList<>() {
		{
			insertLast("E");
			insertLast("D");
			insertLast("C");
			insertLast("B");
			insertLast("A");
		}
	}; // "double brace" initialization for sameList

	@Test
	public void testEquals() {
		assertTrue(myList.equals(sameList));
	}

}
