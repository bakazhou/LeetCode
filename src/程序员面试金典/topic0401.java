package 程序员面试金典;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月08日 10:58
 **/
public class topic0401 {
    public boolean findWhetherExistsPath(int n, int[][] graph, int start, int target) {
        Map<Integer, HashSet<Integer>> map = new HashMap<>();
        for (int i=0;i<graph.length;i++){
            int[] go = graph[i];
            if (!map.containsKey(go[0])){
                HashSet<Integer> set = new HashSet<>();
                set.add(go[1]);
                map.put(go[0],set);
            }else {
                HashSet<Integer> set = map.get(go[0]);
                set.add(go[1]);
            }
        }
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(start);
        visited[start] = true;
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i=0;i<size;i++){
                int first = queue.getFirst();
                queue.removeFirst();
                if (first == target){
                    return true;
                }
                if (map.containsKey(first)){
                    HashSet<Integer> set = map.get(first);
                    for (int key : set){
                        if (!visited[key]){
                            queue.add(key);
                            visited[key] = true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
