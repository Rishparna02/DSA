//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main (String[] args)
    {
        
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            String s = sc.next ();
            int k = sc.nextInt();
    		System.out.println (new Solution().substrCount (s, k));
        }
        
    }
}
// } Driver Code Ends


//User function Template for Java



class Solution {

    public int substrCount(String S, int K) {
        // Result is the difference between substrings with at most K distinct and at most (K - 1) distinct
        return countAtMostKDistinct(S, K) - countAtMostKDistinct(S, K - 1);
    }

    // Helper function to count substrings with at most k distinct characters
    private int countAtMostKDistinct(String S, int K) {
        if (K == 0) return 0; // Edge case, no substrings possible with 0 distinct characters
        
        HashMap<Character, Integer> freqMap = new HashMap<>();
        int start = 0, end = 0;
        int count = 0;  // This will store the number of substrings
        int distinctCount = 0;  // This tracks the number of distinct characters in the window
        
        while (end < S.length()) {
            // Expand the window by including the current character
            char endChar = S.charAt(end);
            freqMap.put(endChar, freqMap.getOrDefault(endChar, 0) + 1);
            if (freqMap.get(endChar) == 1) {  // New distinct character
                distinctCount++;
            }
            
            // Shrink the window if there are more than K distinct characters
            while (distinctCount > K) {
                char startChar = S.charAt(start);
                freqMap.put(startChar, freqMap.get(startChar) - 1);
                if (freqMap.get(startChar) == 0) {
                    distinctCount--;  // We lost a distinct character
                }
                start++;  // Shrink the window from the left
            }
            
            // Count the valid substrings from start to end
            count += end - start + 1;
            end++;
        }
        
        return count;
    }
}