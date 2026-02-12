class Solution {
    public int mincostTickets(int[] days, int[] costs){

        int n=days.length;
        int[] dp=new int[n+1];

        for(int i=n-1;i>=0;i--){
            int j=i;
            while(j<n && days[j]<days[i]+1) j++;
            int c1=costs[0]+dp[j];

            j=i;
            while(j<n && days[j]<days[i]+7)j++;
            int c7=costs[1]+dp[j];

            j=i;
            while(j<n && days[j]<days[i]+30)j++;
            int c30=costs[2] + dp[j];

            dp[i]=Math.min(c1,Math.min(c7,c30));
        }

        return dp[0];
    }
}