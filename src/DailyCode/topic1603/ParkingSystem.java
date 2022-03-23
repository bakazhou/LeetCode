package DailyCode.topic1603;
class ParkingSystem {
    int bigCar;
    int mediumCar;
    int smallCar;

    public ParkingSystem(int big, int medium, int small) {
        this.bigCar=big;
        this.mediumCar=medium;
        this.smallCar=small;
    }

    public boolean addCar(int carType) {
        if (carType==1){
            if (bigCar>0){
                bigCar--;
                return true;
            }
        }
        else if (carType==2){
            if (mediumCar>0){
                mediumCar--;
                return true;
            }
        }
        else if (carType==3){
            if (smallCar>0){
                smallCar--;
                return true;
            }
        }
        return false;
    }
}