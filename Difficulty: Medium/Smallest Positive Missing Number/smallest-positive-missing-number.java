//{ Driver Code Starts
import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // Reading number of test cases (t)
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            // Read the line of integers (prices)
            String input = br.readLine().trim();

            // Split the input line into integers and store in an array
            String[] tokens = input.split(" ");
            int[] arr = new int[tokens.length];
            for (int i = 0; i < tokens.length; i++) {
                arr[i] = Integer.parseInt(tokens[i]);
            }

            // Create an instance of the Solution class
            Solution ob = new Solution();

            // Call the missingNumber method
            int res = ob.missingNumber(arr);

            // Print the result
            System.out.println(res);

            // Print the "~" symbol to match the original output
            // System.out.println("~");
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find the smallest positive number missing from the array.
    public int missingNumber(int[] arr) {
        // Your code here
        int n = arr.length;

        // Step 1: Segregate positive and non-positive numbers
        int j = 0; // Index for segregation
        for (int i = 0; i < n; i++) {
            if (arr[i] <= 0) {
                // Swap non-positive numbers to the front
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }

        // Step 2: Mark presence of numbers in the positive portion
        for (int i = j; i < n; i++) {
            int num = Math.abs(arr[i]);
            if (num <= n - j) { // Ensure index is within bounds
                int idx = j + num - 1;
                if (arr[idx] > 0) { // Mark presence
                    arr[idx] = -arr[idx];
                }
            }
        }

        // Step 3: Find the smallest missing positive
        for (int i = j; i < n; i++) {
            if (arr[i] > 0) {
                return i - j + 1;
            }
        }

        // If all numbers are present, return n-j+1
        return n - j + 1;
    }
}
