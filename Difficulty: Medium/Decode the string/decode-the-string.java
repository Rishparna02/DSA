class Solution {
    static String decodeString(String s) {
        // code here
        Stack<String> st = new Stack<>();
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            
            if (c != ']') {
                st.push(Character.toString(c));
            } else {
                StringBuilder str1 = new StringBuilder();
                
                while (!st.isEmpty() && !st.peek().equals("[")) {
                    str1.insert(0, st.pop());
                }
                st.pop(); // remove '['
                
                StringBuilder num = new StringBuilder();
                while (!st.isEmpty() && !st.peek().isEmpty() && Character.isDigit(st.peek().charAt(0))) {
                    num.insert(0, st.pop());
                }
                
                int count=1;
                if(num.length()>0)
                {
                 count = Integer.parseInt(num.toString());
                }
                
                String temp = str1.toString().repeat(count);
                st.push(temp);
            }
        }
        
        StringBuilder res = new StringBuilder();
        for (String part : st) {
            res.append(part);
        }
        return res.toString();
    }
}