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
            String str = br.readLine();
            String s1 = str.split(" ")[0];
            String s2 = str.split(" ")[1];

            Solution obj = new Solution();

            if (obj.isAnagram(s1, s2)) {
                System.out.println("YES");
            } else {
                System.out.println("NO");
            }
        }
    }
}
// } Driver Code Ends

class Solution {
    // Function is to check whether two strings are anagram of each other or not.
    public static boolean isAnagram(String s1, String s2) {
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();
        if (s1.length() != s2.length()) {
            return false;
        }
        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();
        for (char c : s1.toCharArray()) {
            if (Character.isLetter(c)) {
                freq1.put(c, freq1.getOrDefault(c, 0) + 1);
            }
        }
        for (char c : s2.toCharArray()) {
            if (Character.isLetter(c)) {
                freq2.put(c, freq2.getOrDefault(c, 0) + 1);
            }
        }

        if (freq1.equals(freq2)) {
            return true;
        } else {
            return false;
        }
    }
}

