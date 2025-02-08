class Solution {
    public int minimumChairs(String s) {
        int CurrentValue=0;
        int MaxValue=0;

        char[] people=s.toCharArray();
        for(int i=0;i<people.length;i++){
            char c=people[i];

            if(c=='E'){
                CurrentValue++;
                MaxValue=Math.max(MaxValue,CurrentValue);
            }
            else{
                CurrentValue--;
            }
        }
        return MaxValue;
    }
}