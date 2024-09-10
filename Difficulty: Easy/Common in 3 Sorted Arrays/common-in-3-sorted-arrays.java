//{ Driver Code Starts
// Initial Template for Java

import java.util.*;

public class GFG {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int t = Integer.parseInt(sc.nextLine());
        while (t-- > 0) {
            List<Integer> arr = new ArrayList<>();
            List<Integer> brr = new ArrayList<>();
            List<Integer> crr = new ArrayList<>();

            String input1 = sc.nextLine();
            Scanner ss1 = new Scanner(input1);
            while (ss1.hasNextInt()) {
                arr.add(ss1.nextInt());
            }

            String input2 = sc.nextLine();
            Scanner ss2 = new Scanner(input2);
            while (ss2.hasNextInt()) {
                brr.add(ss2.nextInt());
            }

            String input3 = sc.nextLine();
            Scanner ss3 = new Scanner(input3);
            while (ss3.hasNextInt()) {
                crr.add(ss3.nextInt());
            }

            Solution ob = new Solution();
            List<Integer> res = ob.commonElements(arr, brr, crr);

            if (res.size() == 0) System.out.print(-1);
            for (int i = 0; i < res.size(); i++) System.out.print(res.get(i) + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends


// User function Template for Java

class Solution {
    // Function to find common elements in three arrays.
    public List<Integer> commonElements(List<Integer> arr1, List<Integer> arr2,
                                        List<Integer> arr3) {
        // Code Here
        ArrayList<Integer> arr=new ArrayList<>();
        int x=0;
        int y=0;
        int z=0;
        while(x<arr1.size() && y<arr2.size() && z<arr3.size()){
            if(arr1.get(x).equals(arr2.get(y)) && arr2.get(y).equals(arr3.get(z))){
               
                 if (arr.isEmpty() || !arr.get(arr.size() - 1).equals(arr1.get(x))) {
                    arr.add(arr1.get(x));
                } ;
                x++;
                y++;
                z++;
            }
            else if(arr1.get(x)>arr2.get(y)){
                y++;
            }
            else if(arr2.get(y)>arr3.get(z)){
                z++;
            }
            else{
                x++;
            }
        }
        return arr;
    }
}