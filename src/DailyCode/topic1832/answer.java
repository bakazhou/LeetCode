package DailyCode.topic1832;

public class answer {
    public boolean checkIfPangram(String sentence) {
        int[] check = new int[26];
        char[] chars = sentence.toCharArray();
        int n = chars.length;
        for (int i=0;i<n;i++){
            check[chars[i]-97]++;
        }
        for (int i=0;i<26;i++){
            if (check[i]==0) return false;
        }
        return true;
    }
}
