package DailyCode.topic68;

import javax.swing.plaf.nimbus.AbstractRegionPainter;
import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        /*
        һ��һ�ʣ��ұ߲���ո�
        ���һ�У�����룬����֮�䲻�������Ŀո�
        һ�ж�ʣ��ո���ȷ��䣬���ܾ��ȵ�����������Ҳ�࣬Ҳ���Ǿ������ȣ���Ĵ���߿�ʼ���μ� 1��
         */
        List<String> ans = new ArrayList<>();
        int n = words.length;
        List<String> cur_Word = new ArrayList<>();//����������ʹ�õĵ���
        int capacity = 0,index = 0;//������������ǰ������е���
        while (index<n){
            capacity = capacity+words[index].length();
            int cur_space = maxWidth-capacity;//ʣ��Ŀո����λ
            int least_space = cur_Word.size()-1;//������Ҫ�Ŀո�λ
            if (capacity>maxWidth || cur_space<least_space){//��ǰ���ʳ����Ѿ�����max����ʣ��Ŀո�λС�����ٵĿո����λ
//                int space =
            }
        }
        return ans;
    }
}
