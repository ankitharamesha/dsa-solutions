class Solution {
    public boolean isPossibleToSplit(int[] nums) {
        int[] counts = new int[101];
        
        for (int num : nums) {
            counts[num]++;
           
            if (counts[num] > 2) {
                return false;
            }
        }
        
        return true;
    }
}
