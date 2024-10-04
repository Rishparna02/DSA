//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Collections;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        while (t-- > 0) {
            String s = sc.nextLine();
            String[] parts = s.split(" ");
            List<Integer> nums = new ArrayList<>();
            for (String part : parts) {
                nums.add(Integer.parseInt(part));
            }
            Solution ob = new Solution();
            List<Integer> ans = ob.findMajority(nums);
            for (int num : ans) {
                System.out.print(num + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}
// } Driver Code Ends


class Solution {
    // Function to find the majority elements in the array
    public List<Integer> findMajority(List<Integer> nums) {
        // Your code goes here.
        HashMap<Integer,Integer> map=new HashMap<Integer,Integer>();
        for(int n: nums){
            if(map.containsKey(n)){
                map.put(n,map.get(n)+1);
            }
            else{
                map.put(n,1);
            }
        }
        TreeSet<Integer> t1=new TreeSet<Integer>();
        for(int n: nums){
             if(map.containsKey(n)){
                if(map.get(n)>nums.size()/3){
                    t1.add(n);
                }
            }
        }
        LinkedList<Integer> l1=new LinkedList<Integer>();
        for(int obj:t1){
            l1.add(obj);
        }
        if(l1.isEmpty()){
            l1.add(-1);
            return l1;
        }
        else{
            return l1;
        }
    }
}