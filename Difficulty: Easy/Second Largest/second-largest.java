//{ Driver Code Starts
// Initial Template for Java
import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            String[] arr1Str = sc.nextLine().split(" ");
            int[] arr = Arrays.stream(arr1Str).mapToInt(Integer::parseInt).toArray();
            Solution ob = new Solution();
            int ans = ob.getSecondLargest(arr);
            System.out.println(ans);

            System.out.println("~");
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int FirstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++){
            if(arr[i] > FirstLargest){
                secondLargest =FirstLargest ;
                FirstLargest =arr[i]; 
            }
            else if((arr[i] > secondLargest) && (arr[i]!= FirstLargest)){
                secondLargest = arr[i];
            }
        }
        if(secondLargest == Integer.MIN_VALUE){
            return -1;
        }
        return secondLargest;

        
    }
}