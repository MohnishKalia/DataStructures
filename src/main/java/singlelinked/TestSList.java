package singlelinked;

import java.util.stream.IntStream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TestSList {
	private SList<String> myList;
	private SList<String> sameList;

	@BeforeEach
	private void setup() {
		myList = new SList<>();

		IntStream.rangeClosed('A', 'E').forEach(c -> myList.add("" + (char) c)); // uses streams to generate the letters
		sameList = new SList<>() {
			{
				insertLast("E");
				insertLast("D");
				insertLast("C");
				insertLast("B");
				insertLast("A");
			}
		};
	}

	@Test
	public void testInsertLast() {
		assertEquals(myList.toString(), sameList.toString());
	}

	@Test
	public void testRemoveFirst() {
		myList.removeFirst();
		assertEquals("D-->C-->B-->A", myList.toString(), "Remove first worked");
	}

	@Test
	public void testRemove_Middle() {
		myList.remove("C");
		assertEquals("E-->D-->B-->A", myList.toString());
	}

	@Test
	public void testRemove_First() {
		myList.remove("E");
		assertEquals("D-->C-->B-->A", myList.toString());
	}

	@Test
	public void testRemove_Last() {
		myList.remove("A");
		assertEquals("E-->D-->C-->B", myList.toString());
	}

	@Test
	public void testRemove_NIL() {
		myList.remove("Z");
		assertEquals("E-->D-->C-->B-->A", myList.toString());
	}

	@Test
	public void testEquals_Reflection() {
		assertTrue(myList.equals(myList));
	}

	@Test
	public void testEquals_Null() {
		assertFalse(myList.equals(null));
	}

	@Test
	public void testEquals_Content() {
		assertTrue(myList.equals(sameList));
	}
}
