package DailyCode.topic119;

import java.util.ArrayList;
import java.util.List;

public class answer {
    public List<Integer> getRow(int rowIndex) {
        List<List<Integer>> lists = new ArrayList<>();
        List<Integer> num1 = new ArrayList<>();
        num1.add(1);
        lists.add(num1);
        List<Integer> num2 = new ArrayList<>();
        num2.add(1);
        num2.add(1);
        lists.add(num2);
        System.out.println(lists);
        for (int i=2;i<rowIndex;i++){
            List<Integer> ans = new ArrayList<>();
            for (int j=0;j<i;j++){
                if (j==0 || j==i-1){
                    ans.add(1);
                }else {
                    num1=lists.get(i-1);
                    ans.add(num1.get(j-1)+num1.get(j));
                }
            }
            lists.add(ans);
        }
        return lists.get(rowIndex-1);
    }
}
