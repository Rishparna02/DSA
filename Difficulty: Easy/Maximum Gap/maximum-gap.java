//{ Driver Code Starts
import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        while (t-- > 0) {

            String line = br.readLine();
            String[] tokens = line.split(" ");

            // Create an ArrayList to store the integers
            ArrayList<Integer> array = new ArrayList<>();

            // Parse the tokens into integers and add to the array
            for (String token : tokens) {
                array.add(Integer.parseInt(token));
            }

            int[] arr = new int[array.size()];
            int idx = 0;
            for (int i : array) arr[idx++] = i;

            int ans = new Solution().maxSortedAdjacentDiff(arr);
            System.out.println(ans);
            System.out.println("~");
        }
    }
}
// } Driver Code Ends


class Solution {
    int maxSortedAdjacentDiff(int[] arr) {
        // code here
        Arrays.sort(arr);
        int maxDiff = 0; 
        for(int i = 1; i < arr.length; i++){
            maxDiff = Math.max(maxDiff, arr[i] - arr[i - 1]);
        }
        return maxDiff;
    }
}