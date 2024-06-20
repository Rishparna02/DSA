//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            String S[] = read.readLine().split(" ");
            long p[] = new long[2];
            long q[] = new long[2];
            long r[] = new long[2];
            p[0] = Long.parseLong(S[0]);
            p[1] = Long.parseLong(S[1]);
            q[0] = Long.parseLong(S[2]);
            q[1] = Long.parseLong(S[3]);
            r[0] = Long.parseLong(S[4]);
            r[1] = Long.parseLong(S[5]);
            Solution ob = new Solution();
            long ans = ob.InternalCount(p, q, r);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    class Point {
        long x, y;
        Point(long x, long y) {
            this.x = x;
            this.y = y;
        }
    }

    public long InternalCount(long[] p, long[] q, long[] r) {
        Point P = new Point(p[0], p[1]);
        Point Q = new Point(q[0], q[1]);
        Point R = new Point(r[0], r[1]);
        
        long boundary = boundaryPoints(P, Q) + boundaryPoints(Q, R) + boundaryPoints(R, P);
        
        long area = Math.abs(P.x * (Q.y - R.y) + Q.x * (R.y - P.y) + R.x * (P.y - Q.y));
        
        long internalPoints = (area - boundary + 2) / 2;
        return internalPoints;
    }
    
    private long boundaryPoints(Point p, Point q) {
        return gcd(Math.abs(p.x - q.x), Math.abs(p.y - q.y));
    }

    private long gcd(long a, long b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    public static void main(String[] args) {
        Solution sol = new Solution();
        
        long[] p1 = {0, 0};
        long[] q1 = {0, 5};
        long[] r1 = {5, 0};
        System.out.println(sol.InternalCount(p1, q1, r1)); // Output: 6
        
        long[] p2 = {62, -3};
        long[] q2 = {5, -45};
        long[] r2 = {-19, -23};
        System.out.println(sol.InternalCount(p2, q2, r2)); // Output: 1129
    }
}
