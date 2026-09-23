class Solution {
    public int divide(int dividend, int divisor) {
        // Handle overflow case: -2^31 / -1 = 2^31 (which exceeds 2^31 - 1)
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Determine the sign of the result
        boolean isNegative = (dividend < 0) ^ (divisor < 0);

        // Convert both to negative values to avoid overflow with Integer.MIN_VALUE
        // Since |-2^31| cannot fit into a 32-bit signed positive integer
        int a = dividend < 0 ? dividend : -dividend;
        int b = divisor < 0 ? divisor : -divisor;

        int quotient = 0;

        // Perform bit-shifting division while a <= b (both are negative)
        while (a <= b) {
            int currentDivisor = b;
            int count = 1;

            // Shift left until doubling exceeds 'a' or would overflow negative 32-bit int
            while (currentDivisor >= (Integer.MIN_VALUE >> 1) && a <= (currentDivisor << 1)) {
                currentDivisor <<= 1;
                count <<= 1;
            }

            a -= currentDivisor;
            quotient += count;
        }

        return isNegative ? -quotient : quotient;
    }
}