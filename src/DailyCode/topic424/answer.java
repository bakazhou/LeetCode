package DailyCode.topic424;

public class answer {
    /*
    ʹ��˫ָ����
    ����˫��ѭ�� ʱ�临�Ӷ�O(N)
    ��������д�ļ򵥺ö�
    ��Ҫ����ABBB����left�ڶ��λ��B��ʼ ���ǿɱ任��������ʣ�������£�������ǰ���б任
     */
    public int characterReplacement(String s, int k) {
        int ans=0,count=0,sum_k=k;
        int left=0,right=0;
        char flag;
        while(left<s.length() && right<s.length()){
            flag = s.charAt(left);
            if (s.charAt(right)==flag){
                count++;
                right++;
            }else {
                if (sum_k>0){
                    count++;
                    right++;
                    sum_k--;
                }else {
                    left++;
                    right=left;
                    sum_k=k;
                    count=0;
                }
            }
            if (right==s.length()){
                count+=sum_k;
                if (count>s.length()){
                    count=s.length();
                }
            }
            if (count>=ans){
                ans=count;
            }
        }
        return ans;
    }
}
