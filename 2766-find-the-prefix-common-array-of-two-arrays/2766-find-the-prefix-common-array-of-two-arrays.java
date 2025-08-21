public class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n=A.length;
        int[] ans=new int[n];
        int[] s=new int[n+1];
        int cnt=0;
        for(int i=0;i<n;i++){
            s[A[i]]++;
            if(s[A[i]]==2) cnt++;
            s[B[i]]++;
            if(s[B[i]]==2) cnt++;
            ans[i]=cnt;
        }
        return ans;
    }
}
