//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG
{
	public static void main(String[] args) throws IOException
	{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t-->0)
        {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[(int)n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            
            Solution obj = new Solution();  
            System.out.println(obj.countPairs(a, n));
            
        }
	}
}

// } Driver Code Ends


//User function Template for Java


class Solution {  
    static int countPairs(int arr[], int n) 
    {
        int res[] = new int[n];
        for(int i=0;i<n;i++){
            res[i]=i*arr[i];
        }
        return mergeSort(res,0,n-1);
    }
    static int merge(int[] a,int low, int mid, int high){
        int[] temp = new int [high-low + 1];
        int left = low;
        int right = mid+1;
        int cnt = 0;
        int k=0;
        while(left<=mid && right <= high){
            if (a[left] <= a[right]){
                temp[k++] = a[left++];
            }
            else {
                cnt += mid-left+1;
                temp[k++]=a[right++];
            }
        }
        while (left <= mid){
            temp[k++] = a[left++];
        }
        while (right<=high){
            temp[k++] = a[right++];
        }
        for (int i=low; i<=high; i++){
            a[i]=temp[i-low];
        }
        return cnt;
    }
    static int mergeSort(int[] a, int low, int high){
        int cnt=0;
        if (low < high){
            int mid = (low+high) /2;
            cnt += mergeSort(a,low,mid);
            cnt += mergeSort(a,mid+1,high);
            cnt += merge(a,low,mid,high);
        }
        return cnt;
    }
}
