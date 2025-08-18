import java.util.*;

public class Solution {
    public int[][] sortTheStudents(int[][] score, int k) {
        Arrays.sort(score,new Comparator<int[]>() {
            public int compare(int[] a,int[] b){
                if(a[k]==b[k]){
                    return 0;
                }else if(a[k]<b[k]){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        return score;
    }
}
