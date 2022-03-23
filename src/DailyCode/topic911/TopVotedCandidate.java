package DailyCode.topic911;

import com.sun.org.apache.regexp.internal.RE;

import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月11日 10:39
 **/
class TopVotedCandidate {
    // 人获得的票数
    Map<Integer,Integer> cntMap = new HashMap<>();
    // 当前时间领先的人
    TreeMap<Integer,Integer> tm = new TreeMap<>();
    public TopVotedCandidate(int[] persons, int[] times) {
        //记录得票最多人的id
        int maxPersonId = -1;
        for(int i = 0;i < persons.length;i++) {
            // 人的得票增加
            int cnt = cntMap.getOrDefault(persons[i],0) + 1;
            //记录当前人的得票
            cntMap.put(persons[i],cnt);
            // 之前得票最多的人
            int maxCnt = cntMap.getOrDefault(maxPersonId,0);
            //当前人得票比之前最高得票多
            if(cnt >= maxCnt) {
                //记录当前得票人id
                maxPersonId = persons[i];
            }
            // 维护当前时间得票最多的personId
            tm.put(times[i],maxPersonId);
        }
    }

    public int q(int t) {
        return tm.floorEntry(t).getValue();
    }
}