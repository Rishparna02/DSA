//{ Driver Code Starts
import java.io.*;
import java.util.*;

class Node {
    int data;
    Node next;
    Node prev;

    Node(int x) {
        data = x;
        next = null;
        prev = null;
    }

    public static void printList(Node node) {
        while (node != null) {
            System.out.print(node.data + " ");
            node = node.next;
        }
        System.out.println();
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            Node head = null;
            Node tail = head;

            for (int i = 0; i < n; i++) {
                int temp = sc.nextInt();
                if (head == null) {
                    head = new Node(temp);
                    tail = head;
                } else {
                    Node newNode = new Node(temp);
                    tail.next = newNode;
                    newNode.prev = tail;
                    tail = newNode;
                }
            }
            int x = sc.nextInt();

            Solution obj = new Solution();
            Node res = obj.deleteNode(head, x);

            Node.printList(res);
        }
    }
}

// } Driver Code Ends


/*

Definition for doubly Link List Node
class Node
{
    int data;
    Node next;
    Node prev;
    Node(int x){
        data = x;
        next = null;
        prev = null;
    }
}
*/
class Solution {
    public Node deleteNode(Node head, int x) {
        if (head == null || x<=0){
            return head;
        }
        if (x == 1){
            Node newHead = head.next;
            if(newHead != null){
                newHead.prev = null;
            }
            head.next = null;
            return newHead;
        }
        Node current = head;

        // Traverse to the node at position `x`
        for (int i = 1; i < x && current != null; i++) {
            current = current.next;
        }

        if (current == null) {
            return head; // Return head if x is out of bounds
        }

        // Update the previous node's next pointer
        if (current.prev != null) {
            current.prev.next = current.next;
        }

        // Update the next node's previous pointer
        if (current.next != null) {
            current.next.prev = current.prev;
        }

        // Disconnect the current node from the list
        current.next = current.prev = null;

        return head;
    }

    }

