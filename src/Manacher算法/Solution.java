package Manacher�㷨;

public class Solution {
    public static int Manacher(String s){
        //1.���ַ���תΪ��#����ʽ,����12321תдΪ#1#2#2#3#2#2#1#
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        char[] chars = sb.toString().toCharArray();

        //��ؼ��ľ��ǻ��İ뾶����
        int[] pArr = new int[chars.length];//���İ뾶����
        int R = -1;//�����ұ߽�������һ��λ�ã���ʵ��Ч������R-1
        int C = -1;//����
        int max = Integer.MIN_VALUE;//��չ��Χ�����ֵ
        for (int i=0;i<chars.length;i++){
            //���i��R�ڣ���ô��ȡ�����ٵķ�Χ
            /*
            ���Է�Ϊ����С���
            1.i'����߽���L�� ��ôi�Ļ��İ뾶��Ӧ�ú�i'��ͬ
            pArr[2*C-i]�������i'�Ļ��İ뾶
            2.i'����߽�Խ����L������Lѹ�� ��ôi����չ�İ뾶����Ӧ��ΪR-i
             */
            //���i��R��,��ôi����С����Ϊ1
            pArr[i] = R>i ? Math.min(pArr[2*C-i],R-i) : 1;
            while (pArr[i]+i < chars.length && i-pArr[i] >= 0){
                //�ַ���ͬ��������չ
                if (chars[i+pArr[i]] == chars[i-pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i+pArr[i]>R){
                C=i;
                R=i+pArr[i];
            }
            max = Math.max(pArr[i],max);
        }
        //ԭ��������Ҫ-1
        return max-1;
    }


    public static String ManacherString(String s){
        //1.���ַ���תΪ��#����ʽ,����12321תдΪ#1#2#2#3#2#2#1#
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        char[] chars = sb.toString().toCharArray();

        int[] pArr = new int[chars.length];//���İ뾶����
        int R = -1;//�����ұ߽�������һ��λ�ã���ʵ��Ч������R-1
        int C = -1;//����
        int max = Integer.MIN_VALUE;//��չ��Χ�����ֵ
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<chars.length;i++){
            //���i��R�ڣ���ô��ȡ�����ٵķ�Χ
            /*
            ���Է�Ϊ����С���
            1.i'����߽���L�� ��ôi�Ļ��İ뾶��Ӧ�ú�i'��ͬ
            pArr[2*C-i]�������i'�Ļ��İ뾶
            2.i'����߽�Խ����L������Lѹ�� ��ôi����չ�İ뾶����Ӧ��ΪR-i
             */
            //���i��R��,��ôi����С����Ϊ1
            pArr[i] = R>i ? Math.min(pArr[2*C-i],R-i) : 1;
            while (pArr[i]+i < chars.length && i-pArr[i] >= 0){
                //�ַ���ͬ��������չ
                if (chars[i+pArr[i]] == chars[i-pArr[i]]){
                    pArr[i]++;
                }else {
                    break;
                }
            }
            if (i+pArr[i]>R){
                C=i;
                R=i+pArr[i];
            }
            if (pArr[i]>max){
                ans  = new StringBuilder();
                for (int j=i-pArr[i]+1;j<pArr[i]+i;j++){
                    if (chars[j]!='#'){
                        ans.append(chars[j]);
                    }
                }
            }
            max = Math.max(pArr[i],max);
        }
        //ԭ��������Ҫ-1
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(ManacherString("babad"));
    }
}
