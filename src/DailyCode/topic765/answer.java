package DailyCode.topic765;

public class answer {
    public int indexOfNum(int[] row,int n,int goal){
        for (int i = n;i<row.length;i++){
            if (row[i]==goal){
                return i;
            }
        }
        return -1;
    }
    public int minSwapsCouples(int[] row) {
        int ans = 0;
        for (int i = 0;i <= row.length; i=i+2){
            int location = 0;
            if (row[i]%2==0) location = indexOfNum(row,i,row[i]+1);//偶数
            else location = indexOfNum(row,i,row[i]-1);//奇数
            if (location!=i+1){
                ans++;
                int temp = row[i+1];
                row[i+1]=row[location];
                row[location]=temp;
            }
        }
        return ans;
    }
}
