package DailyCode.topic2043;

/**
 * @author bakazhou
 * @description
 * @date 2021Äê12ÔÂ16ÈÕ 12:27
 **/
public class Solution {
}
class Bank {
    private long[] balance;
    public int size;
    public Bank(long[] balance) {
        this.balance = balance.clone();
        this.size = balance.length;
    }

    public boolean transfer(int account1, int account2, long money) {
        try {
            if (balance[account1-1] >= money){
                balance[account2-1] += money;
                balance[account1-1] -= money;
                return true;
            }
        }catch (Exception e){
        }
        return false;
    }

    public boolean deposit(int account, long money) {
        try {
            balance[account-1] += money;
        }catch (Exception e){
        }
        return false;
    }

    public boolean withdraw(int account, long money) {
        try {
            if (balance[account-1] >= money){
                balance[account-1] -= money;
                return true;
            }
        }catch (Exception e){
        }
        return false;
    }
}
