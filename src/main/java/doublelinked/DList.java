package doublelinked;

import ch04.queues.QueueUnderflowException;
import support.DLLNode;

/**
 * @author Praveen Madiraju
 *
 */
public class DList<T> {

	private DLLNode<T> header;
	private DLLNode<T> trailer;

	private int size;

	/**
	 * 
	 */
	public DList() {
		header = null;
		trailer = null;
		size = 0;

	}

	/**
	 * @return the header
	 */
	public DLLNode<T> getHeader() {
		return header;
	}

	/**
	 * @return the trailer
	 */
	public DLLNode<T> getTrailer() {
		return trailer;
	}

	/**
	 * @return the size
	 */
	public int getSize() {
		return size;
	}

	// add element to the front of the list
	public void addToFront(T elem) {
		DLLNode<T> newNode = new DLLNode<T>(elem);

		if (header == null) {
			header = newNode;
		}
		if (trailer == null)
			trailer = newNode;
		else {
			newNode.setForward(header);
			header.setBack(newNode);
			header = newNode;
		}
		size++;

	}

	// add element to the end of the list
	public void addToLast(T elem) {
		DLLNode<T> newNode = new DLLNode<T>(elem);
		newNode.setForward(null);

		if (trailer == null) {
			trailer = newNode;
			header = newNode;
		} else {
			trailer.setForward(newNode);
			newNode.setBack(trailer);
			trailer = newNode;
		}

		size++;
	}

	public boolean isEmpty() {
		return header == null;
	}

	/**
	 * Time complexity is O(1).
	 */
	public void removeLast() {
		if (isEmpty())
			throw new QueueUnderflowException("Remove attempted on an empty list.");
		pop();
	}

	/**
	 * Time complexity is O(1).
	 * 
	 * @return info of the node that was popped
	 */
	public T pop() {
		if (isEmpty())
			throw new QueueUnderflowException("Pop attempted on an empty list.");
		T info = trailer.getInfo();
		if (trailer.getBack() != null) {
			trailer = (DLLNode<T>) trailer.getBack();
			trailer.setForward(null);
		} else {
			header = null;
			trailer = null;
		}
		size--;
		return info;
	}

	/**
	 * Time complexity are O(1).
	 * 
	 * @param element element to add to the end of the dlist
	 */
	public void push(T element) {
		addToLast(element);
	}

	public String toString() {
		if (isEmpty())
			return "";
		DLLNode<T> node = header;
		String result = "";
		while (node != null) {
			result += node.getInfo();
			result += "<=>";
			node = (DLLNode<T>) node.getForward();
		}
		result = result.substring(0, result.length() - 3);
		return result;
	}

	public void print() {
		DLLNode<T> v = header;
		while (v != null) {
			System.out.println(v.getInfo());
			v = v.getForward();
		}

	}

}