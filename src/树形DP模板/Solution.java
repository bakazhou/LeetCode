package 树形DP模板;

/*
抉择问题可以通用
树形DP的套路，伪代码
例题:打家劫舍III
难点在于决策的选择和分类
 */

public class Solution {
    public static class Info{
        public int doValue;//做可以获得的价值
        public int noValue;//不做可以获得最大价值
        public Info(int n,int m){
            this.doValue=n;
            this.noValue=m;
        }
    }
//    public Info judge(E e){//进行决策
//        if (e == null){
//            return new Info(e.value,0);
//        }
//        int doValue = e.value;
//        int noValue = 0;
//        while(e.next == null){//e还有其后继,那么需要对其所有的后继进行抉择
//            Info info = judge(e.next);
//            doValue += info.noValue;
//            noValue += Math.max(info.doValue,info.noValue);
//        }
//        return new Info(doValue,noValue);
//    }

}
