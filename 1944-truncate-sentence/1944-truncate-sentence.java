public class Solution {
    public String truncateSentence(String s, int k) {
        String[] arr=s.split(" ");
        String ans="";
        for(int i=0;i<k;i++){
            if(i==0){
                ans=arr[i];
            }else{
                ans=ans+" "+arr[i];
            }
        }
        return ans;
    }
}
