class Solution {
    public int regionsBySlashes(String[] grid){
        
        int n=grid.length;
        int size=n*3;
        int[][] mat=new int[size][size];

        for(int i=0;i<n;i++){
            for(int j=0;j<n;j++){
                char ch=grid[i].charAt(j);

                if(ch=='/'){
                    mat[i*3][j*3+2]=1;
                    mat[i*3+1][j*3+1]=1;
                    mat[i*3+2][j*3]=1;
                }
                else if(ch=='\\'){
                    mat[i*3][j*3]=1;
                    mat[i*3+1][j*3+1]=1;
                    mat[i*3+2][j*3+2]=1;
                }
            }
        }
        int regions=0;

        for(int i=0;i<size;i++){
            for(int j=0;j<size;j++){
                if(mat[i][j]==0){
                    dfs(mat,i,j);
                    regions++;
                }
            }
        }

        return regions;
    }
    private void dfs(int[][] mat, int r,int c){
        int n=mat.length;

        if(r<0 || c<0 || r>=n || c>=n || mat[r][c] !=0) return;
        mat[r][c]=1;

        dfs(mat,r+1,c);
        dfs(mat,r-1,c);
        dfs(mat,r,c+1);
        dfs(mat,r,c-1);
    }    
}
