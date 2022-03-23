package DailyCode.topic2034;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月17日 10:05
 **/
public class Solution {
    public static void main(String[] args) {
        StockPrice stockPrice = new StockPrice();
        stockPrice.update(1,10);
        stockPrice.update(2,5);

    }
}
class StockPrice {
    int curTime;
    HashMap<Integer,Integer> map;
    TreeMap<Integer,Integer> priceMap;
    public StockPrice() {
        map = new HashMap<>();
        priceMap = new TreeMap<>();
        curTime = 0;
        
    }

    public void update(int timestamp, int price) {
        //说明在修改已经包含的时间戳,那么priceMap中记录的价格也需要修改
        if (map.containsKey(timestamp)){
            int oldPrice = map.get(timestamp);
            if (priceMap.get(oldPrice) == 1){
                priceMap.remove(oldPrice);
            }else {
                priceMap.put(oldPrice,priceMap.get(oldPrice)-1);
            }
        }
        priceMap.put(price, priceMap.getOrDefault(price, 0) + 1);
        map.put(timestamp,price);
        curTime = Math.max(timestamp,curTime);
    }

    public int current() {
        return map.get(curTime);
    }

    public int maximum() {
        return priceMap.lastKey();
    }

    public int minimum() {
        return priceMap.firstKey();
    }
}
