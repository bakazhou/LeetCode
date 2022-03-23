package DailyCode.topic508;

import java.util.*;

public class answer {
    List<Integer> list;
    public int[] findFrequentTreeSum(TreeNode root) {
        if (root==null) return new int[]{};
        list = new ArrayList<>();
        Sum(root);
        Map<Integer,Integer> map = new HashMap<>();
        int max = 1,times = Integer.MIN_VALUE;
        for (Integer num : list) {
            if (map.containsKey(num)){
                map.put(num,map.get(num)+1);
            }else map.put(num,1);
            if (map.get(num)>times){
                times=map.get(num);
                max=num;
            }
        }
        map.remove(max);
        if (times!=1 && !map.containsValue(times)) return new int[]{max};
        if (map.containsValue(times)){
            List<Integer> integers = new ArrayList<>();
            Set<Integer> set = map.keySet();
            for (Integer num : set) {
                if (map.get(num)==times){
                    integers.add(num);
                }
            }
            integers.add(max);
            int[] ans = new int[integers.size()];
            for (int i=0;i<ans.length;i++) ans[i]=list.get(i);
            Arrays.sort(ans);
            return ans;
        }
        int[] ans = new int[list.size()];
        for (int i=0;i<list.size();i++) ans[i]=list.get(i);
        return ans;
    }
    public int Sum(TreeNode root){
        int sum=0;
        sum+=root.val;
        if (root.left!=null){
            sum+=Sum(root.left);
        }
        if (root.right!=null){
            sum+=Sum(root.right);
        }
        list.add(sum);
        return sum;
    }

    public static void main(String[] args) {
        int[] a = {-99990,-199983,-299904,-99890,-499694,-99795,-99763,-299322,-99697,-199404,-598473,-698290,-797976,-1397530,-99649,-199320,-99588,-199206,-498174,-1995386,-99564,-99530,-199043,-99504,-398052,-597153,-99487,-796138,-2891094,-99422,-198848,-298276,-397686,-99353,-198694};
        int[] b = {49655,204166,38535,-1313,-5722,-186592,-19389,-22049,-2328,-166939,86119,38530,-66221,66175,231614,257921,84318,219795,-180421,93408,61441,83664,98999,-36488,65154,181827,66842,-1739,-83455,-66985,-38038,-12628,-46224,-79030};
        Arrays.sort(a);
        Arrays.sort(b);
        System.out.println(Arrays.toString(a));
        System.out.println(Arrays.toString(b));

    }
}
