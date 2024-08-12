//{ Driver Code Starts
// Initial Template for Java

import java.util.*;


// } Driver Code Ends
// User function Template for Java

class Solution {
    public int SumofMiddleElements(int[] arr1, int[] arr2) {
        // code here
        int n = arr1.length;
        int low = 0, high = n-1, mid = 0;
        while (low <= high){
            mid = (low + high)/2;
            int midSecond = n-mid-1;
            int first1 = mid>0?arr1[mid-1]:Integer.MIN_VALUE;
            int second1 = arr1[mid];
            int first2 = midSecond>0?arr2[midSecond-1]:Integer.MIN_VALUE;
            int second2 = arr2[midSecond];
            int third1 = mid+1<n?arr1[mid+1]:Integer.MAX_VALUE;
            int third2 = midSecond+1<n?arr2[midSecond+1]:Integer.MAX_VALUE;
            int mx = Math.max(second1, second2);
            if (mx <= third1 && mx <= third2){
                return mx+Math.max(Math.max(first1, first2),Math.min(second1, second2));
            }
            else if(mx > third1){
                low = mid + 1;
            }
            else {
                high = mid - 1;
            }
        }
        return 0;
    }
}

//{ Driver Code Starts.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume newline
        while (t-- > 0) {
            String[] input1 = sc.nextLine().split(" ");
            int[] arr = new int[input1.length];
            for (int i = 0; i < input1.length; i++) {
                arr[i] = Integer.parseInt(input1[i]);
            }

            String[] input2 = sc.nextLine().split(" ");
            int[] brr = new int[input2.length];
            for (int i = 0; i < input2.length; i++) {
                brr[i] = Integer.parseInt(input2[i]);
            }

            Solution ob = new Solution();
            int res = ob.SumofMiddleElements(arr, brr);
            System.out.println(res);
        }
    }
}

// } Driver Code Ends