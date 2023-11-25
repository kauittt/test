import java.util.Scanner;

public class MealOrder {
    private Burger burger;
    private Drink drink;
    private SideItem sideItem;

    //!!!!! Constructor
    public MealOrder() {
        this(new Burger("Regular Burger", 20), new Drink("Water", 10), new SideItem("Fries", 5));
    }

    public MealOrder(Burger burger, Drink drink, SideItem sideItem) {
        this.burger = burger;
        this.drink = drink;
        this.sideItem = sideItem;
    }

    //!!!!! Get - Set
    public double getPrice() {
        return burger.getPrice() +drink.getPrice() + sideItem.getPrice();
    }

    //!!!!! Functional
    public void orderSideItem() {
        sideItem.order();
    }
    public void orderTopping() {
        Scanner sc = new Scanner(System.in);

        System.out.println("Which type of topping?");
        String type = sc.nextLine();

        burger.setTopping(type, 7);
    }
    public void orderBurger() {
        burger.order();
    }
    public void orderDrink() {
        drink.order();
    }
    public void orderDeluxeBurGer() {
        burger.deluxeBurgerBonus();

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter type of drink");
        drink = new Drink(sc.nextLine(), 0);

        System.out.println("Enter type of sideItem");
        sideItem = new SideItem(sc.nextLine(), 0);
    }
    public void changeSize() {
        drink.upSize();
    }

    //!!!!! Override
    @Override
    public String toString() {
        return "Meal order" +
                "\n* " + burger +
                "\n* " + drink +
                "\n* " + sideItem;
    }
}
