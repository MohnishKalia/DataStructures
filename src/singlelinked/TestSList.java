package singlelinked;

public class TestSList {

	public static void main(String[] args) {
		SList<String> myList = new SList<String>();
		myList.add("A");
		myList.add("B");
		myList.add("C");
		myList.add("D");
		myList.add("E");
		System.out.println(myList);

		SList<String> sameList = new SList<String>();
		sameList.insertLast("E");
		sameList.insertLast("D");
		sameList.insertLast("C");
		sameList.insertLast("B");
		sameList.insertLast("A");
		System.out.println(sameList);
		System.out.println(myList.equals(sameList));

		SList<String> shortList = new SList<>();
		shortList.add("A");
		shortList.add("B");
		shortList.add("C");
		System.out.println(shortList);
		System.out.println(myList.equals(shortList));
	}

}
