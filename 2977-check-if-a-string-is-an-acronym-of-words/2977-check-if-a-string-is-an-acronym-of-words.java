import java.util.*;

public class Solution {
    public boolean isAcronym(List<String> words, String s) {
        if(words.size()!=s.length()){
            return false;
        }
        String a="";
        for(int i=0;i<words.size();i++){
            a=a+words.get(i).charAt(0);
        }
        if(a.equals(s)){
            return true;
        } else {
            return false;
        }
    }
}
