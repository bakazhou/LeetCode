package ½£Ö¸Offer2;

import java.util.LinkedList;

public class Offer038 {
    public int[] dailyTemperatures(int[] temperatures) {
        LinkedList<Integer> temperature = new LinkedList<>();
        LinkedList<Integer> index = new LinkedList<>();
        int n =temperatures.length;
        int[] day = new int[n];
        for (int i=0;i<n;i++){
                while (!temperature.isEmpty() && temperature.getLast()<temperatures[i]){
                    day[index.getLast()]=i-index.getLast();
                    temperature.removeLast();
                    index.removeLast();
                }
                temperature.add(temperatures[i]);
                index.add(i);
        }
        return day;
    }
}
