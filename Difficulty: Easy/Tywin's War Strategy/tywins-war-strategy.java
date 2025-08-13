class Solution {
    public int minSoldiers(int[] arr, int k) {
        // code here
        int n=arr.length;
        int [] freq=new int[n];
        for(int i=0;i<arr.length;i++)
        {
           int add = (k - (arr[i] % k)) % k;
           freq[i]=add;
        }
        
        Arrays.sort(freq);
        int sum=0;
        if(n%2==0){
            n=n/2;
        }else{
            n=n/2+1;
        }
        for(int i=0;i<n;i++){
            sum=sum+freq[i];
        }
        
        return sum;
    }
}