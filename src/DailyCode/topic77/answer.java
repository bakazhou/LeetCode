package DailyCode.topic77;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
/*
  [1,2],
  [1,3],
  [1,4],
  [2,3],
  [2,4],
  [3,4],
 */
public class answer {
    List<List<Integer>> ans;
    public List<List<Integer>> combine(int n, int k) {
        ans = new ArrayList<>();
        LinkedList<Integer> tem = new LinkedList<>();
        backTrack(tem,n,k,1);
        return ans;
    }
    public void backTrack(LinkedList<Integer> num,int n, int k,int cur){
        if (num.size()==k){
            ans.add(new ArrayList<>(num));
            return;
        }
        for (int i=cur;i<n;i++){
            num.add(i);
            backTrack(num, n, k, i);
            num.removeLast();
        }
    }
}
