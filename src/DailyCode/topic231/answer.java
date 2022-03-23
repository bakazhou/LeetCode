package DailyCode.topic231;

public class answer {
    public boolean isPowerOfTwo(int n) {
        if (n==0){
            return false;
        }
        String binaryString = Integer.toBinaryString(n);
        System.out.println(binaryString);
        char[] chars = binaryString.toCharArray();
        int length = chars.length;
        for (int i=1;i<length;i++){
            if (chars[i]!='0'){
                return false;
            }
        }
        return true;
    }
}
