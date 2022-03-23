package DailyCode.topic66;

class Solution {
    public int[] plusOne(int[] digits) {
        digits[digits.length-1]++;
        for (int i=digits.length-1;i>0;i--){
            if (digits[i]==10){
                digits[i]=0;
                digits[i-1]++;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i=0;i<digits.length;i++){
            sb.append(digits[i]);
        }
        char[] chars = sb.toString().toCharArray();
        int[] ans = new int[chars.length];
        for (int i=0;i<ans.length;i++){
            ans[i] = Integer.parseInt(String.valueOf(chars[i]));
        }
        return ans;
    }
}