class Solution {
    public String longestWord(String[] words) {
        Arrays.sort(words);
        Set<String> st=new HashSet<>();
        String ans="";
        for(String s:words){
            if(s.length()==1 || st.contains(s.substring(0,s.length()-1))){
                st.add(s);
                if(s.length()>ans.length()){
                    ans=s;
                }
            }
        }
        return ans;
    }
}