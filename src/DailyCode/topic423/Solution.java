package DailyCode.topic423;

import java.util.*;

public class Solution {
    String[] strings = {"zero","six","eight","two","seven","five","four","three","one","nine"};
    int[] nums = {0,6,8,2,7,5,4,3,1,9};
    public String originalDigits(String s) {
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0;i<s.length();i++){
            if (!map.containsKey(s.charAt(i))){
                map.put(s.charAt(i),1);
            }else {
                map.put(s.charAt(i),map.get(s.charAt(i))+1);
            }
        }
        List<Integer> num = new ArrayList<>();
        while (!map.isEmpty()){
            int i = 0;
            while (!map.isEmpty() && i<strings.length){
                char[] chars = strings[i].toCharArray();
                boolean flag = true;
                for (int j=0;j<chars.length;j++){
                    if (!map.containsKey(chars[j])){
                        flag = false;
                    }
                }
                if (flag){
                    num.add(nums[i]);
                    for (int j=0;j<chars.length;j++){
                        int n = map.get(chars[j]);
                        if (n==1){
                            map.remove(chars[j]);
                        }else {
                            map.put(chars[j],n-1);
                        }
                    }
                }else {
                    break;
                }
            }
            i++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        Collections.sort(num);
        for (int i=0;i<num.size();i++){
            stringBuilder.append(num.get(i));
        }
        return stringBuilder.toString();
    }
}
