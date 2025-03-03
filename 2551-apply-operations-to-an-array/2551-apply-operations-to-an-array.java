class Solution {
    public int[] applyOperations(int[] nums) {
        
        for(int i=0;i<nums.length-1;i++){
            if(nums[i]==nums[i+1]){
                nums[i]=nums[i]*2;
                nums[i+1]=0;
            }
        }
        
        int temp[]=new int[nums.length];
        int tempo=0;
        for(int i=0;i<temp.length;i++){
            if(nums[i] != 0){
                temp[tempo]=nums[i];
                tempo++;
            }
        }
        int tempo2=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0){
                tempo2++;
            }
        }
        for(int i=tempo2;i<temp.length;i++){
            nums[tempo2]=0;
        }
        return temp;
    }
}