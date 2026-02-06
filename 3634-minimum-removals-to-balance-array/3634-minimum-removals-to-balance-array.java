class Solution {
    public int minRemoval(int[] nums, int k) {
        int res=0;
        int n=nums.length;
        int maxlen=1;
        Arrays.sort(nums);
        for(int i=0;i<n;i++){
            while((long)nums[i]>(long)nums[res]*k){
                res++;
            }
            maxlen=Math.max(maxlen,i-res+1);
        }
        return n-maxlen;
    }
}