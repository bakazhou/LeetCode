package DailyCode.topic168;

public class answer {
    public String convertToTitle(int columnNumber) {
        StringBuilder sb = new StringBuilder();
        while (columnNumber!=0){
            int n = columnNumber % 26;
            if (n == 0) {
                n = 26;
            }else {
                n--;
            }
            sb.append ((char)(n+65));
            columnNumber = columnNumber / 26;
        }
        sb.reverse();
        return sb.toString();
    }
}
