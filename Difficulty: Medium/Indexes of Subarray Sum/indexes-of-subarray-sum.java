//{ Driver Code Starts
import java.io.*;
import java.util.*;

class IntArray {
    public static int[] input(BufferedReader br, int n) throws IOException {
        String[] s = br.readLine().trim().split(" ");
        int[] a = new int[n];
        for (int i = 0; i < n; i++) a[i] = Integer.parseInt(s[i]);

        return a;
    }

    public static void print(int[] a) {
        for (int e : a) System.out.print(e + " ");
        System.out.println();
    }

    public static void print(ArrayList<Integer> a) {
        StringBuilder sb = new StringBuilder();
        for (int e : a) sb.append(e + " ");
        System.out.println(sb);
    }
}

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int t;
        t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String str[] = br.readLine().trim().split(" ");

            int n = Integer.parseInt(str[0]);
            int s = Integer.parseInt(str[1]);

            int[] arr = IntArray.input(br, n);

            Solution obj = new Solution();
            ArrayList<Integer> res = obj.subarraySum(arr, n, s);

            IntArray.print(res);
        }
    }
}

// } Driver Code Ends



class Solution {
    public static ArrayList<Integer> subarraySum(int[] arr, int n, int s) {
        // To store the result (left and right index)
        ArrayList<Integer> result = new ArrayList<>();

        // Initialize variables
        int currentSum = arr[0];
        int start = 0;

        // Traverse the array
        for (int end = 1; end <= n; end++) {
            // Reduce the window size if currentSum exceeds s
            while (currentSum > s && start < end - 1) {
                currentSum -= arr[start];
                start++;
            }

            // Check if we found the subarray with sum equal to s
            if (currentSum == s) {
                result.add(start + 1); // 1-based index for left
                result.add(end); // 1-based index for right
                return result;
            }

            // Add the current element to currentSum if end is within array bounds
            if (end < n) {
                currentSum += arr[end];
            }
        }

        // If no subarray found, return -1
        result.add(-1);
        return result;
    }
}
