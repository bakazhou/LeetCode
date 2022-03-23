package DailyCode.topic638;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    int n;
    public int shoppingOffers(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        this.n = price.size();
        return dfs(price, special, needs);
    }

    private int dfs(List<Integer> price, List<List<Integer>> special, List<Integer> needs) {
        // 不使用大礼包的情况下
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += needs.get(i) * price.get(i);
        }

        // 使用大礼包的情况下
        for (List<Integer> s : special) {
            // 大礼包可以购买无限次
            // 这里相当于深拷贝一个新的List出来，所以，下面不用恢复状态了
            List<Integer> curr = new ArrayList<>(needs);
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                // 判断是否超出数量限制
                if (curr.get(i) - s.get(i) < 0) {
                    flag = true;
                    break;
                }
                curr.set(i, curr.get(i) - s.get(i));
            }

            // 未超出数量限制
            if (!flag) {
                // 选定这个礼包，并继续递归
                ans = Math.min(ans, s.get(n) + dfs(price, special, curr));
            }
        }

        return ans;
    }
}
