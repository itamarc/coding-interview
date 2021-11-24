package io.github.itamarc;

public class MyLinkedList {
    Node head;
    Node tail;

    public static void main(String[] args) {
        MyLinkedList ll = new MyLinkedList();
        ll.add(10);
        ll.add(15);
        ll.add(18);
        ll.add(21);

        System.out.println("List:\n"+ll);

        System.out.println("Head and next:");
        System.out.println(ll.head.data);
        System.out.println(ll.head.next.data);

        System.out.println("Tail and previous:");
        System.out.println(ll.tail.data);
        System.out.println(ll.tail.previous.data);
    }

    /**
     * Add the data in the head of the linked list.
     * @param data
     */
    public void add(int data) {
        if (head == null) { // the list is empty
            head = tail = new Node(data);
        } else {
            Node newNode = new Node(data);
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    @Override
    public String toString() {
        Node n = head;
        if (n == null) {
            return "[]";
        } else {
            StringBuffer buf = new StringBuffer("[");
            while (n != tail) {
                buf.append(n.data);
                if (buf.length() > 1) {
                    buf.append(",");
                }
                n = n.next;
            }
            buf.append(tail.data+"]");
            return buf.toString();
        }
    }
}

class Node {
    int data;
    Node next;
    Node previous;

    Node(int data) {
        this.data = data;
    }
}
