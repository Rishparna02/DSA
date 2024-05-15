//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.math.*;
import java.io.*;

class GFG {
  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    int T = sc.nextInt();
    while (T-- > 0) {
      int n = sc.nextInt();
      List<List<String>> accounts=new ArrayList<>();
      for (int i = 0; i < n; i++)
       {
        ArrayList<String> temp=new ArrayList<>();
        int x=sc.nextInt();
        for(int j = 0; j < x; j++)
           {
             String s1=sc.next();
             temp.add(s1);
           }
        accounts.add(temp);
       }
      Solution obj = new Solution();
      List<List<String>> res = obj.accountsMerge(accounts);
      Collections.sort(res, new Comparator<List<String>>() {
                @Override   public int compare(List<String> a,
                                              List<String> b) {
                    int al = a.size();
                    int bl = b.size();
                    int min = Math.min(al, bl);
                    for (int i = 0; i < min; i++) {
                        String xx=a.get(i);
                        String yy=b.get(i);
                        if (xx.compareTo(yy)<0)
                            return -1;
                        else if (xx.compareTo(yy)>0)
                            return 1;
                    }
                    if (al < bl)
                        return -1;
                    else if (al > bl)
                        return 1;
                    return -1;
                }
            });
      System.out.print("[");
      for (int i = 0; i < res.size(); ++i)
        {
          System.out.print("[");
          for (int j = 0; j < res.get(i).size(); j++)
             {
                if (j != res.get(i).size() - 1)
                     System.out.print(res.get(i).get(j)+", ");
                else
                     System.out.print(res.get(i).get(j));
             }
          if (i != res.size() - 1)
             System.out.println("], ");
          else
             System.out.print("]");
        }
       System.out.println("]");
    }
  }
}

// } Driver Code Ends


//User function Template for Java



class Solution {
    class UnionFind {
        private Map<String, String> parent;
        
        UnionFind() {
            parent = new HashMap<>();
        }
        
        public String find(String email) {
            if (!parent.get(email).equals(email)) {
                parent.put(email, find(parent.get(email)));
            }
            return parent.get(email);
        }
        
        public void union(String email1, String email2) {
            String root1 = find(email1);
            String root2 = find(email2);
            if (!root1.equals(root2)) {
                parent.put(root2, root1);
            }
        }
        
        public void add(String email) {
            if (!parent.containsKey(email)) {
                parent.put(email, email);
            }
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        UnionFind uf = new UnionFind();
        Map<String, String> emailToName = new HashMap<>();
        Map<String, Set<String>> rootToEmails = new HashMap<>();

        // Initialize the union-find structure and map emails to names
        for (List<String> account : accounts) {
            String name = account.get(0);
            String firstEmail = account.get(1);
            uf.add(firstEmail);
            emailToName.put(firstEmail, name);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                uf.add(email);
                uf.union(firstEmail, email);
                emailToName.put(email, name);
            }
        }

        // Group emails by their root representative
        for (String email : uf.parent.keySet()) {
            String root = uf.find(email);
            rootToEmails.computeIfAbsent(root, k -> new HashSet<>()).add(email);
        }

        // Prepare the result
        List<List<String>> mergedAccounts = new ArrayList<>();
        for (String root : rootToEmails.keySet()) {
            List<String> emails = new ArrayList<>(rootToEmails.get(root));
            Collections.sort(emails);
            List<String> account = new ArrayList<>();
            account.add(emailToName.get(root));
            account.addAll(emails);
            mergedAccounts.add(account);
        }

        return mergedAccounts;
    }
}

        
    
     