package DailyCode.topic179;

import java.util.*;

public class answer {
    List<String> list;
    public String largestNumber(int[] nums) {
        list = new ArrayList<>();
        LinkedList<String> str = new LinkedList<>();
        backtrack(str,nums);
        Collections.sort(list);
        String ans = list.get(list.size()-1);
        return ans;
    }
    public void backtrack(LinkedList<String> str,int[] nums){
        if (str.size()==nums.length){
            StringBuilder sb = new StringBuilder();
            for (String tem:str){
                sb.append(tem);
            }
            list.add(sb.toString());
            return;
        }
        for (int i=0;i<nums.length;i++){
            if (str.contains(String.valueOf(nums[i]))){
                continue;
            }
            str.add(String.valueOf(nums[i]));
            backtrack(str, nums);
            str.removeLast();
        }
    }

    public String largestNumber1(int[] nums) {
        String[] temp = new String[nums.length];
        for (int i=0;i<nums.length;i++){
            temp[i] = String.valueOf(nums[i]);
        }
        // 自定义比较器
        Arrays.sort(temp, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                int l1 = o1.length(), l2 = o2.length();
                int i = 0;
                while (i < Math.min(l1, l2)) {  // 逐位比较
                    if (o1.charAt(i) > o2.charAt(i)) {
                        return 1;
                    }
                    else if (o1.charAt(i) < o2.charAt(i)) {
                        return -1;
                    }
                    i++;
                }
                if (l1 == l2) {  // 每位都相同，长度也相同，那么就认为相等
                    return 0;
                }
                if (i == l1) {  // 长字符串的剩余部分递归比较
                    return compare(o1, o2.substring(i));
                }
                else {
                    return compare(o1.substring(i), o2);
                }
            }
        });
        StringBuilder builder = new StringBuilder();
        for (int i=nums.length-1;i>=0;i--){
            if (i==nums.length-1 && temp[i].equals("0")) return "0";
            builder.append(temp[i]);
        }
        return builder.toString();

    }
}
