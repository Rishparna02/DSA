//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();

            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Static method to find the longest palindromic substring
    static String longestPalindrome(String s) {
        // code here
        String res = ""; // Store the longest palindrome
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                if (helper(s, i, j)) { // Check if substring s[i...j] is a palindrome
                    if (j - i + 1 > res.length()) {
                        res = s.substring(i, j + 1);
                    }
                }
            }
        }
        return res;
    }

    // Helper function to check if a substring is a palindrome
    static boolean helper(String s, int start, int end) {
        while (start < end) {
            if (s.charAt(start) != s.charAt(end)) {
                return false; // Mismatch found
            }
            start++;
            end--;
        }
        return true;
    }
}