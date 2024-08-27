package org.juannn.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements Iterable<T> {

    private Node<T> head; // Reference to the first node in the list
    private Node<T> tail; // Reference to the last node in the list

    // Constructor to initialize an empty list
    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    // Adds a new element to the end of the list
    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            // If the list is empty, both head and tail will reference the new node
            head = newNode;
            tail = newNode;
        } else {
            // Add the new element after the current tail
            tail.setNextNode(newNode);
            // Set the previous node reference for the new node
            newNode.setPrevNode(tail);
            // Update the tail to point to the new node
            tail = newNode;
        }
    }

    // Adds a new element to the beginning of the list
    public void addFirst(T element) {
        Node<T> newNode = new Node<T>(element);
        if (head == null) {
            // If the list is empty, both head and tail will reference the new node
            head = newNode;
            tail = newNode;
        } else {
            // Set the new node's next to the current head
            newNode.setNextNode(head);
            // Update the current head's previous node reference
            head.setPrevNode(newNode);
            // Update the head to the new node
            head = newNode;
        }
    }

    // Returns the first node in the list
    public Node<T> getFirst() {
        return head;
    }

    // Returns the last node in the list
    public Node<T> getLast() {
        return tail;
    }

    // Checks if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Prints all elements in the list from head to tail
    public void printFoward() {
        Node<T> current = head;
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getNextNode();
        }
    }

    // Prints all elements in the list from tail to head
    public void printBackward() {
        Node<T> current = tail;
        while (current != null) {
            System.out.println(current.getElement());
            current = current.getPrevNode();
        }
    }

    // Removes and returns the first element in the list
    public T removeFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T element = head.getElement();
        head = head.getNextNode();
        if (head == null) {
            tail = null; // List is now empty
        } else {
            head.setPrevNode(null);
        }
        return element;
    }

    // Removes and returns the last element in the list
    public T removeLast() {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        T element = tail.getElement();
        tail = tail.getPrevNode();
        if (tail == null) {
            head = null; // List is now empty
        } else {
            tail.setNextNode(null);
        }
        return element;
    }

    // Implementation of the iterator for the list
    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = head; // Start from the head

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                T element = current.getElement();
                current = current.getNextNode(); // Move to the next node
                return element;
            }
        };
    }

    // Returns the size of the list by counting elements
    public int size() {
        int size = 0;
        Node<T> current = head;
        while (current != null) {
            size++;
            current = current.getNextNode();
        }
        return size;
    }

    // Removes a specific element from the list
    public T remove(T element) {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        if (element.equals(head.getElement())) {
            return removeFirst();
        }

        Node<T> current = head;
        while (current != null) {
            if (element.equals(current.getElement())) {
                if (current == tail) {
                    return removeLast();
                } else {
                    Node<T> prev = current.getPrevNode();
                    Node<T> next = current.getNextNode();
                    prev.setNextNode(next);
                    next.setPrevNode(prev);
                    return element;
                }
            }
            current = current.getNextNode();
        }
        throw new NoSuchElementException("Element not found");
    }
}
