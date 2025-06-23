class Solution {
    String minSum(int[] arr) {
        // code here
        int n = arr.length;
        Arrays.sort(arr);
        StringBuilder ans = new StringBuilder();
        int [] first = new int[n %2 == 0 ? n/2 : n/2+ 1];
        
        int i, j = first.length-1, carry = 0;
        for (i = n-1; i > 0; i-=2){
            int a = arr[i] + arr[i-1] + carry;
            first[j] = a % 10;
            carry = a / 10;
            j--;
        }
        
        if (n % 2 != 0){
            first[0] = (arr[0] + carry) % 10;
            carry = (arr[0] + carry) / 10;
        }
        if (carry != 0)
            ans.append(Integer.valueOf(carry));
        for (i = 0; i < first.length; i++){
            if (first[i] != 0)
                break;
        }
        for (i = i; i < first.length; i++){
            ans.append(Integer.valueOf(first[i]));
        }
        return ans.toString();
    }
}
