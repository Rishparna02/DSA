//{ Driver Code Starts
import java.util.*;

// Define MyStack class here

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine(); // Flush the newline character left by nextInt
        while (T-- > 0) {
            MyStack sq = new MyStack();
            String line = scanner.nextLine();
            Scanner ss = new Scanner(line);
            List<Integer> nums = new ArrayList<>();
            while (ss.hasNextInt()) {
                int num = ss.nextInt();
                nums.add(num);
            }
            int n = nums.size();
            int i = 0;
            while (i < n) {
                int QueryType = nums.get(i++);
                if (QueryType == 1) {
                    int a = nums.get(i++);
                    sq.push(a);
                } else if (QueryType == 2) {
                    System.out.print(sq.pop() + " ");
                }
            }
            System.out.println();
        }
        scanner.close();
    }
}

// } Driver Code Ends


class MyStack {
    private int[] arr;
    private int top;
    private int capacity;

    public MyStack() {
        capacity = 1000;  // Set capacity first
        arr = new int[capacity];  // Initialize array with the capacity
        top = -1;
    }

    public void push(int x) {
        // Check for stack overflow
        if (top == capacity - 1) {
            // No output should be printed for overflow, but you can handle it
            return;
        } else {
            top++;
            arr[top] = x;
        }
    }

    public int pop() {
        // Check for stack underflow
        if (top == -1) {
            return -1;  // Just return -1 when stack is empty, no print statement
        } else {
            int x = arr[top];
            top--;
            return x;
        }
    }
}

