public class Solution {
    public int minimumOperations(int[] nums) {
        int ans=0;
        for(int i=0;i<nums.length;i++){
            int n=nums[i];
            int r=n%3;
            if(r==1){
                ans=ans+1;
            }else if(r==2){
                ans=ans+1;
            }
        }
        return ans;
    }
}
