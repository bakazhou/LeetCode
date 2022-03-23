package Hash������Hash��;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

//���һ�����ݽṹʵ��insert(),delete(),getRandom()����,ʱ�临�Ӷȶ�Ϊ1
//getRandom����ÿһ�����ļ��ʱ�����ͬ
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
        //n����Ҫɾ��������
        if (n==0){
            return;
        }
        //���ɾ�����ݣ���Ҫ��index--�������ֶ�ԭ��λ�ý��в�ȫ
        int indexNum = indexToInt.get(index--);//Ŀǰindex--��������
        int nIndex = intToIndex.get(n);//�ҵ�n���±�
        indexToInt.put(nIndex,indexNum);//����nIndex����ӳ��
        intToIndex.put(indexNum,nIndex);//����indexNum��index��ӳ��
        indexToInt.remove(index);//ɾ��index�������ֵ�ӳ�䣬��Ϊ����ת�Ƶ�nIndex��
        intToIndex.remove(n);//ɾ��n��num��ӳ��
    }
    public int getRandom(){
        return indexToInt.get(random.nextInt(index));
    }
}
