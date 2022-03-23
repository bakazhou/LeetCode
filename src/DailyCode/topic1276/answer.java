package DailyCode.topic1276;

import java.util.ArrayList;
import java.util.List;

public class answer {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {
        //巨无霸汉堡：4 片番茄和 1 片奶酪  x
        //小皇堡：2 片番茄和 1 片奶酪  y
//        4x+2y=tomatoSlices
//        2x+2y=2cheeseSlices
        List<Integer> list = new ArrayList<>();
        int x=0,y=0;
        //2x==tomatoSlices-2cheeseSlices
        if ((tomatoSlices-2*cheeseSlices)%2==0){
            x=(tomatoSlices-2*cheeseSlices)/2;
            y=cheeseSlices-x;
            if (x>=0 && y>=0){
                list.add(x);
                list.add(y);
            }
        }
        return list;
    }
}
