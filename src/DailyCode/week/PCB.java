package DailyCode.week;

/**
 * �����࣬��װ�������Ժͷ���
 * @author MMMMM
 *
 */
public class PCB {

    //������
    private String pcbName;
    //���̵���ʱ��
    private int pcbArrivalTime;
    //���̷���ʱ��
    private int pcbServiceTime;
    //���̳�ʼ����Ȩ��
    private int firstNum;
    //����״̬
    private char pcbState;
    //���̼������ָ��
    private PCB nextPCB;

    //���̿�ʼʱ��
    private int pcbStartTime;
    //�������ʱ��
    private int pcbOverTime;
    //������תʱ��
    private int pcbRoundTime;
    //���̴�Ȩ��תʱ��
    private double pcbAvgRoundTime;

    //get��set����

    public String getPcbName() {
        return pcbName;
    }

    public void setPcbName(String pcbName) {
        this.pcbName = pcbName;
    }

    public int getPcbArrivalTime() {
        return pcbArrivalTime;
    }

    public void setPcbArrivalTime(int pcbArrivalTime) {
        this.pcbArrivalTime = pcbArrivalTime;
    }

    public int getPcbServiceTime() {
        return pcbServiceTime;
    }

    public void setPcbServiceTime(int pcbServiceTime) {
        this.pcbServiceTime = pcbServiceTime;
    }

    public int getFirstNum() {
        return firstNum;
    }

    public void setFirstNum(int firstNum) {
        this.firstNum = firstNum;
    }

    public char getPcbState() {
        return pcbState;
    }

    public void setPcbState(char pcbState) {
        this.pcbState = pcbState;
    }

    public PCB getNextPCB() {
        return nextPCB;
    }

    public void setNextPCB(PCB nextPCB) {
        this.nextPCB = nextPCB;
    }

    public int getPcbStartTime() {
        return pcbStartTime;
    }

    public void setPcbStartTime(int pcbStartTime) {
        this.pcbStartTime = pcbStartTime;
    }

    public int getPcbOverTime() {
        return pcbOverTime;
    }

    public void setPcbOverTime(int pcbOverTime) {
        this.pcbOverTime = pcbOverTime;
    }

    public int getPcbRoundTime() {
        return pcbRoundTime;
    }

    public void setPcbRoundTime(int pcbRoundTime) {
        this.pcbRoundTime = pcbRoundTime;
    }

    public double getPcbAvgRoundTime() {
        return pcbAvgRoundTime;
    }

    public void setPcbAvgRoundTime(double pcbAvgRoundTime) {
        this.pcbAvgRoundTime = pcbAvgRoundTime;
    }

    @Override
    public String toString() {
        return "PCB{" +
                "pcbName='" + pcbName + '\'' +
                ", pcbArrivalTime=" + pcbArrivalTime +
                ", pcbServiceTime=" + pcbServiceTime +
                ", firstNum=" + firstNum +
                ", pcbState=" + pcbState +
                ", nextPCB=" + nextPCB +
                ", pcbStartTime=" + pcbStartTime +
                ", pcbOverTime=" + pcbOverTime +
                ", pcbRoundTime=" + pcbRoundTime +
                ", pcbAvgRoundTime=" + pcbAvgRoundTime +
                '}';
    }
}