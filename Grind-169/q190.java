class Solution {
    public int reverseBits(int n) {
        int reversedNumber = 0;
        for(int i = 0; i<32; i++){
            int lsb = n & 1;
            int reversedDigit = lsb << (31-i);
            reversedNumber = reversedNumber | reversedDigit;
            n = n >> 1;
        }
        return reversedNumber;
    }
}