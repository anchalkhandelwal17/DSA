class Solution {
    public int maxSubArray(int[] nums) {
// Kadane's Algorithm

        // TC : O(n)
        // SC : O(1)
        int max = Integer.MIN_VALUE;
        int currSum = 0;
        for(int i=0; i<nums.length; i++){

            if(currSum < 0) {
                currSum = 0;
            }
            currSum += nums[i];
            max = Math.max(max, currSum);
        }
        return max;
    }
}