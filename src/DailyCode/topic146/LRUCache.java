package DailyCode.topic146;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.WeakHashMap;

public class LRUCache {
    private int maxSize = 0;
    private int size = 0;
    LinkedList<Integer> queue;
    private Map<Integer,Integer> map;
    public LRUCache(int capacity) {
        maxSize = capacity;
        map = new HashMap<>();
        queue = new LinkedList<>();
    }
    public int get(int key) {
        LinkedList<Integer> t = new LinkedList<>();
        if (map.containsKey(key)){
            while (!queue.isEmpty()){
                if (queue.getLast()!=key){
                    t.add(queue.getLast());
                }
                queue.removeLast();
            }
            while (!t.isEmpty()){
                queue.add(t.getFirst());
                t.removeFirst();
            }
            queue.add(key);
        }
        return -1;
    }

    public void put(int key, int value) {
        //�Ѵﵽ���������key��map�в����� ��Ҫɾ�����δʹ�õ�key
        //������ǰ��������δʹ�õ�key
        if (!map.containsKey(key) && size == maxSize){
            map.remove(queue.getFirst());
            queue.removeFirst();
            size--;
        }
        if (!map.containsKey(key)){
            queue.add(key);
            size++;
        }else {
            LinkedList<Integer> t = new LinkedList<>();
            while (!queue.isEmpty()){
                if (queue.getLast()!=key){
                    t.add(queue.getLast());
                }
                queue.removeLast();
            }
            while (!t.isEmpty()){
                queue.add(t.getFirst());
                t.removeFirst();
            }
            queue.add(key);
        }
        map.put(key,value);
    }
}

