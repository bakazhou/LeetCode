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
                    f[fi] = fj;//��i�����j���ִ�����
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
        �����ַ������ж�
        ����������ط���һ����˵���������ַ�������������
         */
        int num = 0;
        for (int i = 0; i < len; i++) {
            if (a.charAt(i) != b.charAt(i)) {
                num++;
                if (num > 2) {//����������
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int a,b;
        Scanner scanner=new Scanner(System.in);
        System.out.println("������a");
        a=scanner.nextInt();
        System.out.println("������b");
        b=scanner.nextInt();
        System.out.println(a+b);
    }
}
