//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;
import java.util.stream.*;

class GFG {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {
            String s1 = br.readLine(); // first string
            String s2 = br.readLine(); // second string

            Solution obj = new Solution();

            if (obj.areAnagrams(s1, s2)) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean areAnagrams(String s1, String s2) {

        // Your code here
        int n = s1.length(), m = s2.length();
        if(n != m) return false;
        int[] hash = new int[26];
        
        for(int i = 0; i < n; i++){
            char ch1 = s1.charAt(i);
            char ch2 = s2.charAt(i);
            hash[ch1-'a']++;
            hash[ch2-'a']--;
        }
        
        for(int i = 0; i < 26; i++){
            if(hash[i] != 0) return false;
        }
        
        return true;
    }
}