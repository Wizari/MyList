package com.gmail.wizaripost;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class MyLinkedListTest {

    private MyLinkedList list;

    @BeforeEach
    void setUp() {
        list = new MyLinkedList();
    }

    @Test
    @DisplayName("Пустой список имеет размер 0")
    void testIsEmptyOnCreation() {
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Добавление элемента увеличивает размер")
    void testAddIncreasesSize() {
        list.add(42);
        assertEquals(1, list.size());
        assertFalse(list.isEmpty());
    }

    @Test
    @DisplayName("Можно получить добавленный элемент по индексу")
    void testGetReturnsCorrectElement() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertEquals(10, list.get(0));
        assertEquals(20, list.get(1));
        assertEquals(30, list.get(2));
    }

    @Test
    @DisplayName("Индекс за пределами вызывает IndexOutOfBoundsException")
    void testGetThrowsOnInvalidIndex() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(0));
        list.add(100);
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    @DisplayName("Remove удаляет элемент и возвращает true")
    void testRemoveByIndex() {
        list.add(10);
        list.add(20);
        list.add(30);

        Integer removed = list.remove(1); // удаляем 20
        assertEquals(20, removed);
        assertEquals(2, list.size());
        assertEquals(30, list.get(1));
    }

    @Test
    @DisplayName("Remove по значению работает корректно")
    void testRemoveByValue() {
        list.add(10);
        list.add(20);
        list.add(30);

        assertTrue(list.remove(Integer.valueOf(20)));
        assertEquals(2, list.size());
        assertEquals(30, list.get(1));
    }

    @Test
    @DisplayName("Clear очищает список")
    void testClear() {
        list.add(1);
        list.add(2);
        list.clear();
        assertTrue(list.isEmpty());
        assertEquals(0, list.size());
    }

    @Test
    @DisplayName("Iterator работает корректно")
    void testIterator() {
        list.add(1);
        list.add(2);
        list.add(3);

        Iterator<Integer> it = list.iterator();
        assertTrue(it.hasNext());
        assertEquals(1, it.next());
        assertEquals(2, it.next());
        assertEquals(3, it.next());
        assertFalse(it.hasNext());
    }

    @Test
    @DisplayName("Iterator выбрасывает NoSuchElementException при обходе конца")
    void testIteratorThrowsOnExtraNext() {
        list.add(99);
        Iterator<Integer> it = list.iterator();
        it.next();
        assertThrows(NoSuchElementException.class, it::next);
    }

    @Test
    @DisplayName("Поддержка foreach")
    void testForEachLoop() {
        list.add(100);
        list.add(200);

        int sum = 0;
        for (Integer val : list) {
            sum += val;
        }
        assertEquals(300, sum);
    }

    @Test
    @DisplayName("add(index, element)")
    void testAddForIndex() {
        list.add(0, 0);
        list.add(1, 11);
        list.add(2, 22);

        System.out.println(list.get(0));
        System.out.println(list.get(1));
        System.out.println(list.get(2));
//        System.out.println(list.get(3));
        System.out.println();
        System.out.println();
        System.out.println();

        assertEquals(0, list.get(0));
        assertEquals(11, list.get(1));
        assertEquals(22, list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        list.add(1, 33);
        assertEquals(0, list.get(0));
        assertEquals(33, list.get(1));
        assertEquals(11, list.get(2));
        assertEquals(22, list.get(3));
        assertEquals(22, list.get(4));
    }






//    @Test
//    @DisplayName("GetNode()")
//    void GetNode() {
//        list.add(0);
//        list.add(11);
//        list.add(2222);
//        list.add(33);
//
//        System.out.println(list.getNode(0));
//        System.out.println(list.getNode(1));
//        System.out.println(list.getNode(2));
//        System.out.println(list.getNode(3));
//
//    }

    // Добавь другие тесты по мере реализации методов:
    // - add(index, element)
    // - set(index, element)
    // - indexOf()
    // - contains()
    // - equals(), hashCode()
    // - конструктор с коллекцией


//        System.out.println(list.getNode(0));
//        System.out.println(list.getNode(1));
//        System.out.println(list.getNode(2));
//        System.out.println(list.getNode(3));
}