//{ Driver Code Starts
import java.io.*;
import java.lang.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        while (t-- > 0) {
            int size = Integer.parseInt(br.readLine());
            String[] arrStr = ((String)br.readLine()).split("\\s+");
            int[] arr = new int[size];
            for (int i = 0; i < size; i++) {
                arr[i] = Integer.parseInt(arrStr[i]);
            }
            System.out.println(new Solution().minJumps(arr, size));
        }
    }
}

// } Driver Code Ends


class Solution {
    static int minJumps(int[] arr, int n) {
        if (n == 1) return 0; // already at the last element
        if (arr[0] == 0) return -1; // cannot move forward if the first element is 0

        int maxReach = arr[0]; // max index we can currently reach
        int steps = arr[0];    // steps we can still take before we need another jump
        int jumps = 1;         // at least one jump is needed

        for (int i = 1; i < n; i++) {
            // if we have reached the last element
            if (i == n - 1) return jumps;

            // update maxReach
            maxReach = Math.max(maxReach, i + arr[i]);

            // we use a step to get to the current index
            steps--;

            // if no further steps left
            if (steps == 0) {
                jumps++; // we must have used a jump

                // if the current index is greater than or equal to maxReach, we can't move forward
                if (i >= maxReach) return -1;

                // re-initialize the steps to the number of steps to reach maxReach from the current index
                steps = maxReach - i;
            }
        }
        return -1; // if end is not reached
    }
}
