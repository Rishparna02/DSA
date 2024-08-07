//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            int k = Integer.parseInt(br.readLine().trim());

            String[] line1 = br.readLine().trim().split(" ");
            int[] arr1 = new int[line1.length];
            for (int i = 0; i < line1.length; i++) {
                arr1[i] = Integer.parseInt(line1[i]);
            }

            String[] line2 = br.readLine().trim().split(" ");
            int[] arr2 = new int[line2.length];
            for (int i = 0; i < line2.length; i++) {
                arr2[i] = Integer.parseInt(line2[i]);
            }

            Solution ob = new Solution();
            System.out.println(ob.kthElement(k, arr1, arr2));
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public long kthElement(int k, int arr1[], int arr2[]) {
        // code here
        int m = arr1.length;
        int n = arr2.length;
        if (arr2.length < arr1.length) return kthElement(k, arr2, arr1);
        int low = Math.max(0, k - n); 
        int high = Math.min(k, m);
        int mid_mark = k;
        while(low <= high){
            int cut1 = (low + high) / 2;
            int cut2 = mid_mark - cut1; 
            long l1 = (cut1 == 0)? Long.MIN_VALUE : arr1[cut1 - 1];
            long l2 = (cut2 == 0)? Long.MIN_VALUE : arr2[cut2 - 1];
            long r1 = (cut1 == arr1.length)? Long.MAX_VALUE : arr1[cut1];
            long r2 = (cut2 == arr2.length)? Long.MAX_VALUE : arr2[cut2];
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1, l2);
            } 
            if (l1 > l2) high = cut1 - 1;
            else low = cut1 + 1;
        }
        return 1;
    }
}