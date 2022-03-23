package 设计模式.建造者模式;

public class MealBuilder {
    public static Meal getVegBurgerAndCoke(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }
    public static Meal getVegBurgerAndPesi(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Pesi());
        return meal;
    }
    public static Meal getMeatBurgerAndCoke(){
        Meal meal = new Meal();
        meal.addItem(new MeatBurger());
        meal.addItem(new Coke());
        return meal;
    }
    public static Meal getMeatBurgerAndPesi(){
        Meal meal = new Meal();
        meal.addItem(new MeatBurger());
        meal.addItem(new Pesi());
        return meal;
    }
}
