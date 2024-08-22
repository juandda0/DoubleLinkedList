package org.juannn.data_structures;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DoubleLinkedList<T> implements Iterable<T>{

    private Node<T> head;
    private Node<T> tail;

    public DoubleLinkedList() {
        head = null;
        tail = null;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else{
            tail.setNextNode(newNode); //add the new element after the current list
            newNode.setPrevNode(tail); // Sets the previous node
            tail = newNode; // update the tail to point the new node
        }
    }

    public void addFirst(T element) {
        Node<T> newNode = new Node<>(element);
        if(head == null){
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNextNode(head);
            head.setPrevNode(newNode);
            head = newNode;
        }
    }

    public Node<T> getFirst() {
        return head;
    }

    public Node<T> getLast() {
        return tail;
    }

    public boolean isEmpty() {
        return head == null;
    }

    public void printFoward(){
        Node<T> current = head;
        while (current != null){
            System.out.println(current.getElement());
            current = current.getNextNode();
        }
    }

    public void printBackward(){
        Node<T> current = tail;
        while (current != null){
            System.out.println(current.getElement());
            current = current.getPrevNode();
        }
    }

    public T removeFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        T element = head.getElement();
        head = head.getNextNode();
        if(head == null){
            tail = null;
        } else {
            head.setPrevNode(null);
        }
        return element;
    }

    public T removeLast(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        T element = tail.getElement();
        tail = tail.getPrevNode();
        if(tail == null){
             head = null;
        } else {
            tail.setPrevNode(null);
        }
        return element;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {

            private Node<T> current = head;

            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                T element = current.getElement();
                current = current.getNextNode();
                return element;
            }
        };
    }
}
