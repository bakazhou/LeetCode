package DailyCode.topic520;

class Solution {
    public boolean detectCapitalUse(String word) {
        char[] chars = word.toCharArray();
        int upper = 0,lower = 0;
        for (int i=0;i<chars.length;i++){
            if (chars[i]>='A' && chars[i]<='Z'){
                upper++;
            }else {
                lower++;
            }
        }
        //全为大写或全为小写
        if (upper == chars.length || lower == chars.length){
            return true;
        }
        //大写字母超过一个
        if (upper > 1){
            return false;
        }
        //大写字母是否位于首字母
        return chars[0]>='A' && chars[0]<='Z';
    }
}