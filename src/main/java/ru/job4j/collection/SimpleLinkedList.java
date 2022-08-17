package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class SimpleLinkedList<E> implements LinkedList<E> {
    private int size;
    private int modCount;
    private Node<E> first;

    @Override
    public void add(E value) {
        Node<E> newNode = new Node<>(value, null);
        if (first == null) {
            first = newNode;
            size++;
            modCount++;
            return;
        }
        Node<E> last = first;
        while (last.next != null) {
            last = last.next;
        }
        last.next = newNode;
        size++;
        modCount++;
    }

    @Override
    public E get(int index) {
        Objects.checkIndex(index, size);
        Node<E> ans = first;
        for (int i = 0; i < index; i++) {
            ans = ans.next;
        }
        return ans.item;
    }

    @Override
    public Iterator<E> iterator() throws NoSuchElementException, ConcurrentModificationException {
        return new Iterator<E>() {
            private int expectedModCount = modCount;
            private Node<E> point = first;

            @Override
            public boolean hasNext() {
                if (expectedModCount != modCount) {
                    throw new ConcurrentModificationException();
                }
                return point != null;
            }

            @Override
            public E next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                E ans = point.item;
                point = point.next;
                return ans;
            }
        };
    }

    private static class Node<E> {
        E item;
        Node<E> next;

        Node(E element, Node<E> next) {
            this.item = element;
            this.next = next;
        }
    }
}