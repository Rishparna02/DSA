class Solution {
    public int substrCount(String s, int k) {
        // code here
        if (s == null || k < 0) {
            return 0;
        }
        int length = s.length();
        int left = 0;
        int right = 0;
        int count = 0;
        Map<Character, Integer> freqMap = new HashMap<>();
        while (right < length) {
            char rightChar = s.charAt(right);
            freqMap.put(rightChar, freqMap.getOrDefault(rightChar, 0) + 1);
            if (right - left + 1 > k) {
                char leftChar = s.charAt(left);
                freqMap.put(leftChar, freqMap.get(leftChar) - 1);
                if (freqMap.get(leftChar) == 0) {
                    freqMap.remove(leftChar);
                }
                left++;
            }
            if (right - left + 1 == k && freqMap.size() == k - 1) {
                count++;
            }
            right++;
        }
        return count;
    }
}