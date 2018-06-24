package com.power.algorithms;

public class ListNodeMain {

    public static int ListLength(ListNode headNode) {
        int length = 0;
        ListNode currentNode = headNode;
        while (currentNode != null) {
            length++;
            currentNode = currentNode.getNext();
        }
        return length;
    }

    public static void main(String[] args) {

    }
}
