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

    ListNode InsertInLinkdedList(ListNode headNode, ListNode nodeToInsert, int position) {
        if (headNode == null) {
            return nodeToInsert;
        }
        int size = ListLength(headNode);
        if (position > size + 1 || position < 1) {
            System.out.println("Position of node to insert is invalid. The valid inputs are 1 to " + (size + 1));
        }
        if (position == 1) {
            nodeToInsert.setNext(headNode);
            return nodeToInsert;
        } else {
            ListNode previousNode = headNode;
            int count = 1;
            while(count < position - 1) {
                previousNode = previousNode.getNext();
                count++;
            }
            ListNode currentNode = previousNode.getNext();
            nodeToInsert.setNext(currentNode);
            previousNode.setNext(nodeToInsert);
        }
        return headNode;
    }

    ListNode DeleteNodeFromLinkedList(ListNode headNode, int position) {
        int size = ListLength(headNode);

        return headNode;
    }


    void DeleteLinkedList(ListNode head) {
        ListNode auxilaryNode, iterator = head;
        while (iterator != null) {
            auxilaryNode = iterator.getNext();
            iterator = null;
            iterator = auxilaryNode;
        }
    }

    public static void main(String[] args) {

    }
}
