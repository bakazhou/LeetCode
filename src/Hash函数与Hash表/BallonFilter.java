package Hash������Hash��;

public class BallonFilter {
    /*
    ʹ��bit�������ͳ�ƣ���Ϊû��bit���ͣ�����ʹ��int�����������ת����¼
     */
    public int[] nums = new int[10];//ʵ�ʱ������СΪ10*4�ֽ�*8bit     һ��int��������ռ4���ֽ� һ���ֽ���8bit
    //bit����i����Ӧ��ֵ
    public int valOfIndex(int i){
        int index = i%320;
        int arrIndex = i/320;
        return (nums[arrIndex] >> index) & 1;
    }

    //��i��ֵ�޸�Ϊ0
    public void update1(int i){
        int bitIndex = i%320;
        int arrIndex = i/320;
        nums[arrIndex] = nums[arrIndex] & ( ~(1 << bitIndex));//�൱����0111111111���������
    }
    //��i��ֵ�޸�Ϊ1
    private void update0(int i){
        int bitIndex = i%320;
        int arrIndex = i/320;
        nums[arrIndex] = nums[arrIndex] | (1<<bitIndex);//�൱����10000000���л����
    }
    public static void main(String[] args) {

    }
}
