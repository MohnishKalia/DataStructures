package inclass.bookFiles.ch02.apps;

import inclass.bookFiles.ch02.stacks.ArrayBoundedStack;

public class StackDriver {
  public static void main(String[] args) {
    ArrayBoundedStack<String> test = new ArrayBoundedStack<String>();
    String[] elements = "This is a test of the stack data structure".split(" "); // tokenizes each word
    for (String elt : elements)
      test.push(elt);
    System.out.println(test.top()); // expected "structure"
    // test.remove(10); // should throw IllegalArgumentExeception
    test.remove(2);
    System.out.println(test.top()); // expected "stack"
    test.clear();
    // System.out.println(test.top()); // should throw StackUnderflowException
    // test.clear(); // should throw StackUnderflowException
  }
}