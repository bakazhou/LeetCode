package DailyCode.topic126;

import java.util.*;
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        List<List<String>> ans = new ArrayList<>();
        int step = 0;
        //��¼wordList���е����е���
        HashSet<String> word = new HashSet<>();
        for (String key : wordList){
            word.add(key);
        }
        if (word.size()==0 || !word.contains(endWord) || beginWord.equals(endWord)){
            return ans;
        }
        //����BFS����
        LinkedList<ArrayList<String>> queue = new LinkedList<>();
        //���ڴ洢�����Ƿ���ʹ�
        HashSet<String> visited = new HashSet<>();
        ArrayList<String> path = new ArrayList<>();
        path.add(beginWord);
        queue.add(path);
        visited.add(beginWord);
        while (!queue.isEmpty()){
            int n = queue.size();
            boolean flag = false;
            Set<String> tSet = new HashSet<>();
            for (int i=0;i<n;i++){
                ArrayList<String> first = queue.getFirst();
                queue.removeFirst();
                String cur = first.get(first.size()-1);
                List<String> changeWord = helper(cur,  word);
                for (String cWord:changeWord){
                    if (!visited.contains(cWord)){
                        ArrayList<String> tem = (ArrayList<String>) first.clone();
                        if (cWord.equals(endWord)){
                            flag = true;
                            tem.add(cWord);
                            ans.add(tem);
                        }else {
                            tem.add(cWord);
                            queue.add(tem);
                        }
                        tSet.add(cWord);
                    }
                }
            }
            visited.addAll(tSet);
            if (flag){
                return ans;
            }
        }
        return ans;
    }
    public List<String> helper(String curWord,HashSet<String> word){
        List<String> result = new ArrayList<>();
        char[] chars = curWord.toCharArray();
        for (int i=0;i<chars.length;i++){
            char c = chars[i];
            //26����ĸ��iλ�ý����滻
            for (char ch = 'a';ch <= 'z';ch++){
                chars[i] = ch;
                String changeWord = new String(chars);
                //�ı����ַ���û�б����ʹ�,����wordList��
                if (word.contains(changeWord)){
                    result.add(changeWord);
                }
            }
            //��ԭ
            chars[i] = c;
        }
        return result;
    }
}