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
        //ȫΪ��д��ȫΪСд
        if (upper == chars.length || lower == chars.length){
            return true;
        }
        //��д��ĸ����һ��
        if (upper > 1){
            return false;
        }
        //��д��ĸ�Ƿ�λ������ĸ
        return chars[0]>='A' && chars[0]<='Z';
    }
}