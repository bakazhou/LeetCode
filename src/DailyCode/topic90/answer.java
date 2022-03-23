package DailyCode.topic90;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

public class answer {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        ans.add(new ArrayList<>());
        int n = nums.length;
        for (int i=0;i<n;i++){
            String str = "";
            for (int j=i;j<n;j++){
                if (!set.contains(str+Integer.toString(nums[j]))){
                    str=str+Integer.toString(nums[j]);
                    char[] chars = str.toCharArray();
                    List<Integer> temp = new ArrayList<>();
                    for (int k=0;k<chars.length;k++){
                        temp.add(Integer.parseInt(String.valueOf(chars[k])));
                    }
                    ans.add(temp);
                    set.add(str);
                }
            }
            str = "";
        }
        return ans;
    }
}
