package DailyCode.topic127;

import java.util.*;

class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int step = 0;
            //记录wordList当中的所有单词
            HashSet<String> word = new HashSet<>();
            for (String key : wordList){
                word.add(key);
            }
            if (word.size()==0 || !word.contains(endWord) || beginWord.equals(endWord)){
                return 0;
            }
            //用于BFS搜索
            LinkedList<String> queue = new LinkedList<>();
            //用于存储单词是否访问过
            HashSet<String> visited = new HashSet<>();
            queue.add(beginWord);
            visited.add(beginWord);
            boolean flag = false;
            while (!queue.isEmpty()){
                int n = queue.size();
                for (int i=0;i<n;i++){
                    String first = queue.getFirst();
                    if (first.equals(endWord)){
                        return step;
                    }
                    queue.removeFirst();
                    helper(first,word,queue,visited);
                }
                step++;
            }
            return 0;
        }
        public void helper(String curWord,HashSet<String> word,LinkedList<String> queue,HashSet<String> visited){
            char[] chars = curWord.toCharArray();
            for (int i=0;i<chars.length;i++){
                char c = chars[i];
                //26个字母对i位置进行替换
                for (char ch = 'a';ch <= 'z';ch++){
                    chars[i] = ch;
                    String changeWord = new String(chars);
                    //改变后的字符串没有被访问过,且在wordList中
                    if (!visited.contains(changeWord) && word.contains(changeWord)){
                        queue.add(changeWord);
                        visited.add(changeWord);
                    }
                }
                //还原
                chars[i] = c;
            }
        }
}