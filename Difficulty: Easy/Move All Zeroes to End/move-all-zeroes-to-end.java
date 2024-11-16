//{ Driver Code Starts
// Initial Template for Java

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine());
        while (tc-- > 0) {
            String[] inputLine = br.readLine().split(" ");
            int[] arr = new int[inputLine.length];
            for (int i = 0; i < inputLine.length; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            new Solution().pushZerosToEnd(arr);
            int n = arr.length;
            for (int i = 0; i < n; i++) {
                System.out.print(arr[i] + " ");
            }
            System.out.println();
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    void pushZerosToEnd(int[] arr) {
        // code here
         int nonZeroIndex = 0; // Pointer for the position of non-zero elements  

        // Traverse the array  
        for (int i = 0; i < arr.length; i++) {  
            if (arr[i] != 0) {  
                // If the current element is non-zero, we move it to the front  
                arr[nonZeroIndex] = arr[i];  
                nonZeroIndex++;  
            }  
        }  

        // Fill the remaining positions with zeros  
        while (nonZeroIndex < arr.length) {  
            arr[nonZeroIndex] = 0;  
            nonZeroIndex++;
        }
    }
}