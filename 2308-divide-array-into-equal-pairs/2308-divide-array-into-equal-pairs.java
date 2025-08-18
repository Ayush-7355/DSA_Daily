class Solution {
    public boolean divideArray(int[] nums) {
        int temp;
        for(int i=0;i<nums.length;i++){
            temp=nums[i]; 
            int count=0;
            for(int j=0;j<nums.length;j++){
                if(temp==nums[j]){
                    count++;
                }
            }
            if(count%2!=0){
                return false;
            }
        }
        return true;
    }
}