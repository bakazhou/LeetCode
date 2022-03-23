package Manacher算法;

public class Solution {
    public static int Manacher(String s){
        //1.将字符串转为带#的形式,例如12321转写为#1#2#2#3#2#2#1#
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        char[] chars = sb.toString().toCharArray();

        //最关键的就是回文半径数组
        int[] pArr = new int[chars.length];//回文半径数组
        int R = -1;//回文右边界再往右一个位置，真实有效区域是R-1
        int C = -1;//中心
        int max = Integer.MIN_VALUE;//扩展范围的最大值
        for (int i=0;i<chars.length;i++){
            //如果i在R内，那么就取其至少的范围
            /*
            可以分为两种小情况
            1.i'的左边界在L内 那么i的回文半径就应该和i'相同
            pArr[2*C-i]代表的是i'的回文半径
            2.i'的左边界越过了L或者与L压线 那么i处扩展的半径至少应该为R-i
             */
            //如果i在R外,那么i的最小长度为1
            pArr[i] = R>i ? Math.min(pArr[2*C-i],R-i) : 1;
            while (pArr[i]+i < chars.length && i-pArr[i] >= 0){
                //字符相同，继续扩展
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
        //原串长度需要-1
        return max-1;
    }


    public static String ManacherString(String s){
        //1.将字符串转为带#的形式,例如12321转写为#1#2#2#3#2#2#1#
        StringBuilder sb = new StringBuilder();
        sb.append("#");
        for (int i=0;i<s.length();i++){
            sb.append(s.charAt(i));
            sb.append("#");
        }
        char[] chars = sb.toString().toCharArray();

        int[] pArr = new int[chars.length];//回文半径数组
        int R = -1;//回文右边界再往右一个位置，真实有效区域是R-1
        int C = -1;//中心
        int max = Integer.MIN_VALUE;//扩展范围的最大值
        StringBuilder ans = new StringBuilder();
        for (int i=0;i<chars.length;i++){
            //如果i在R内，那么就取其至少的范围
            /*
            可以分为两种小情况
            1.i'的左边界在L内 那么i的回文半径就应该和i'相同
            pArr[2*C-i]代表的是i'的回文半径
            2.i'的左边界越过了L或者与L压线 那么i处扩展的半径至少应该为R-i
             */
            //如果i在R外,那么i的最小长度为1
            pArr[i] = R>i ? Math.min(pArr[2*C-i],R-i) : 1;
            while (pArr[i]+i < chars.length && i-pArr[i] >= 0){
                //字符相同，继续扩展
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
        //原串长度需要-1
        return ans.toString();
    }
    public static void main(String[] args) {
        System.out.println(ManacherString("babad"));
    }
}
