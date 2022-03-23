package Hash函数与Hash表;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//设计一个数据结构实现insert(),delete(),getRandom()方法,时间复杂度都为1
//getRandom返回每一个数的几率必须相同
public class RandomPoll {
    int index;
    Map<Integer,Integer> indexToInt;
    Map<Integer,Integer> intToIndex;
    Random random;
    RandomPoll(){
        index = 0;
        indexToInt = new HashMap<>();
        intToIndex = new HashMap<>();
        random = new Random();
    }
    public void insert(int n){
        indexToInt.put(index,n);
        intToIndex.put(n,index++);
    }
    public void delete(int n){
        //n是需要删除的数字
        if (n==0){
            return;
        }
        //如果删除数据，需要用index--处的数字对原本位置进行补全
        int indexNum = indexToInt.get(index--);//目前index--处的数字
        int nIndex = intToIndex.get(n);//找到n的下标
        indexToInt.put(nIndex,indexNum);//覆盖nIndex处的映射
        intToIndex.put(indexNum,nIndex);//覆盖indexNum到index的映射
        indexToInt.remove(index);//删除index处的数字的映射，因为其已转移到nIndex处
        intToIndex.remove(n);//删除n到num的映射
    }
    public int getRandom(){
        return indexToInt.get(random.nextInt(index));
    }
}
