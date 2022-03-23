package DailyCode.topic7;

public class answer {
    public  static int reverse(int x) {
        if (x==0) return 0;
        String str = Integer.toString(x);
        char[] chars = str.toCharArray();
        String ans = "";
        for (int i=chars.length-1;i>=0;i--){
            if (chars[i]!='-'){
                if (chars[i]=='0'){
                    if (ans.length()!=0){
                        ans+=chars[i];
                    }
                }else ans+=chars[i];
            }
        }
        return x>0?Integer.parseInt(ans):-Integer.parseInt(ans);
    }

    public static void main(String[] args) {
        System.out.println(reverse(-2000));
    }
}
