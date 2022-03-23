package 设计模式.建造者模式;

public class Main {
    public static void main(String[] args) {
        Meal meatBurgerAndCoke = MealBuilder.getMeatBurgerAndCoke();
        System.out.println(meatBurgerAndCoke.cost());
        Meal meatBurgerAndPesi = MealBuilder.getMeatBurgerAndPesi();
        System.out.println(meatBurgerAndPesi.cost());
        Meal vegBurgerAndCoke = MealBuilder.getVegBurgerAndCoke();
        System.out.println(vegBurgerAndCoke.cost());
        Meal vegBurgerAndPesi = MealBuilder.getVegBurgerAndPesi();
        System.out.println(vegBurgerAndPesi.cost());

    }
}
