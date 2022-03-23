package DailyCode;

import java.util.Arrays;

public class topic705 {
    public int[] nums;
    public int length;
     /** Initialize your data structure here. */
    public topic705() {
        this.length=1;
        nums = new int[length];
        Arrays.fill(nums,-241578644);
    }

    public void add(int key) {
        if (!contains(key)){
            nums[length-1]=key;
            length++;
            int[] temp = new int[length];
            Arrays.fill(temp,-241578644);
            for (int i=0;i<length-1;i++){
                temp[i]=nums[i];
            }
            nums = new int[length];
            nums=temp;
        }
    }

    public void remove(int key) {
        if (contains(key)) {
            int index = -1;
            int[] temp = new int[length-1];
            Arrays.fill(temp,-241578644);
            for (int i = 0; i < length; i++) {
                if (nums[i] == key) {
                    index=i;
                    break;
                }else  temp[i]=nums[i];
            }
            for (int i = index+1,j=index;i<length;i++,j++){
                temp[j]=nums[i];
            }
            length--;
            nums = new int[length];
            nums=temp;
        }
    }

    /** Returns true if this set contains the specified element */
    public boolean contains(int key) {
        for (int i=0;i<length;i++){
            if (nums[i]==key) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        topic705 t = new topic705();
        t.add(1);
        t.add(2);
        t.remove(2);
        System.out.println(Arrays.toString(t.nums));
        System.out.println(t.contains(0));
    }
}
