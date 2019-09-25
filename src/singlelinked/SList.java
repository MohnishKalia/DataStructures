package singlelinked;

import support.LLNode;

public class SList<T> {
    protected LLNode<T> list;
    protected int numElements;

    public SList() {
        numElements = 0;
        list = null;
    }

    public LLNode<T> getList() {
        return list;
    }

    public void setList(LLNode<T> list) {
        this.list = list;
    }

    public int getNumElements() {
        return numElements;
    }

    public void setNumElements(int numElements) {
        this.numElements = numElements;
    }

    // adds the element to the front of the list
    public void add(T element) {
        LLNode<T> newNode = new LLNode<T>(element);
        newNode.setLink(list);
        list = newNode;
        numElements++;
    }

    /**
     * Adds the element to the end of the list. Time complexity is O(n)
     * 
     * @param element desired element to add
     */
    public void insertLast(T element) {
        if (list == null)
            add(element); // use the standard implementation if there are no other nodes
        else {
            LLNode<T> newNode = new LLNode<T>(element);
            LLNode<T> deepestNode = list;
            while (deepestNode.getLink() != null)
                deepestNode = deepestNode.getLink(); // search for the node with no links (should be at the end)
            deepestNode.setLink(newNode);
            numElements++;
        }
    }

    public String toString() {
        LLNode<T> node = list;
        String result = "";
        while (node != null) {
            result += node.getInfo();
            result += "-->";
            node = node.getLink();
        }
        result = result.substring(0, result.length() - 3);
        return result;
    }

    /**
     * Returns if the 2 objects are equal. Time complexity is O(1)
     * 
     * @param other object to test
     */
    @Override
    public boolean equals(Object other) {
        return other.toString().equals(this.toString());
    }

}