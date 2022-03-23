package DailyCode.topic68;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        /*
        一行一词：右边补充空格；
        最后一行：左对齐，单词之间不插入额外的空格；
        一行多词：空格均匀分配，不能均匀的情况下左侧比右侧多，也就是尽量均匀，多的从左边开始依次加 1。
         */
        List<String> ans = new ArrayList<>();
        int n = words.length;
        List<String> cur_Word = new ArrayList<>();//用来存所有使用的单词
        int capacity = 0,index = 0;//用来记下来当前存的所有单词
        while (index<n){
            capacity = capacity+words[index].length();
            int cur_space = maxWidth-capacity;//剩余的空格填充位
            int least_space = cur_Word.size()-1;//至少需要的空格位
            if (capacity>maxWidth || cur_space<least_space){//当前单词长度已经大于max或者剩余的空格位小于最少的空格填充位
//                int space =
            }
        }
        return ans;
    }
}
