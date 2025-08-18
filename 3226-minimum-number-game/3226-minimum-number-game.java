import java.util.*;

public class Solution {
    public int[] numberGame(int[] nums) {
        Arrays.sort(nums);
        int res[]=new int[nums.length];
        int j=0;
        for(int i=0;i<nums.length;i=i+2){
            res[j]=nums[i+1];
            res[j+1]=nums[i];
            j=j+2;
        }
        return res;
    }
}
