package DailyCode.topic5947;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��26�� 11:16
 **/
class Solution {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        List<String> res = new ArrayList<>();
        Set<String> have = new HashSet<>();
        for (String s : supplies){
            have.add(s);
        }
        Map<String,Set<String>> map = new HashMap<>();
        Set<String> sucess = new HashSet<>();
        Set<String> usedDo = new HashSet<>();
        for (int i=0;i<recipes.length;i++){
            Set<String> set = new HashSet<>();
            set.addAll(ingredients.get(i));
            map.put(recipes[i],set);
        }
        for (int i=0;i<recipes.length;i++){
            if (sucess.contains(recipes[i])){
                res.add(recipes[i]);
            }else {
                if (canMake(map,have,sucess,recipes[i],usedDo)){
                    res.add(recipes[i]);
                }
            }
        }
        return res;
    }
    public boolean canMake(Map<String,Set<String>> map,Set<String> have,Set<String> sucess,String make,Set<String> usedDo){
        Set<String> set = map.get(make);
        usedDo.add(make);
        for (String s : set){
            //�Ѿ����ɹ��� ����������ʳ��
            if (sucess.contains(s) || have.contains(s)){
                continue;
            }
            //����ʳ����Ҫ�Ƚ�������
            if (map.containsKey(s)){
                //��û����������ʳ�Ĳ������ɹ���
                if (!usedDo.contains(s) && canMake(map,have,sucess,s,usedDo)){
                    //�����ɹ�
                    sucess.add(s);
                }else {
                    return false;
                }
            }else {
                //û������ʳ��
                if (!have.contains(s)){
                    return false;
                }
            }
        }
        sucess.add(make);
        return true;
    }
}