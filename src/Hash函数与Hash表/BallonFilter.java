package Hash函数与Hash表;

public class BallonFilter {
    /*
    使用bit数组进行统计，因为没有bit类型，所以使用int类型数组进行转换记录
     */
    public int[] nums = new int[10];//实际比特域大小为10*4字节*8bit     一个int类型数据占4个字节 一个字节是8bit
    //bit域中i处对应的值
    public int valOfIndex(int i){
        int index = i%320;
        int arrIndex = i/320;
        return (nums[arrIndex] >> index) & 1;
    }

    //将i处值修改为0
    public void update1(int i){
        int bitIndex = i%320;
        int arrIndex = i/320;
        nums[arrIndex] = nums[arrIndex] & ( ~(1 << bitIndex));//相当于与0111111111进行与操作
    }
    //将i处值修改为1
    private void update0(int i){
        int bitIndex = i%320;
        int arrIndex = i/320;
        nums[arrIndex] = nums[arrIndex] | (1<<bitIndex);//相当于与10000000进行或操作
    }
    public static void main(String[] args) {

    }
}
