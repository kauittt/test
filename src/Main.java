import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        displayMenu();

        int key;
        String tmp;
        Scanner sc = new Scanner(System.in);

        while(true) {
            tmp = sc.nextLine();

            try {
                key = Integer.parseInt(tmp);

                if(key >= 1 && key <= 3) break;

                System.out.println("Giá trị nhập vào không hợp lệ");

            } catch (Exception e) {
                System.out.println("Giá trị nhập vào không hợp lệ");
            }
        }


        MealOrder mealOrder = new MealOrder();

        switch (key) {
            case 1 -> {
                System.out.println(mealOrder);
                System.out.println("Total is: " + mealOrder.getPrice());
            }
            case 2 -> {
                while (true) {
                    Selection();

                    int select;
                    try {
                        tmp = sc.nextLine();
                        select = Integer.parseInt(tmp);

                        if (select == 0) break;

                        if(!(select >=1 && select <= 5)) continue;

                        switch (select) {
                            case 1 -> {
                                mealOrder.orderBurger();
                            }
                            case 2 -> {
                                mealOrder.orderDrink();
                            }
                            case 3 -> {
                                mealOrder.orderSideItem();
                            }
                            case 4 -> {
                                mealOrder.changeSize();
                            }
                            case 5 -> {
                                mealOrder.orderTopping();
                            }
                            default -> {
                                System.out.println("Enter: 1-5");
                            }
                        }
                    }
                    catch (Exception e){
                        System.out.println("Giá trị không hợp lệ");
                    }





                }
                System.out.println(mealOrder);
                System.out.println("Total is: " + mealOrder.getPrice());
            }

            case 3 -> {
                mealOrder.orderDeluxeBurGer();
                System.out.println(mealOrder);
                System.out.println("Total is: " + mealOrder.getPrice());

            }
        }
    }

    public static void displayMenu() {
        System.out.println("""
                Enter your choice
                1. Default meal
                2. Custom meal
                3. Deluxe meal""");
    }

    public static void Selection() {
        System.out.println("""
                Select choice
                1. Order burger
                2. Order drink
                3. Order side item
                4. Up size (+5)
                5. Order topping (Tomato, Cheese, Beef)
                0. Quit the program""");
    }
}