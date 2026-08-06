class Solution {
    public int smallestNumber(int n, int t) {
        int curr = n;

        while (true) {
            if (getDigitProduct(curr) % t == 0) {
                return curr;
            }
            curr++;
        }
    }

    private int getDigitProduct(int num) {
        int product = 1;
        while (num > 0) {
            int digit = num % 10;
            product *= digit;
            num /= 10;
        }
        return product;
    }
}
