class Solution {
    public int getSecondLargest(int[] arr) {
        // Code Here
        int FirstLargest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;
        for(int i=0;i< arr.length;i++){
            if(arr[i] > FirstLargest){
                secondLargest =FirstLargest ;
                FirstLargest =arr[i]; 
            }
            else if((arr[i] > secondLargest) && (arr[i]!= FirstLargest)){
                secondLargest = arr[i];
            }
        }
        if(secondLargest == Integer.MIN_VALUE){
            return -1;
        }
        return secondLargest;

        
    }
}