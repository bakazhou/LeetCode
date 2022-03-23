package DailyCode.topic17;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class answer {
    private String[][] str = {{"a","b","c"},{"d","e","f"},{"g","h","i"},{"j","k","l"}
    ,{"m","n","o"},{"p","q","r","s"},{"t","u","v"},{"w","x","y","z"}};
    List<String> ans;
    public List<String> letterCombinations(String digits) {
        char[] digit = digits.toCharArray();
        ans = new ArrayList<>();
        if (digits.length()==0) return ans;
        List<String[]> chars = new ArrayList<>();
        for (int i=0;i<digit.length;i++){
            String[] str1= str[Integer.parseInt(String.valueOf(digit[i]))-2];
            chars.add(str1);
        }
        HashSet<String> check = new HashSet<>();//判断是否已经存在
        backTrack(digit.length,check,"",chars,0);
        return ans;
    }
    public void backTrack(int length, HashSet<String> check,String goal,List<String[]> chars,int rows){
        if (check.contains(goal)) return;
        if (goal.length()==length){
            ans.add(goal);
            check.add(goal);
            return;
        }
        int n = chars.size();
        String[] strings = chars.get(rows);
        for (int j=0;j<strings.length;j++){
            backTrack(length, check, goal+strings[j], chars,rows+1);
        }

    }
}
