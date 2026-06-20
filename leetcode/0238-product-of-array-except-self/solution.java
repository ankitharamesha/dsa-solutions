class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];
        
        // Step 1: Calculate prefix products and store them in answer
        answer[0] = 1; // There are no elements to the left of the first element
        for (int i = 1; i < n; i++) {
            answer[i] = answer[i - 1] * nums[i - 1];
        }
        
        // Step 2: Calculate suffix products on the fly and multiply into answer
        int rightProduct = 1; // Tracks the product of all elements to the right
        for (int i = n - 1; i >= 0; i--) {
            answer[i] = answer[i] * rightProduct;
            rightProduct *= nums[i]; // Update the suffix product for the next element
        }
        
        return answer;
    }
}
