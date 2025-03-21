//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String inputLine[] = br.readLine().trim().split(" ");
            int n = inputLine.length;
            int arr[] = new int[n];
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            // calling method findMaxSum() of class solve
            System.out.println(new Solution().findMaxSum(arr));
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    public int findMaxSum(int arr[]) {
        // code here
        if (arr.length == 0) return 0;  
        if (arr.length == 1) return arr[0];  

        int prev2 = 0;
        int prev = arr[0];

        for (int i = 1; i < arr.length; i++) {
            int take = arr[i];
            if (i > 1) take += prev2;
            int notTake = prev;

            int curr = Math.max(take, notTake);
            prev2 = prev;
            prev = curr;
        }
        return prev;
    }
}