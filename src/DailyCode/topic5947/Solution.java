package DailyCode.topic5947;

import java.util.*;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月26日 11:16
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
            //已经做成功过 或者有这种食材
            if (sucess.contains(s) || have.contains(s)){
                continue;
            }
            //这种食材需要先进行制作
            if (map.containsKey(s)){
                //还没有做过这种食材并且做成功了
                if (!usedDo.contains(s) && canMake(map,have,sucess,s,usedDo)){
                    //制作成功
                    sucess.add(s);
                }else {
                    return false;
                }
            }else {
                //没用这种食材
                if (!have.contains(s)){
                    return false;
                }
            }
        }
        sucess.add(make);
        return true;
    }
}