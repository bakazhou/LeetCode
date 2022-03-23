package DailyCode.topic1660;

import java.util.*;

public class answer {
    class ThroneInheritance {
        public String name;
        public boolean isDeath;
        HashMap<String,ThroneInheritance> map;
        List<String> child;
        List<String>InheritanceOrder;
        public ThroneInheritance(String kingName) {
            this.name = kingName;
            this.isDeath = false;
            child = new ArrayList<>();
            child.add(kingName);
            map = new HashMap<>();
            map.put(kingName,this);
        }

        public void birth(String parentName, String childName) {
            ThroneInheritance child = new ThroneInheritance(childName);
            ThroneInheritance parent = map.get(parentName);
            parent.child.add(childName);
            map.put(parentName,parent);
            map.put(childName,child);
        }

        public void death(String name) {
            ThroneInheritance death = map.get(name);
            death.isDeath=true;
        }

        public List<String> getInheritanceOrder() {
            InheritanceOrder = new ArrayList<>();

                dfs(this);

            return InheritanceOrder;
        }
        public void dfs(ThroneInheritance parent){
            List<String> child = parent.child;
            if (!parent.isDeath && !InheritanceOrder.contains(parent)){
                InheritanceOrder.add(parent.name);
            }
            for (int i=1;i<child.size();i++){
                ThroneInheritance childs = map.get(child.get(i));
                dfs(childs);
            }
        }
    }
}
