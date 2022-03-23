package DailyCode.topic911;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��11�� 10:39
 **/
class TopVotedCandidate {
    // �˻�õ�Ʊ��
    Map<Integer,Integer> cntMap = new HashMap<>();
    // ��ǰʱ�����ȵ���
    TreeMap<Integer,Integer> tm = new TreeMap<>();
    public TopVotedCandidate(int[] persons, int[] times) {
        //��¼��Ʊ����˵�id
        int maxPersonId = -1;
        for(int i = 0;i < persons.length;i++) {
            // �˵ĵ�Ʊ����
            int cnt = cntMap.getOrDefault(persons[i],0) + 1;
            //��¼��ǰ�˵ĵ�Ʊ
            cntMap.put(persons[i],cnt);
            // ֮ǰ��Ʊ������
            int maxCnt = cntMap.getOrDefault(maxPersonId,0);
            //��ǰ�˵�Ʊ��֮ǰ��ߵ�Ʊ��
            if(cnt >= maxCnt) {
                //��¼��ǰ��Ʊ��id
                maxPersonId = persons[i];
            }
            // ά����ǰʱ���Ʊ����personId
            tm.put(times[i],maxPersonId);
        }
    }

    public int q(int t) {
        return tm.floorEntry(t).getValue();
    }
}