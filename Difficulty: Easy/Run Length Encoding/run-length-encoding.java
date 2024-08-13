//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t;
        t = Integer.parseInt(br.readLine());
        while(t-- > 0){
            
            String s;
            s = br.readLine();
            
            Solution obj = new Solution();
            String res = obj.encode(s);
            
            System.out.println(res);
            
        }
    }
}

// } Driver Code Ends


class Solution {
    public static String encode(String s) {
        int n = s.length();
        StringBuilder result = new StringBuilder();
        int i = 0;

        while (i < n) {
            char curr = s.charAt(i);
            int count = 0;

            // Count occurrences of the current character
            while (i < n && s.charAt(i) == curr) {
                i++;
                count++;
            }

            // Append the character to the result
            result.append(curr);

            // Append the count (including when it's 1)
            result.append(count);
        }

        return result.toString();
    }
}

    