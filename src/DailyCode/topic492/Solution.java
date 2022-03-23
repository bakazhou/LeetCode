package DailyCode.topic492;

class Solution {
    public int[] constructRectangle(int area) {
        int[] ans = new int[2];
        int width = (int) Math.sqrt(area);
        while (area % width != 0) {
            width--;
        }
        ans[0] = area/width;
        ans[1] = width;
        return ans;
    }
}