package DailyCode.topic318;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int maxProduct(String[] words) {
        Arrays.sort(words, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if (o1.length() >= o2.length()){
                    return 1;
                }
                return -1;
            }
        });
        System.out.println(Arrays.toString(words));
        int ans = 0;
        Map<Integer,int[]> map = new HashMap<>();
        for(int i=0;i<words.length;i++){
            int[] mem = new int[26];
            for (int j=0;j<words[i].length();j++){
                mem[words[i].charAt(j)-97]++;
            }
            map.put(i,mem);
        }
        for(int i=0;i<words.length-1;i++){
            int[] memi = map.get(i);
            boolean flag = true;
            for (int j=i+1;j<words.length;j++){
                int[] memj = map.get(j);
                System.out.println(Arrays.toString(memi));
                System.out.println(Arrays.toString(memj));
                for (int z=0;z<26;z++){
                    if (memi[z]!=0 && memj[z]!=0){
                        flag = false;
                        break;
                    }
                }
                if (flag){
                    ans = Math.max(words[i].length()*words[j].length(),ans);
                }
            }
        }
        return ans;
    }
}