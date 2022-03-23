package DailyCode.topic5;

class Solution {
    public String longestPalindrome(String s) {
        StringBuilder sb = new StringBuilder();
        //将字符串进行转化,例如12321转写为#1#2#2#3#2#2#1#,再进行中心扩散法
        sb.append("#");
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        System.out.println(sb);
        char[] chars = sb.toString().toCharArray();
        StringBuilder ans = new StringBuilder();
        for (int i=1;i<chars.length-1;i++){
            int leng = 1;
            int left = i-1,right = i+1;
            while (left>=0 && right<chars.length && chars[left]==chars[right]){
                leng = leng+2;
                left--;
                right++;
            }
            if (leng/2 > ans.length()){
                ans = new StringBuilder();
                for (int j=left+1;j<right;j++){
                    if (chars[j]!='#'){
                        ans.append(chars[j]);
                    }
                }
            }
        }
        return ans.toString();
    }
}
