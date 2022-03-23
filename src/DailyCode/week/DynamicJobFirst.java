package DailyCode.week;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * ����ҵ���ȵ����㷨ʵ����
 * @author MMMMM
 *
 */
public class DynamicJobFirst {

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������Ȩ�����㷨��ʼ��");
        System.out.println("����������ҵ�������Ϣ��������no���������");
        //������ҵ����
        List<PCB> PCBs = new ArrayList<>();
        //ִ����ҵ����
        List<PCB> execPCBs = new ArrayList<>();
        //��ҵ��Ϣ��ʼ��
        do {
            PCB pcb = new PCB();
            PCB initPCB = DynamicJobFirstUtil.init(pcb);
            PCBs.add(initPCB);
            System.out.println("�Ƿ�Ҫ����������ҵ�����Ϣ����������yes��������no��");
        } while (scanner.nextLine().equalsIgnoreCase("yes"));
        System.out.println("-----------------");
        //ȷ�ϳ�ʼ���ɹ�
        for (PCB pcb : PCBs) {
            System.out.println(pcb.toString());
        }


        //ִ�е����㷨�������������ҵ�����㷨�����뵽ִ�ж�����
        execPCBs = DynamicJobFirstUtil.dispatchpcb(PCBs, execPCBs);
        System.out.println("-----------------");

        //�����תʱ���ƽ����תʱ�䲢��¼��ÿһ����ҵʵ����
        DynamicJobFirstUtil.turnRoundTime(execPCBs);
        for (PCB PCB : execPCBs) {
            System.out.println(PCB.toString());
        }

        System.out.println("-----------------");
        DynamicJobFirstUtil.showTime(execPCBs);
    }
}