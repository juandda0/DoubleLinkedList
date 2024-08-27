package org.juannn.data_structures;

public class Node<T> {

    private T element; // The element stored in the node
    private Node<T> nextNode; // Pointer to the next node in the list
    private Node<T> prevNode; // Pointer to the previous node in the list

    // Constructor to initialize a new node with an element
    public Node(T element) {
        this.element = element; // Set the element of the node
        nextNode = null; // Initialize nextNode as null
        prevNode = null; // Initialize prevNode as null
    }

    // Getter for the element
    public T getElement() {
        return element;
    }

    // Getter for the next node
    public Node<T> getNextNode() {
        return nextNode;
    }

    // Setter for the next node
    public void setNextNode(Node<T> nextNode) {
        this.nextNode = nextNode;
    }

    // Getter for the previous node
    public Node<T> getPrevNode() {
        return prevNode;
    }

    // Setter for the previous node
    public void setPrevNode(Node<T> prevNode) {
        this.prevNode = prevNode;
    }
}
