package DailyCode.topic1178;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class answer {
    public List<Integer> findNumOfValidWords(String[] words, String[] puzzles) {
        List<Integer> ans = new ArrayList<>();
        List<HashSet> check = new ArrayList<>();
        int[] temp = new int[puzzles.length];
        for (int i=0;i<puzzles.length;i++){
            Set<Character> set = new HashSet<>();
            char[] chars = puzzles[i].toCharArray();
            for (int j=0;j<chars.length;j++){
                set.add(chars[j]);
            }
            check.add((HashSet) set);
        }
        for (int i=0;i<words.length;i++) {
            for (int k=0;k<check.size();k++){
                char[] chars = words[i].toCharArray();
                boolean flag = true;
                Set<Character> set = check.get(k);
                for (int j=0;j<chars.length;j++) {
                    if (j==0){
                        if (chars[j]!=puzzles[k].charAt(0)){
                            flag=false;
                            break;
                        }
                    }
                    else if (!set.contains(chars[j])){
                        flag=false;
                        break;
                    }
                }
                if (flag){
                    temp[k]++;
                }
            }
        }
        for (int i=0;i<temp.length;i++){
            ans.add(temp[i]);
        }
        return ans;
    }

}
