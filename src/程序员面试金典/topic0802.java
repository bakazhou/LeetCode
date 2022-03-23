package 程序员面试金典;

/**
 * @author bakazhou
 * @description
 * @date 2021年12月09日 12:47
 **/
class Solution {
    public int multiply(int A, int B) {
        return dfs(0,A,B);
    }
    public int dfs(int num,int A,int B){
        if (B == 0){
            return num;
        }
        return dfs(num+A, A, B-1);
    }
}