import java.util.*;

public class Solution {
    public int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> arr=new ArrayList();
        for(int i=0;i<nums.length;i++){
            arr.add(index[i],nums[i]);
        }
        int res[]=new int[arr.size()];
        for(int i=0;i<res.length;i++){
            res[i]=arr.get(i);
        }
        return res;
    }
}
