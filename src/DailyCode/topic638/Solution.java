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
        // ��ʹ�ô�����������
        int ans = 0;
        for (int i = 0; i < n; i++) {
            ans += needs.get(i) * price.get(i);
        }

        // ʹ�ô�����������
        for (List<Integer> s : special) {
            // ��������Թ������޴�
            // �����൱�����һ���µ�List���������ԣ����治�ûָ�״̬��
            List<Integer> curr = new ArrayList<>(needs);
            boolean flag = false;
            for (int i = 0; i < n; i++) {
                // �ж��Ƿ񳬳���������
                if (curr.get(i) - s.get(i) < 0) {
                    flag = true;
                    break;
                }
                curr.set(i, curr.get(i) - s.get(i));
            }

            // δ������������
            if (!flag) {
                // ѡ�����������������ݹ�
                ans = Math.min(ans, s.get(n) + dfs(price, special, curr));
            }
        }

        return ans;
    }
}
