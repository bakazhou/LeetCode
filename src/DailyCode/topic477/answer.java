package DailyCode.topic477;

import java.util.HashMap;
import java.util.Map;

public class answer {
    Map<String,Integer> map = new HashMap<>();
    public int hammingDistance(int x, int y) {
        String numx = Integer.toBinaryString(x);
        String numy = Integer.toBinaryString(y);
        String str1 = Integer.toString(x);
        String str2 = Integer.toString(y);
        if (map.containsKey(str1+"_"+str2)){
            return map.get(str1+"_"+str2);
        }
        if (map.containsKey(str2+"_"+str1)){
            return map.get(str2+"_"+str1);
        }
        int ans = 0,lenx=numx.length(),leny=numy.length();
        if (lenx>leny){
            int i=lenx-1,j=leny-1;
            for (;j>=0;j--,i--){
                if (numx.charAt(i)!=numy.charAt(j)) {
                    ans++;
                }
            }
            for (;i>=0;i--){
                if (numx.charAt(i)!='0'){
                    ans++;
                }
            }

        }else if (lenx<leny){
            int i=lenx-1,j=leny-1;
            for (;i>=0;i--,j--){
                if (numx.charAt(i)!=numy.charAt(j)) {
                    ans++;
                }
            }
            for (;j>=0;j--){
                if (numy.charAt(j)!='0'){
                    ans++;
                }
            }
        }else if (lenx==leny){
            for (int i=0;i<lenx;i++){
                if (numx.charAt(i)!=numy.charAt(i)) {
                    ans++;
                }
            }
        }
        map.put(str1+"_"+str2,ans);
        map.put(str2+"_"+str1,ans);
        return ans;
    }
    public int totalHammingDistance(int[] nums) {
        int n = nums.length,ans = 0;
        for (int i=0;i<n-1;i++){
            for (int j=i+1;j<n;j++){
                ans+=hammingDistance(nums[i],nums[j]);
            }
        }
        return ans;
    }
}
