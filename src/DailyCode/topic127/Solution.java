package DailyCode.topic127;

import java.util.*;

class Solution {
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            int step = 0;
            //��¼wordList���е����е���
            HashSet<String> word = new HashSet<>();
            for (String key : wordList){
                word.add(key);
            }
            if (word.size()==0 || !word.contains(endWord) || beginWord.equals(endWord)){
                return 0;
            }
            //����BFS����
            LinkedList<String> queue = new LinkedList<>();
            //���ڴ洢�����Ƿ���ʹ�
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
                //26����ĸ��iλ�ý����滻
                for (char ch = 'a';ch <= 'z';ch++){
                    chars[i] = ch;
                    String changeWord = new String(chars);
                    //�ı����ַ���û�б����ʹ�,����wordList��
                    if (!visited.contains(changeWord) && word.contains(changeWord)){
                        queue.add(changeWord);
                        visited.add(changeWord);
                    }
                }
                //��ԭ
                chars[i] = c;
            }
        }
}