//{ Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(n, arr)); 
        }
    }
    
    
}
// } Driver Code Ends



class solve
{
    static long help(int i,int j,int arr[], long dp[][]){
    if(i>j) return 0;
        if (dp[i][j]!=-1) return dp[i][j];
        long sum1 = arr[i], sum2=arr[j];
        sum1 += Math.min(help (i+2, j, arr, dp), help(i+1,j-1,arr,dp));
        sum2 += Math.min(help(i+1,j-1,arr,dp), help(i,j-2,arr,dp));
        return dp[i][j] = Math.max(sum1,sum2);
}    
    static long countMaximum(int n, int arr[])
    {
        long dp[][] = new long[n][n];
        for(long temp[]: dp) Arrays.fill(temp,-1);
        return help(0,n-1,arr,dp);
    }
    
}
