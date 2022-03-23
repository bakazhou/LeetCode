package DailyCode.topic125;

public class answer {
    public static boolean isLetter(char a){
        if (a>='0' && a<='9'){
            return true;
        }
        if (a>='a' && a<='z'){
            return true;
        }
        if (a>='A' && a<='Z'){
            return true;
        }
        return false;
    }
    public boolean isPalindrome(String s) {
        int left=0,right=s.length()-1;
        while(left<right){
            while(!isLetter(s.charAt(left)) && left<right){
                left++;
            }
            while(!isLetter(s.charAt(right)) && right>0){
                right--;
            }
            if(left>=right || right<=0){
                return true;
            }
            char a=Character.toLowerCase(s.charAt(left)),b=Character.toLowerCase(s.charAt(right));
            if (a==b){
                left++;
                right--;
            }else {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(-2*(-2));
    }
}
