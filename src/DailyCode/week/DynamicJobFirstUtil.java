package DailyCode.week;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * ��̬������Ȩ���ȵ����㷨������
 * @author MMMMM
 *
 */
public class DynamicJobFirstUtil {
    private  static SimpleDateFormat tm= new SimpleDateFormat("HH:mm:ss");
    //���̳�ʼ��
    @SuppressWarnings("resource")
    public static PCB init(PCB pcb) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("������������ƣ��磨����1��");
        pcb.setPcbName(scanner.nextLine());
        System.out.println("��������̵���ʱ�䣺�磨1��");
        pcb.setPcbArrivalTime(scanner.nextInt());
        System.out.println("��������̷���ʱ�䣺�磨3��");
        pcb.setPcbServiceTime(scanner.nextInt());
        System.out.println("��������̳�ʼ����Ȩ���磨1��");
        pcb.setFirstNum(scanner.nextInt());
        pcb.setPcbState('w');
        return pcb;
    }

    //���շ���ʱ��ȥ����
    public static void sortByServerTime(List<PCB> pcbs){
        //ʹ��Collections�������е��Զ����������򷽷�
        Collections.sort(pcbs , new Comparator<PCB>() {
            @Override
            public int compare(PCB pcb1, PCB pcb2) {
                return (int) (pcb1.getPcbServiceTime() - pcb2.getPcbServiceTime());
            }
        });
    }
    //���յ���ʱ��ȥ����
    public static void sortByArrivalTime(List<PCB> pcbs){
        //ʹ��Collections�������е��Զ����������򷽷�
        Collections.sort(pcbs , new Comparator<PCB>() {
            @Override
            public int compare(PCB pcb1, PCB pcb2) {
                return (int) (pcb1.getPcbArrivalTime() - pcb2.getPcbArrivalTime());
            }
        });
    }
    //�Ȱ������ȶ��������ȶ���ͬ�İ��յ���ʱ��ȥ����
    public static void sortByStateAndArrivalTime(List<PCB> pcbs){
        //ʹ��Collections�������е��Զ����������򷽷�
        Collections.sort(pcbs , new Comparator<PCB>() {
            @Override
            public int compare(PCB pcb1, PCB pcb2) {
                int cr = 0;
                //�Ȱ����ȼ��Ž���
                int a = pcb1.getFirstNum() - pcb2.getFirstNum();
                if (a != 0) {
                    cr = (a < 0) ? 3 : -1;
                } else {
                    //�ٰ�����ʱ��������
                    a =  pcb1.getPcbArrivalTime() - pcb2.getPcbArrivalTime();
                    if (a != 0) {
                        cr = (a > 0) ? 2 : -2;
                    }
                }
                return cr;
            }
        });
    }

    //�����㷨���������ս���Ҫ��˳��ִ�еĽ��̷���execpcbs��
    //pcbs��������У�
    //execpcbs��ִ�ж���
    public static List<PCB> dispatchpcb(List<PCB> pcbs,List<PCB> execpcbs){
        //�м���У��ݴ�������������ѡ���Ľ���
        List<PCB> temppcbs = new ArrayList<>();
        //cpu�޹���ʱ����һ������Ľ����ȷ��񣬽���ʱ��ǰ����Ľ�����ִ��
        DynamicJobFirstUtil.sortByArrivalTime(pcbs);
        execpcbs.add(pcbs.get(0));
        pcbs.remove(pcbs.get(0));
        //����������еĽ���һ��һ�����ƶ���ִ�ж�����
        while (pcbs.size()>0) {
            //execpcbs���е����һ��exexpcb�Ľ���ʱ��
            PCB exexpcb = execpcbs.get((execpcbs.size() - 1));
            int endTime = exexpcb.getPcbArrivalTime() + exexpcb.getPcbServiceTime();
            //ʹ�õ�����������������е�ɾ�����������
            Iterator<PCB> iterator = pcbs.iterator();
            //�����ж�
            while (iterator.hasNext()){
                PCB pcb = iterator.next();
                //��ִ�ж����еĽ���ʱ�����������еĵ���ʱ������н����ƶ���ִ�ж���
                if (endTime >= pcb.getPcbArrivalTime()) {
                    temppcbs.add(pcb);
                    iterator.remove();
                }
            }
            //��������ִ�ж��н���ʱ�仹û�н��̵�����յ���ʱ������õ���һ��
            if (temppcbs==null){
                DynamicJobFirstUtil.sortByArrivalTime(pcbs);
                execpcbs.add(pcbs.get(0));
                pcbs.remove(pcbs.get(0));
            }
            //���շ���ʱ�䳤�̽������򣬱��������ƶ���ִ�ж��еĽ��̵�˳�򲻳���
            DynamicJobFirstUtil.sortByStateAndArrivalTime(temppcbs);
            execpcbs.addAll(temppcbs);
            temppcbs.clear();
        }
        for (PCB pcb : execpcbs){
            pcb.setPcbState('r');
        }
        return execpcbs;
    }

    //�����תʱ��,ƽ����תʱ���������Ϣ
    public static void turnRoundTime(List<PCB> pcbs){
        //��һ���ĵ���ʱ��
        int temp = pcbs.get(0).getPcbArrivalTime();
        for (PCB pcb : pcbs){
            //���ǰһ�����̵Ľ���ʱ��С�ڵ�ǰ���̵ĵ���ʱ��
            if (temp < pcb.getPcbArrivalTime()){
                temp = pcb.getPcbArrivalTime();
            }
            //���ý��̵Ŀ�ʼʱ��.ǰһ���Ľ���ʱ����ڱ��εĿ�ʼʱ��
            pcb.setPcbStartTime(temp);
            //�õ�ÿ�����̵ķ���ʱ��
            int serviceTime = pcb.getPcbServiceTime();
            temp+=serviceTime;
            //����ʱ��=��ʼʱ��+����ʱ��
            pcb.setPcbOverTime(temp);
            //��תʱ��=����ʱ��-����ʱ��
            int turnRound = temp-pcb.getPcbArrivalTime();
            pcb.setPcbRoundTime(turnRound);
            //��Ȩ��תʱ��=��תʱ��/����ʱ��
            pcb.setPcbAvgRoundTime((1.0*turnRound)/serviceTime);
        }
    }

    //�����������ʱ��
    public static void showTime(List<PCB> pcbs){
        System.out.println("��������\t\t����ʱ��\t\t����ʱ��\t\t��ʼʱ��\t\t���ȼ�\t\t״̬\t\t����ʱ��\t\t��תʱ��\t\t��Ȩ��תʱ��");
        double turnRound = 0.0;
        double avgTurnRound = 0.0;
        for (PCB pcb : pcbs){
            System.out.println(pcb.getPcbName()+"\t\t\t"+pcb.getPcbArrivalTime()+"\t\t\t"+pcb.getPcbServiceTime()
                    +"\t\t\t"+pcb.getPcbStartTime()+"\t\t\t"+pcb.getFirstNum()+"\t\t\t"+pcb.getPcbState()+"\t\t\t"+pcb.getPcbOverTime()+"\t\t\t"+pcb.getPcbRoundTime()
                    +"\t\t\t"+pcb.getPcbAvgRoundTime());
            turnRound+=pcb.getPcbRoundTime();
            avgTurnRound+=pcb.getPcbAvgRoundTime();
        }
        System.out.println(pcbs.size()+"�����̵�ƽ����תʱ��Ϊ��"+String.format("%g %n",(1.0*turnRound)/pcbs.size()));
        System.out.println(pcbs.size()+"�����̵�ƽ����Ȩ��תʱ��Ϊ��"+String.format("%g %n",(1.0*avgTurnRound)/pcbs.size()));
    }


}