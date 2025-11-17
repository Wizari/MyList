package com.gmail.wizaripost;

import java.util.*;

public class MyLinkedList implements List<Integer> {

    Integer size = 0;
    Node first = null;
    Node last = null;


    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator<Integer> iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return null;
    }

    @Override
    public boolean add(Integer integer) {
        Node node = new Node(integer, null);
        if (last != null) {
            last.next = node;
            size++;
            last = node;
        } else if (first != null) {
            first.next = node;
            size++;
            last = node;
        } else  {
            first = node;
            size++;
        }
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends Integer> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public Integer get(int index) {
        if (index > size || index < 0) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        if (index == 0) {
            return this.first.item;
        }
        if (index == size){
            return this.last.item;
        }
        Node node = this.first.next;
        for (int i = 0; i < size; i++) {
            if (index == i + 1) {
                return node.item;
            }
            node = node.next;
        }
        throw new IllegalStateException("Index: " + index);
    }

    @Override
    public Integer set(int index, Integer element) {
        return 0;
    }

    @Override
    public void add(int index, Integer element) {

    }

    @Override
    public Integer remove(int index) {
        return 0;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public ListIterator<Integer> listIterator() {
        return null;
    }

    @Override
    public ListIterator<Integer> listIterator(int index) {
        return null;
    }

    @Override
    public List<Integer> subList(int fromIndex, int toIndex) {
//        return List.of();
        return null;
    }

    private static class Node {
        Integer item;
        Node next;

        Node(Integer item, Node next) {
            this.item = item;
            this.next = next;
        }
    }


}
