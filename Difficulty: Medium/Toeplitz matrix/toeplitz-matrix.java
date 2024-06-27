//{ Driver Code Starts
import java.util.*;

class Check_IsToepliz {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int N = sc.nextInt();
            int M = sc.nextInt();
            int arr[][] = new int[N][M];
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) arr[i][j] = sc.nextInt();
            }

            Solution g = new Solution();
            boolean b = g.isToeplitz(arr);

            if (b == true)
                System.out.println("true");
            else
                System.out.println("false");

            T--;
        }
    }
}
// } Driver Code Ends


class Solution {
    /*You are required to complete this method*/
    boolean isToeplitz(int mat[][]) {
        for (int i = 0; i< mat[0].length; i++){
            if (!check(0, i, mat)) return false;
        }
        for (int i = 1; i < mat.length; i++){
            if (!check(i,0, mat)) return false;
        }
        return true;
    }
    
    boolean check (int a, int b, int[][] mat){
        int val = mat[a][b];
        int i = a + 1;
        int j = b + 1;
        while (i < mat.length && j < mat[0].length){
            if (mat[i][j] != val) return false;
            i++;
            j++;
        }
        return true;
    }
}