package ������;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��05�� 10:40
 **/
public class Solution {
    //�ݹ������
    //����a��n�η������n��ż������Ϊ0������ô���ȼ���a��n/2�η���Ȼ��ƽ�������n����������ô���ȼ���a��n-1�η����ٳ���a���ݹ������a��0�η�Ϊ1��
    public static long fastPow(int a,int n){
        if (n==0){
            return 1;
        }
        else if (n%2 == 0){
            long tem = fastPow(a,n/2);
            return tem*tem;
        }
        else if (n%2 != 0){
            return fastPow(a,n-1)*a;
        }
        return 1;
    }

    //�ǵݹ������
    //��nתΪ�����Ʊ�ʾ,����ĩβ��ʼ,�����ǰλ�õĶ�������Ϊ1,��ôans��Ҫ�Գ˵�ǰ��a,���Ϊ0,��ôa�����Գ�
    public static long fastPow1(int a,int n){
        long ans = 1;
        //��n��Ϊ���������ַ���
        String str = Integer.toString(n, 2);
        char[] chars = str.toCharArray();
        int index = chars.length-1;
        while (index>=0){
            //��ǰ��ĩβΪ1,ans��Ҫ���ϵ�ǰa
            if (chars[index]=='1'){
                ans *= a;
            }
            //a�Գ�
            a *= a;
            //index��ǰ�ƶ�
            index--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fastPow1(3,6));
    }
}
