package DailyCode.topic3;

import java.util.HashSet;
import java.util.Set;

public class answer {
    public int lengthOfLongestSubstring(String s) {
        if (s.length()<=1){
            return s.length();
        }
        int length = s.length();
        int answer = 0;
        int index=0;
        String findChar=""+s.charAt(index);
        for (int i=1;i<length;i++){
            String str = "";
            str+=s.charAt(i);

            if (findChar.contains(str)){
                if (findChar.length()>=answer){
                    answer=findChar.length();
                }
                index++;
                i=index;
                findChar=""+s.charAt(i);

            }else {
                findChar+=str;
            }
            if(i==length-1){
                if (findChar.length()>=answer){
                    answer=findChar.length();
                }
            }
        }
        return answer;
    }
    public int lengthOfLongestSubstring1(String s) {
        if (s.length()<=1){
            return s.length();
        }
        Set<Character> ans = new HashSet<Character>();
        int answer = 1;
        int right = -1;//��ָ��
        int n = s.length();
        for (int i=0;i<s.length();i++){
            if (i != 0) {
                // ��ָ�������ƶ�һ���Ƴ�һ���ַ�
                ans.remove(s.charAt(i - 1));
            }
            while (right<n-1 && !ans.contains(s.charAt(right+1))){//��ʼ���Ӵ�
                /*
                ����abcfbcbb
                �ڵ�һ��ʱ�ҵ��ظ�����abcfb
                ��ʱwhile����ִ�� if�л�ִ��i����
                ֱ����ָ���ַ����Ӵ��в�����Ϊֹ
                 */
                ans.add(s.charAt(right+1));
                right++;
            }
            answer=Math.max(answer,right-i+1);
        }
        return answer;
    }

    public int lengthOfLongestSubstring3(String s) {
        char[] chars = s.toCharArray();
        int left=0,right=0,n=s.length();
        Set<Character> set = new HashSet<>();
        int length = Integer.MIN_VALUE;
        while (left<n && right<left){
            if (set.contains(chars[right])){
                set.add(chars[right]);
                length=Math.max(right-left+1,length);
                right++;
            }
            else {
                while (set.contains(chars[right])){
                    set.remove(chars[left]);
                    left++;
                }
            }
            System.out.println(set);
        }
        return length;
    }
}
