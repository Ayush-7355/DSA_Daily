public class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n=nums.length;
        int res[]=new int[n];
        for(int i=0;i<n;i++){
            int left=0;
            int right=0;
            for(int j=0;j<i;j++){
                left=left+nums[j];
            }
            for(int j=i+1;j<n;j++){
                right=right+nums[j];
            }
            int diff=left-right;
            if(diff<0){
                diff=diff*-1;
            }
            res[i]=diff;
        }
        return res;
    }
}
