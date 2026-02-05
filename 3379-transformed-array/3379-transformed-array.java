public class Solution {
    public int[] constructTransformedArray(int[] nums){
        int n=nums.length;
        int[] result=new int[n];
        for(int i=0;i<n;i++){
            int k=nums[i]%n;
            int index=(i+k)%n;
            if(index<0)index+= n;
            result[i]=nums[index];
        }
        return result;
    }
}