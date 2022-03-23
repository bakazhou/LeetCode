package DailyCode.topic690;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
public class answer {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer,Employee> map = new HashMap<>();
        for (int i=0;i<employees.size();i++){
            Employee employee = employees.get(i);
            map.put(employee.id,employee);
        }
        int imp = getImportance(map,id);
        return imp;
    }
    public int getImportance(Map<Integer,Employee> map, int id) {
        Employee employee = map.get(id);
        int sum = 0;
        List<Integer> ids = employee.subordinates;
        if (ids!=null && ids.size()!=0){
            for (Integer eid:ids){
                sum+=getImportance(map,eid);
            }
        }
        return sum;
    }
}
