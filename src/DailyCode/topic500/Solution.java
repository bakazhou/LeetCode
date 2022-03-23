package DailyCode.topic500;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public String[] findWords(String[] words) {
        String[] str = new String[3];
        str[0] = "qwertyuiop";
        str[1] = "asdfghjkl";
        str[2] = "zxcvbnm";
        Map<Character,Integer> map = new HashMap<>();
        List<String> list = new ArrayList<>();
        for (int i=0;i<str.length;i++){
            String string = str[i];
            for (int j=0;j<string.length();j++){
                map.put(string.charAt(j),i);
            }
        }
        for (int i=0;i<words.length;i++){
            String string = words[i].toLowerCase();
            int row = map.get(string.charAt(0));
            boolean flag = true;
            for (int j=1;j<string.length();j++){
                if (map.get(string.charAt(j))!=row){
                    flag = false;
                    break;
                }
            }
            if (flag){
                list.add(words[i]);
            }
        }
        String[] ans = new String[list.size()];
        for (int i=0;i<ans.length;i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}