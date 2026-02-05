class Solution {
    public int maxOnes(int arr[], int k) {
        int n = arr.length;
        int l = 0; // start of window
        int r = 0; // end of window
        int zero = 0; // curr zeros count
        int longest = 0;
        while(r<n){
            if(arr[r]==0){
                zero++; // update zero count
            }
            while(zero>k){ // shrink the window
                if(arr[l]==0) zero--;
                l++;
            }
            longest = Math.max(longest, r-l+1); // update longest
            r++; // expand window
        }
        return longest; // ans
    }
}
