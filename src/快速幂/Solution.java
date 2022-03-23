package 快速幂;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月05日 10:40
 **/
public class Solution {
    //递归快速幂
    //计算a的n次方，如果n是偶数（不为0），那么就先计算a的n/2次方，然后平方；如果n是奇数，那么就先计算a的n-1次方，再乘上a；递归出口是a的0次方为1。
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

    //非递归快速幂
    //将n转为二进制表示,并从末尾开始,如果当前位置的二进制数为1,那么ans需要自乘当前的a,如果为0,那么a进行自乘
    public static long fastPow1(int a,int n){
        long ans = 1;
        //将n变为二进制数字符串
        String str = Integer.toString(n, 2);
        char[] chars = str.toCharArray();
        int index = chars.length-1;
        while (index>=0){
            //当前幂末尾为1,ans需要乘上当前a
            if (chars[index]=='1'){
                ans *= a;
            }
            //a自乘
            a *= a;
            //index向前移动
            index--;
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(fastPow1(3,6));
    }
}
