//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class gfg {

    public static void main(String args[]) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());

        while (t-- > 0) {
            String st[] = read.readLine().trim().split("\\s+");
            int n = st.length;
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[(int)i] = Integer.parseInt(st[(int)i]);

            System.out.println(new Solution().maxStep(arr));
        }
    }
}

// } Driver Code Ends



class Solution {
    // Function to find maximum number of consecutive steps
    // to gain an increase in altitude with each step.
    public int maxStep(int arr[]) {
        
        int count =0 ; //will return the maximum jump to reach the higher altitude
        int n = arr.length; //size of an array
        int max = 0; // to keep a check on increasing altitudes
        
        for(int i= 1 ; i < n ; i++)
        {
            if(arr[i]>arr[i-1])
            {
                max++; //if our altitude is increasing we will keep a check through max variable
            }
            else{
                max = 0; //if we encounter a low altitude than the previous one then we will put our max value again to 0 so that we can find out the next better altitude if theres one
            }
            count = Math.max(count ,max); //we will keep updating our count variable
            
            
        }
        
        
    return count;
    }
}