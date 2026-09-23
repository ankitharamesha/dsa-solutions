class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] lastIndex = new int[128];
        java.util.Arrays.fill(lastIndex, -1);

        int maxLength = 0;
        int left = 0;

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);

            // If the character was seen inside the current window, move the left pointer past it
            if (lastIndex[c] >= left) {
                left = lastIndex[c] + 1;
            }

            lastIndex[c] = right;
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
}