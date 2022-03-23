package DailyCode.Offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class Offer102 {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,Integer> map = new HashMap<>();//存的是返回list中对应的索引
        List<List<String>> ans = new ArrayList<>();
        int n=strs.length,index = 0;
        for (int i=0;i<n;i++){
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            if (!map.containsKey(new String(chars))){
                map.put(chars.toString(),index);
                List<String> list = new ArrayList<>();
                list.add(strs[i]);
                ans.add(list);
                index++;
            }
            else {
                ans.get(map.get(chars.toString())).add(strs[i]);
            }
        }
        return ans;
    }
}
