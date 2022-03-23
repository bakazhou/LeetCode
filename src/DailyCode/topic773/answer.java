package DailyCode.topic773;

import org.junit.Test;

import java.util.*;

public class answer {
    public int slidingPuzzle(int[][] board) {
        int step = 0;
        String cur = beString(board);
        if (cur.equals("123450")){
            return 0;
        }
        LinkedList<String> queue = new LinkedList<>();//进行bfs的基本队列
        Set<String> set = new HashSet<>();//记录0在string中的位置情况，保证不出现重复
        queue.add(cur);
        set.add(cur);
        while (!queue.isEmpty()){
            int n = queue.size();
            step++;
            for (int i =0;i<n;i++){
                String str = queue.getFirst();
                queue.removeFirst();
                if (str.equals("123450")){
                    return step;
                }
                List<String> afterSwap = swap(str);//当前string进行0置换后的所有情况
                for (String string : afterSwap) {
                    if (!set.contains(string)){
                        set.add(string);
                        queue.add(string);
                    }
                }
            }
        }
        return -1;
    }
    public String beString(int[][] board){
        StringBuilder sb = new StringBuilder();
        for (int i = 0;i<board.length;i++){
            for (int j = 0;j<board[0].length;j++){
                sb.append(Integer.toString(board[i][j]));
            }
        }
        return sb.toString();
    }
    /*
    枚举出当前0可以置换的所有位置
     */
    public List<String> swap(String str){
        char[] chars = str.toCharArray();
        List<String> ans = new ArrayList<>();
        int index = -1;
        for (int j=0;j<chars.length;j++){
            if (chars[j]=='0'){
                index=j;
                break;
            }
        }

        //在0处,可以与1和3交换
        if (index==0){
            //与1交换
            chars = str.toCharArray();
            char tem = chars[0];
            chars[0] = chars[1];
            chars[1] = tem;
            ans.add(new String(chars));

            //与3交换
            chars = str.toCharArray();
            tem = chars[0];
            chars[0] = chars[3];
            chars[3] = tem;
            ans.add(new String(chars));
        }

        else if ((index==1)){
            //与0交换
            chars = str.toCharArray();
            char tem = chars[1];
            chars[1] = chars[0];
            chars[0] = tem;
            ans.add(new String(chars));

            //与2交换
            chars = str.toCharArray();
            tem = chars[1];
            chars[1] = chars[2];
            chars[2] = tem;
            ans.add(new String(chars));


            //与4交换
            chars = str.toCharArray();
            tem = chars[1];
            chars[1] = chars[4];
            chars[4] = tem;
            ans.add(new String(chars));
        }

        else if (index==2){
            //与1换
            chars = str.toCharArray();
            char tem = chars[2];
            chars[2] = chars[1];
            chars[1] = tem;
            ans.add(new String(chars));
            //与5换
            chars = str.toCharArray();
            tem = chars[2];
            chars[2] = chars[5];
            chars[5] = tem;
            ans.add(new String(chars));
        }

        if (index==3){
            //与0交换
            chars = str.toCharArray();
            char tem = chars[3];
            chars[3] = chars[0];
            chars[0] = tem;
            ans.add(new String(chars));

            //与4交换
            chars = str.toCharArray();
            tem = chars[3];
            chars[3] = chars[4];
            chars[4] = tem;
            ans.add(new String(chars));
        }

        else if ((index==4)){
            //与3交换
            chars = str.toCharArray();
            char tem = chars[4];
            chars[4] = chars[3];
            chars[3] = tem;
            ans.add(new String(chars));

            //与5交换
            chars = str.toCharArray();
            tem = chars[4];
            chars[4] = chars[5];
            chars[5] = tem;
            ans.add(new String(chars));


            //与1交换
            chars = str.toCharArray();
            tem = chars[4];
            chars[4] = chars[1];
            chars[1] = tem;
            ans.add(new String(chars));
        }

        else if (index==5){
            //与2换
            chars = str.toCharArray();
            char tem = chars[5];
            chars[5] = chars[2];
            chars[2] = tem;
            ans.add(new String(chars));
            //与4换
            chars = str.toCharArray();
            tem = chars[5];
            chars[5] = chars[4];
            chars[4] = tem;
            ans.add(new String(chars));
        }
        return ans;
    }
}
