//{ Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.isPanagram(S));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution {
    int isPanagram(String S) {
        boolean[] arr = new boolean[26];
        
        for (char ch : S.toCharArray()) {
            if (Character.isLetter(ch)) {
                arr[Character.toLowerCase(ch) - 'a'] = true;
            }
        }
        
        for (boolean seen : arr) {
            if (!seen) {
                return 0;
            }
        }
        
        return 1;
    }
}
