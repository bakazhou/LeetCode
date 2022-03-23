package 剑指Offer2;

public class Offer020 {
    public int countSubstrings(String s) {
        int ans = 0,n=s.length();
        for (int i=0;i<n;i++){
            //中心点为单个字符
            ans+=expand(s,i,i);
            //中心点为多个字符
            ans+=expand(s,i,i+1);
        }
        return ans;
    }

    public int expand(String s,int left,int right) {
        int count = 0;
        //进行扩散
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
