class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int res = Integer.MAX_VALUE,left=0,sum=0;
        for (int i = 0; i < nums.length; i++) {
            sum+=nums[i];
            while (sum >= target ) {
                res = Math.min(i-left+1, res);
                sum-=nums[left++];
            }
        }
        if(res == Integer.MAX_VALUE) return 0;
        return res;
    }
}
