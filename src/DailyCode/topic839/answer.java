package DailyCode.topic839;

import java.util.Scanner;

public class answer {
    int[] f;
    public int numSimilarGroups(String[] strs) {
        int n = strs.length;
        int m = strs[0].length();
        f = new int[n];
        for (int i = 0; i < n; i++) {
            f[i] = i;
        }
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int fi = find(i), fj = find(j);
                System.out.println("fi:"+fi+"   fj:"+fj);
                if (fi == fj) {
                    continue;
                }
                if (check(strs[i], strs[j], m)) {
                    f[fi] = fj;//第i个与第j个字串相似
                }
                for (int k=0;k<n;k++){
                    System.out.println(f[k]);
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < n; i++) {
            if (f[i] == i) {
                ret++;
            }
        }
        return ret;
    }

    public int find(int x) {
        return f[x] == x ? x : (f[x] = find(f[x]));
        /*
        if(f[x] == x){
        return x;
        }else{
         f[x] = find(f[x];
        }
         */
    }

    public boolean check(String a, String b, int len) {
        /*
        两个字符串做判断
        如果有两个地方不一样则说明这两个字符串不可能相似
         */
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) {//不可能相似
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a,b;
        Scanner scanner=new Scanner(System.in);
        System.out.println("请输入a");
        a=scanner.nextInt();
        System.out.println("请输入b");
        b=scanner.nextInt();
        System.out.println(a+b);
    }
}
