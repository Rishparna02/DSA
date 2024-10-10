//{ Driver Code Starts
import java.util.*;


class Implement_strstr
{
	public static void main(String args[])
	{
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		sc.nextLine();
		while(t>0)
		{
			String line = sc.nextLine();
			String a = line.split(" ")[0];
			String b = line.split(" ")[1];
			
			GfG g = new GfG();
			System.out.println(g.strstr(a,b));
			
			t--;
		}
	}
}
// } Driver Code Ends


class GfG {
    // Function to locate the occurrence of the string x in the string s.
    int strstr(String s, String x) {
        // Length of the main string
        int n = s.length();  
        // Length of the substring
        int m = x.length();  
        
        // Iterate over each possible starting position in 's'
        for (int i = 0; i <= n - m; i++) {
            // Check if the substring s starting at index i matches x
            if (s.substring(i, i + m).equals(x)) {
                return i; // Return the starting index if found
            }
        }
        
        // If no match is found, return -1
        return -1;
    }
}
