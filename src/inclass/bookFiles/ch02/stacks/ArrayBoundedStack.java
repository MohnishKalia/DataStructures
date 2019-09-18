//----------------------------------------------------------------
// ArrayBoundedStack.java    by Dale/Joyce/Weems         Chapter 2
//
// Implements StackInterface using an array to hold the 
// stack elements.
//
// Two constructors are provided: one that creates an array of a 
// default size and one that allows the calling program to 
// specify the size.
//----------------------------------------------------------------

package inclass.bookFiles.ch02.stacks;

public class ArrayBoundedStack<T> implements StackInterface<T> {
  protected final int DEFCAP = 100; // default capacity
  protected T[] elements; // holds stack elements
  protected int topIndex = -1; // index of top element in stack

  public ArrayBoundedStack() {
    elements = (T[]) new Object[DEFCAP];
  }

  public ArrayBoundedStack(int maxSize) {
    elements = (T[]) new Object[maxSize];
  }

  public void push(T element)
  // Throws StackOverflowException if this stack is full,
  // otherwise places element at the top of this stack.
  {
    if (isFull())
      throw new StackOverflowException("Push attempted on a full stack.");
    else {
      topIndex++;
      elements[topIndex] = element;
    }
  }

  public void pop()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise removes top element from this stack.
  {
    if (isEmpty())
      throw new StackUnderflowException("Pop attempted on an empty stack.");
    else {
      elements[topIndex] = null;
      topIndex--;
    }
  }

  public T top()
  // Throws StackUnderflowException if this stack is empty,
  // otherwise returns top element of this stack.
  {
    T topOfStack = null;
    if (isEmpty())
      throw new StackUnderflowException("Top attempted on an empty stack.");
    else
      topOfStack = elements[topIndex];
    return topOfStack;
  }

  public boolean isEmpty()
  // Returns true if this stack is empty, otherwise returns false.
  {
    return (topIndex == -1);
  }

  public boolean isFull()
  // Returns true if this stack is full, otherwise returns false.
  {
    return (topIndex == (elements.length - 1));
  }

  /**
   * Pops a specified number of elements from the stack. Time complexity is O(n)
   * where n is the input (e.g. if removing 5 elements, time comp. is O(5)).
   * 
   * @param n number of elements to remove
   */
  public void remove(int n) {
    if (n > topIndex)
      throw new IllegalArgumentException("Specified index is too large for the current stack size.");
    for (int i = 0; i < n; i++)
      pop();
  }

  /**
   * Clears all elements within the stack. Time complexity is O(n) where n is the
   * # of non-null elements.
   */
  public void clear() {
    if (isEmpty())
      throw new StackUnderflowException("Clear attempted on an empty stack.");
    while (topIndex > -1)
      pop();
  }
}