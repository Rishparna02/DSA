//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class Main {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine().trim());

        while (t-- > 0) {
            // Reading the first array
            String line1 = read.readLine().trim();
            String[] numsStr1 = line1.split(" ");
            int[] a = new int[numsStr1.length];
            for (int i = 0; i < numsStr1.length; i++) {
                a[i] = Integer.parseInt(numsStr1[i]);
            }

            // Reading the second array
            String line2 = read.readLine().trim();
            String[] numsStr2 = line2.split(" ");
            int[] b = new int[numsStr2.length];
            for (int i = 0; i < numsStr2.length; i++) {
                b[i] = Integer.parseInt(numsStr2[i]);
            }

            // Creating an instance of the Solution class
            Solution ob = new Solution();

            // Calling doUnion method and printing the result
            System.out.println(ob.doUnion(a, b));
        }
    }
}

// } Driver Code Ends


// User function Template for Java


class Solution {
    public static int doUnion(int arr1[], int arr2[]) {
        // Create a HashSet to store the union of the two arrays
        HashSet<Integer> set = new HashSet<>();
        
        // Add all elements from the first array to the set
        for (int i = 0; i < arr1.length; i++) {
            set.add(arr1[i]);
        }
        
        // Add all elements from the second array to the set
        for (int i = 0; i < arr2.length; i++) {
            set.add(arr2[i]);
        }
        
        // The size of the set represents the number of distinct elements in the union
        return set.size();
    }
    
    public static void main(String[] args) {
        Solution ob = new Solution();
        int arr1[] = {85, 25, 1, 32, 54, 6};
        int arr2[] = {85, 2};
        
        // Call doUnion and print the result
        System.out.println(ob.doUnion(arr1, arr2)); // Output: 7
    }
}
