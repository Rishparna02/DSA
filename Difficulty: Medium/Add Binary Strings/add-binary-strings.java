//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            String a, b;
            a = sc.next();
            b = sc.next();
            Solution ob = new Solution();
            System.out.println(ob.addBinary(a, b));

            System.out.println("~");
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {
    public String addBinary(String s1, String s2) {
        // code here
        StringBuilder sb = new StringBuilder();
        
        int n = s1.length();
        int m = s2.length();
        
        int i = n-1 , j = m-1;
        int carry = 0;
        
        while(i>=0 && j>=0){
            int count = 0;
            
            if(s1.charAt(i) == '1'){
                count++;
            }
            if(s2.charAt(j) == '1'){
                count++;
            }
            
            if(carry > 0){
                count++;
            }
            
            if(count  == 1){
                sb.append(1);
                carry = 0;
            }
            else if(count == 2){
                sb.append(0);
                carry=1;
                
            }
            else if(count == 3){
                sb.append(1);
                carry=1;
            }else{
                sb.append(0);
                carry=0;
            }
            
            i--;
            j--;
        }
        
        while(j>=0){
            int val = s2.charAt(j) == '1'?1:0;
            val+=carry;
            
            if(val == 2){
                sb.append(0);
            }
            else{
                sb.append(val);
                carry = 0;
            }
            j--;
        }
         while(i>=0){
            int val = s1.charAt(i) == '1'?1:0;
            val+=carry;
            
            if(val == 2){
                sb.append(0);
            }
            else{
                sb.append(val);
                carry=0;
            }
            i--;
        }
        
        if(carry > 0){
            sb.append(carry);
        }

       //remove the leading zero from the back

        int k = sb.length()-1;
        while(k>=0 && sb.charAt(k)!='1'){
            k--;
        }
        if(k>=0){
            sb = new StringBuilder(sb.substring(0, k+1));  
        }
      sb.reverse();  
        return sb.toString();
    }
}