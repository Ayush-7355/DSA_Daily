public class Solution {
    public int mostWordsFound(String[] sentences) {
        int ans=0;
        for(int i=0;i<sentences.length;i++){
            String[] arr=sentences[i].split(" ");
            if(arr.length>ans){
                ans=arr.length;
            }
        }
        return ans;
    }
}
