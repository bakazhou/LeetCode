
import java.util.*;

class Solution {
}
class StockPrice {
    TreeMap<Integer,Integer> priceMap;//价格->出现次数
    TreeMap<Integer,Integer> timeMap;//时间戳->对应价格
    public StockPrice() {
        priceMap = new TreeMap<>();
        timeMap = new TreeMap<>();
    }

    public void update(int timestamp, int price) {
        if (timeMap.containsKey(timestamp)){
            int oldPrice = timeMap.get(timestamp);
            if (priceMap.get(oldPrice) == 1){
                priceMap.remove(oldPrice);
            }else {
                priceMap.put(oldPrice,priceMap.get(oldPrice)-1);
            }
        }
        priceMap.put(price,priceMap.getOrDefault(price,0)+1);
        timeMap.put(timestamp,price);
    }

    public int current() {
        return timeMap.get(timeMap.lastKey());
    }

    public int maximum() {
        return priceMap.lastKey();
    }

    public int minimum() {
        return priceMap.firstKey();
    }
}

