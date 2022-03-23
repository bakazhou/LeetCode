package DailyCode.topic859;

class Solution {
    public boolean buddyStrings(String s, String goal) {
        if (s.length()!=goal.length()){
            return false;
        }
        if (s.equals(goal)){
            return true;
        }
        int[] sChar = new int[26];
        int[] goalChar = new int[26];
        for (int i=0;i<goal.length();i++){
            sChar[s.charAt(i)-97]++;
            goalChar[goal.charAt(i)-97]++;
        }
        for (int i=0;i<26;i++){
            if (sChar[i]!=goalChar[i]){
                return false;
            }
        }
        return true;
    }
}