//{ Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {
		Scanner scan = new Scanner(System.in);
		int test = scan.nextInt();
		
		while(test > 0){
		    String s = scan.next();
		    String t = scan.next();
		    
		    System.out.println(new Solution().smallestWindow(s, t));
		    test--;
		}
	}
}
// } Driver Code Ends


class Solution
{
    //Function to find the smallest window in the string s consisting
    //of all the characters of string p.
    public static String smallestWindow(String s, String p)
    {
        // Your code here
        int l=0,r=0,n=s.length();
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<p.length();i++)
        {
            char c=p.charAt(i);
            map.put(c,map.getOrDefault(c,0)+1);
        }
        int found=0;
        HashMap<Character,Integer> map_in_range=new HashMap<>();
        int min_range_size=Integer.MAX_VALUE;
        String res="";
        while(r<n)
        {
            if(map.containsKey(s.charAt(r)))
            {
                if(map.get(s.charAt(r))>map_in_range.getOrDefault(s.charAt(r),0))
                   found++;
                map_in_range.put(s.charAt(r),map_in_range.getOrDefault(s.charAt(r),0)+1);
                                   
            }
            while(l<r&&(!map.containsKey(s.charAt(l))||map_in_range.get(s.charAt(l))>map.get(s.charAt(l))))
            {
                if(map_in_range.containsKey(s.charAt(l)))
                    map_in_range.put(s.charAt(l),map_in_range.get(s.charAt(l))-1);
                l++;
            }
            if(found==p.length()&&min_range_size>r-l+1)
            {
                
                res=s.substring(l,r+1);
                min_range_size=r-l+1;
            }
            r++;
        }
        return min_range_size==Integer.MAX_VALUE?"-1":res;
    }
}