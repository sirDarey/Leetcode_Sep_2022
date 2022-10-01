package leetcodeSep2022;

/**
 *
 * @Sir Darey
 * 
 * LeetCode Daily Challenge: September 2022, Day 23
 * Problem 1680: Concatenation of Consecutive Binary Numbers
 */

class Day23_1680_ConcatenationOfConBinNums {
    
    public int concatenatedBinary(int n) {
        final long modulo = (long) (1e9 + 7);
        long result = 0;
        int binaryDigits = 0;
        for (int i = 1; i <= n; i++) {
            if ((i & (i - 1)) == 0) binaryDigits++;
            result = ((result << binaryDigits) + i) % modulo;
        }
        return (int) result;
    }
}