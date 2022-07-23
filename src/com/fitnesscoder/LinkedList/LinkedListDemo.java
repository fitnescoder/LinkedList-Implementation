package com.fitnesscoder.LinkedList;

public class LinkedListDemo {

    public static Node insertAtHead(int data, Node head) {
        if(head==null) {
            head=new Node(data);
            return head;
        }

        Node temp=new Node(data);
        temp.next=head;
        head=temp;
        return head;
    }

    public static Node insertAtTail(int data, Node tail) {
        tail.next=new Node(data);
        tail=tail.next;
        return tail;
    }

    public static Node insertAt(int position, int data, Node head) {
        if(position==1) {
            return insertAtHead(data, head);
        }
        Node curr=head;

        int count=1;
        while(count<position && curr!=null) {
            curr=curr.next;
            count++;
        }

        Node forward=curr.next;
        Node temp=new Node(data);
        curr.next=temp;
        temp.next=forward;
        return head;
    }

    public static void deleteAt(int pos, Node head) {
        Node curr=head;

        int count=1;

        while(count<pos-1 && curr!=null) {
            curr=curr.next;
            count++;
        }

        if(curr!=null) {
            Node forward=curr.next.next;
            curr.next=forward;
        }
    }

    public static void main(String[] args) {

        Node head=null;
        Node tail=null;

        head=insertAtHead(10,head);
        tail=head;
        head=insertAtHead(15,head);
        tail=insertAtTail(20,tail);
        tail=insertAtTail(30,tail);

        System.out.println("===After Insertion at Head and Tail===");
        printLL(head);
        insertAt(3,45,head);
        head=insertAt(1,25,head);
        System.out.println("===Insertion at Position===");
        printLL(head);
        deleteAt(4, head);
        System.out.println("===After Delete Operation===");
        printLL(head);

    }

    private static void printLL(Node head) {

        Node curr=head;

        while(curr!=null) {
            System.out.print(curr.data+" ");
            curr=curr.next;
        }
        System.out.println();
    }
}
