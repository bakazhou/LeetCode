package 设计模式.建造者模式;

import java.util.ArrayList;
import java.util.List;

public class Meal {
    private List<Item> items = new ArrayList<>();
    public void addItem(Item item){
        items.add(item);
    }
    public float cost(){
        float price = 0;
        for (Item item : items){
            price += item.price();
        }
        return price;
    }

    @Override
    public String toString() {
        return "Meal{" +
                "items=" + items +
                '}';
    }
}
