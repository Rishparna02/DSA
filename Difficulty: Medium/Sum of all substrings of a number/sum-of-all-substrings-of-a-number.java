class Solution {
    public static int sumSubstrings(String s) {
        // code here
        int n = s.length();
        long sum = s.charAt(0) - '0';
        long prev = sum;

        for (int i = 1; i < n; i++) {
            int digit = s.charAt(i) - '0';
            prev = prev * 10 + digit * (i + 1);
            sum += prev;
        }

        return (int)sum;
    }
}