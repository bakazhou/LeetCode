package DailyCode.topic71;

import java.util.LinkedList;

/**
 * @author bakazhou
 * @description
 * @date 2022年01月06日 13:08
 **/
class Solution {
    public String simplifyPath(String path) {
        String[] mem = path.split("/");
        LinkedList<String> stack = new LinkedList<>();
        StringBuilder res = new StringBuilder();
        for (String str : mem){
            //弹出当前目录
            if (str.equals("..")){
                if (!stack.isEmpty()){
                    stack.removeLast();
                }else {
                    continue;
                }
            }
            else if (str.length() > 0 && !".".equals(str)) {
                stack.add(str);
            }

        }
        if (stack.isEmpty()){
            res.append("/");
        }else {
            while (!stack.isEmpty()){
                res.append("/");
                res.append(stack.getFirst());
                stack.removeFirst();
            }
        }
        return res.toString();
    }
}