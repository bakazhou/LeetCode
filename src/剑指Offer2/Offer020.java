package ��ָOffer2;

public class Offer020 {
    public int countSubstrings(String s) {
        int ans = 0,n=s.length();
        for (int i=0;i<n;i++){
            //���ĵ�Ϊ�����ַ�
            ans+=expand(s,i,i);
            //���ĵ�Ϊ����ַ�
            ans+=expand(s,i,i+1);
        }
        return ans;
    }

    public int expand(String s,int left,int right) {
        int count = 0;
        //������ɢ
        while (left>=0 && right<s.length() && s.charAt(left)==s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
