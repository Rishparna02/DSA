//{ Driver Code Starts
//Initial Template for Java


import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            Solution ob = new Solution();
            System.out.println(ob.evenlyDivides(N));
        }
    }
}
// } Driver Code Ends




//User function Template for Java


class Solution {
    static int evenlyDivides(int N) {
        int count = 0;
        int original = N;  // Store original value of N
        while (N > 0) {
            int lastDigit = N % 10;
            // Check if lastDigit is not zero and divides original N evenly
            if (lastDigit != 0 && original % lastDigit == 0) {
                count++;
            }
            N = N / 10;
        }
        return count;
    }
}
