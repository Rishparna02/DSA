//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
import java.math.BigInteger;


// } Driver Code Ends
//User function Template for Java

class Solution {

    // Function to count the total set bits in all numbers from 1 to n.
    public static int countSetBits(int n) {
        if (n == 0) 
            return 0;

        // Find the largest power of 2 less than or equal to n
        long x = larPowOf2(n);
        
        // Calculate the number of set bits till the largest power of 2
        long y = x * (1L << (x - 1));
        
        // Remaining numbers after subtracting the largest power of 2
        long z = n - (1L << x);
        
        // Recursively count the set bits in the remaining part
        return (int)(y + z + 1 + countSetBits((int)z));
    }

    // Function to find the largest power of 2 less than or equal to n
    static long larPowOf2(long n) {
        long x = 0;
        // Find the largest power of 2 by bit shifting
        while ((1L << x) <= n) {
            x++;
        }
        return x - 1;
    }
}




//{ Driver Code Starts.

// Driver code
class Main {
	public static void main(String[] args) throws NumberFormatException, IOException {
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();//testcases
		int x, n;
		while(t-->0) {
	        n = sc.nextInt();//input n

		    Solution obj = new Solution();

		    System.out.println(obj.countSetBits(n));//calling countSetBits() method
		}
	}
}

// } Driver Code Ends