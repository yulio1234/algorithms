package com.yuli.algorithms.list;

import java.util.Iterator;

/**
 * 描述：背包数据结构
 *
 * @author yuli
 * @date 2020/8/1
 */
public class Bag<ITEM> implements Iterable<ITEM> {
    private Node head;//链表头部

    private class Node {
        ITEM item;
        Node next;
    }

    public void add(ITEM item) {
        Node oldNode = head;
        Node newNode = new Node();
        newNode.item = item;
        newNode.next = oldNode;
        head = newNode;
    }

    private class ListIterator implements Iterator<ITEM> {
        private Node current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public ITEM next() {
            ITEM item = current.item;
            current = current.next;

            return item;
        }
    }

    @Override
    public Iterator<ITEM> iterator() {
        return new ListIterator();
    }

    public static void main(String[] args) {
        Bag<Integer> integers = new Bag<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        for (Integer integer : integers) {
            System.out.println(integer);
        }
    }
}
