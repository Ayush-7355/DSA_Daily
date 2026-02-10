class Solution {
    public int longestBalanced(int[] nums){
        int n=nums.length;
        int ans=0;

        for(int i=0;i<n;i++){
            HashSet<Integer> seen=new HashSet<>();
            int evens=0;
            int odds=0;

            for(int j=i;j<n;j++){
                int x=nums[j];
                if(!seen.contains(x)){
                    // new distinct number add karne k liye
                    seen.add(x);
                    if((x & 1)==0)evens++;
                    else odds++;
                }
                // checks if balanced or not
                if(evens==odds){
                    ans=Math.max(ans,j-i+1);
                }
            }
        }
        return ans;
    }
}
