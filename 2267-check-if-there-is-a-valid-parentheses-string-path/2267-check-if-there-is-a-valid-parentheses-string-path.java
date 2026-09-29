class Solution{
    public boolean hasValidPath(char[][] g){
        int m=g.length,n=g[0].length;
        if((m+n-1)%2==1||g[0][0]==')'||g[m-1][n-1]=='(')return false;
        boolean[][][] dp=new boolean[m][n][m+n];
        dp[0][0][1]=true;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                for(int k=0;k<m+n;k++){
                    if(!dp[i][j][k]) continue;
                    if(i+1<m){
                        int x=k+(g[i+1][j]=='('?1:-1);
                        if(x>=0)dp[i+1][j][x]=true;
                    }
                    if(j+1<n){
                        int x=k+(g[i][j+1]=='('?1:-1);
                        if(x>=0)dp[i][j+1][x]=true;
                    }
                }
            }
        }
        return dp[m-1][n-1][0];
    }
}