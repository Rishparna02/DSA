//{ Driver Code Starts
//saksham raj seth
import java.util.*;
import java.util.stream.*;

class Anagrams{
	public static void main(String[] args){
		Scanner sc=new Scanner(System.in);
		int t=sc.nextInt();
		while(t-->0){
			String s=sc.next();
			String s1=sc.next();
			GfG g=new GfG();
			System.out.println(g.remAnagrams(s,s1));
		}
	}
}
// } Driver Code Ends


/*Complete the function below*/
class GfG
{
	public int remAnagrams(String s,String s1)
        {
            int count = 0;
            HashMap<Character, Integer> map = new HashMap<>();
            for(int i = 0;i<s.length();i++){
                map.put(s.charAt(i), map.getOrDefault(s.charAt(i), 0) + 1);
            }
            for(int i = 0; i<s1.length();i++){
                if(map.containsKey(s1.charAt(i))){
                    if(map.get(s1.charAt(i))!=0){
                        map.put(s1.charAt(i),map.get(s1.charAt(i)) - 1);
                    }
                }
            }
            for(Map.Entry<Character, Integer> entry : map.entrySet()){
                count+=entry.getValue();
            }
            int difference = s.length()-count;
            return (s.length()-difference)+(s1.length()-difference);
        }
}