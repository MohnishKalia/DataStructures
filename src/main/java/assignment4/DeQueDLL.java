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
		if (front != null)
			front.setBack(node);
		front = node;
		if (rear == null)
			rear = node;
		numElements++;
	}

	public void enqueueRear(T element) {
		DLLNode<T> node = new DLLNode<>(element);
		node.setBack(rear);
		if (rear != null)
			rear.setForward(node);
		rear = node;
		if (front == null)
			front = node;
		numElements++;
	}

	public T dequeueFront() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on an empty stack.");
		T info = front.getInfo();
		front = (DLLNode<T>) front.getForward();
		if (front == null)
			rear = null;
		numElements--;
		return info;
	}

	public T dequeueRear() throws QueueUnderflowException {
		if (isEmpty())
			throw new QueueUnderflowException("Dequeue attempted on an empty stack.");
		T info = rear.getInfo();
		rear = (DLLNode<T>) rear.getBack();
		if (rear == null)
			front = null;
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

}
