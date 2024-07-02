//{ Driver Code Starts
import java.util.*;

class Node {
    String data;
    Node next;

    Node(String x) {
        data = x;
        next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() { head = null; }

    void addNode(String str) {
        if (head == null) {
            head = new Node(str);
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = new Node(str);
        }
    }

    void print() {
        Node temp = head;
        while (temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while (T-- > 0) {
            int K = sc.nextInt();
            LinkedList list = new LinkedList();

            for (int i = 0; i < K; i++) {
                String str = sc.next();
                list.addNode(str);
            }

            Solution ob = new Solution();
            boolean ans = ob.compute(list.head);
            if (ans) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
        }
        sc.close();
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    // Helper method to concatenate all strings in the linked list
    private String concatenateStrings(Node head) {
        StringBuilder combinedString = new StringBuilder();
        Node current = head;
        while (current != null) {
            combinedString.append(current.data);
            current = current.next;
        }
        return combinedString.toString();
    }

    // Helper method to check if a string is a palindrome
    private boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Main method to check if the combined string from the linked list is a palindrome
    public boolean compute(Node head) {
        String combinedString = concatenateStrings(head);
        return isPalindrome(combinedString);
    }

    public static void main(String[] args) {
        // Test case 1
        Node head1 = new Node("abc");
        head1.next = new Node("dd");
        head1.next.next = new Node("cba");

        Solution solution = new Solution();
        System.out.println(solution.compute(head1)); // Output: true

        // Test case 2
        Node head2 = new Node("abc");
        head2.next = new Node("d");
        head2.next.next = new Node("ba");

        System.out.println(solution.compute(head2)); // Output: false
    }
}
