package ����Ա���Խ��;

/**
 * @author bakazhou
 * @description
 * @date 2021��12��12�� 14:40
 **/
public class topic1601 {
    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0]+numbers[1];
        numbers[1] = numbers[0]-numbers[1];
        numbers[0] = numbers[0]-numbers[1];
        return numbers;
    }
}
