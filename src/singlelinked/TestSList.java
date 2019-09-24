package singlelinked;

public class TestSList {

	public static void main(String[] args) {
		SList<String> myList = new SList<>() {
			{
				add("A");
				add("B");
				add("C");
				add("D");
				add("E");
			}
		};
		System.out.println(myList);

		SList<String> sameList = new SList<>() {
			{
				insertLast("E");
				insertLast("D");
				insertLast("C");
				insertLast("B");
				insertLast("A");
			}
		};
		System.out.println(sameList);
		System.out.println(myList.equals(sameList));

		SList<String> shortList = new SList<>() {
			{
				add("A");
				add("B");
				add("C");
			}
		};
		System.out.println(shortList);
		System.out.println(myList.equals(shortList));
	}

}
