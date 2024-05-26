//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;
import java.lang.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S = read.readLine();
            Solution ob = new Solution();
            int ans = ob.smallestSubstring(S);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public int smallestSubstring(String S) {
        int ans = Integer.MAX_VALUE,j=0,total=0;
        int arr[] = new int[3];
        Arrays.fill(arr,0);
        for(int i=0;i<S.length();i++){
            arr[S.charAt(i)-'0']++;
            if(arr[S.charAt(i)-'0']==1)total++;
            if(total==3){
                while(j<i && arr[S.charAt(j)-'0']>1){
                    arr[S.charAt(j)-'0']--;
                    j++;
                }
                ans = Math.min(ans,i-j+1);
            }
        }
        return ans!=Integer.MAX_VALUE?ans:-1;
    }
};
