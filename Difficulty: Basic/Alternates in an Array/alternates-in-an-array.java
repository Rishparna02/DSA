class Solution {
    public ArrayList<Integer> getAlternates(int arr[]) {
        // Code Here
        ArrayList<Integer> getAlternates = new ArrayList<>();
        for(int i = 0; i < arr.length; i = i + 2){
            int temp = arr[i];
            getAlternates.add(temp);
        }
        return getAlternates;
    }
}