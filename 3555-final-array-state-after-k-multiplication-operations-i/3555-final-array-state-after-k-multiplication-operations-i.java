public class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        int n=nums.length;
        for(int i=0;i<k;i++){
            int idx=0;
            for(int j=1;j<n;j++){
                if(nums[j]<nums[idx]){
                    idx=j;
                }
            }
            nums[idx]=nums[idx]*multiplier;
        }
        return nums;
    }
}
