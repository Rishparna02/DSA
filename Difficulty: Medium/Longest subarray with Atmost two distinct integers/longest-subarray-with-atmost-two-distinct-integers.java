class Solution {
    public int totalElements(int[] arr) {
        // code here
        Map<Integer,Integer> map = new HashMap<>();
        int i=0,j=0,res = -1,countK = 0,n = arr.length;
        
        while(j<n)
        {
            int curr = arr[j];
            if(map.containsKey(curr))
            {
                map.put(curr,map.get(curr)+1);
            }
            else
            {
                countK++;
                map.put(curr,1);
            }
            
            if(countK<=2)
            {
                res = Math.max(res,j-i+1);
                j++;
            }
            else
            {
                while(countK>2)
                {
                    int currI = arr[i];
                    int countI = map.get(currI);
                    if(countI==1)
                    {
                        countK--;
                        map.remove(arr[i]);
                    }
                    else
                    map.put(currI,countI-1);
                    
                    i++;
                }
                j++;
            }
        }
        return res;
    }
}