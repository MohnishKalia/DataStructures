package assignment4;

import java.util.ArrayList;

import ch04.queues.*;
import support.DLLNode;

public class DeQueDLL<T> implements DequeInterface<T> {

	protected DLLNode<T> front, rear; // reference to the front and rear of this deque
	protected int numElements = 0; // number of elements in this deque

	public DeQueDLL() {
		front = null;
		rear = null;
	}

	public void enqueueFront(T element) {
		DLLNode<T> node = new DLLNode<>(element);
		node.setForward(front);
		front = node;
		if (rear == null)
			rear = node;
		numElements++;
	}

	public void enqueueRear(T element) {
		DLLNode<T> node = new DLLNode<>(element);
		node.setBack(rear);
		rear = node;
		if (front == null)
			front = node;
		numElements++;
	}

	public T dequeueFront() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on an empty stack.");
		T info = front.getInfo();
		front = front.getForward() == null ? null : (DLLNode<T>) front.getForward();
		// if (front == null)
		// 	rear = null;
		numElements--;
		return info;
	}

	public T dequeueRear() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on an empty stack.");
		T info = rear.getInfo();
		rear = rear.getBack() == null ? null : (DLLNode<T>) rear.getBack();
		// if (rear == null)
		// 	front = null;
		numElements--;
		return info;
	}

	public boolean isFull() {
		return false;
	}

	public boolean isEmpty() {
		return numElements <= 0;
	}

	public int size() {
		return numElements;
	}

	@Override
	public String toString() {
		ArrayList<String> elements = new ArrayList<>();
		DLLNode<T> node = front;
		while (node != null) {
			elements.add(node.getInfo().toString());
			node = (DLLNode<T>) node.getForward();
		}
		return String.join("<=>", elements);
	}

	// /**
	// * Removes the first occurance of the element in the deque.
	// *
	// * @param element
	// */
	// public void remove(T element) {
	// DLLNode<T> node = null;

	// // find the node element
	// while (node != null) {
	// if (node.getInfo().equals(element))
	// break;
	// node = (DLLNode<T>) node.getForward();
	// }

	// // if its the only element or the front
	// if (numElements == 1 || node.getBack() == null)
	// dequeueFront();
	// // if its the back
	// else if (node.getForward() == null)
	// dequeueRear();
	// // if its intermediate
	// else
	// System.out.println("lol");
	// }

	public void insert(T element) {
		throw new UnsupportedOperationException();
	}

}
