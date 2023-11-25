import java.util.Scanner;

public class Item {
    private String type;
    private double price;

    //!!!!! Constructor
    public Item(String type, double price) {
        this.type = type;
        this.price = price;
    }


    //!!!! Get - Set
    public String getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setPrice(double price) {
        this.price = price;
    }


    //!!!!! Functional
    public void order() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter type of " + this.getClass().getSimpleName());
        this.setType(sc.nextLine());
    }

    @Override
    public String toString() {
        return "Type='" + type + '\'' +
                ", Price=" + price +
                '}';
    }
}

class Topping extends Item {
    public Topping(String type, double price) {
        super(type, price);
    }

}

class Burger extends Item {
    private int maxTopping;
    private int countTopping;
    private Topping[] topping;

    //!!!!! Constructor
    public Burger(String type, double price, int maxTopping, Topping[] topping) {
        super(type, price);
        this.maxTopping = maxTopping;
        this.topping = topping;
        countTopping = 0;
    }

    public Burger(String type, double price) {
        this(type, price, 3, new Topping[3]);
    }

    //!!!!! Get - Set
    @Override
    public double getPrice() {
        double total = super.getPrice();

        for (int i = 0; i < countTopping; i++) {
            total += topping[i].getPrice();
        }

        return total;
    }

    public void setTopping(String type, double price) {
        if (countTopping == maxTopping) {
            System.out.println("The burger is full of topping");
            return;
        }

        this.topping[countTopping] = new Topping(type, price);
        countTopping++;
    }

    public void setTopping(Topping topping) {
        if (countTopping == maxTopping) {
            System.out.println("The burger is full of topping");
            return;
        }

        this.topping[countTopping] = topping;
        countTopping++;
    }

    private void setMaxTopping(int maxTopping) {
        this.maxTopping = maxTopping;
    }

    //!!!!! Functional
    public void deluxeBurgerBonus() {
        Scanner sc = new Scanner(System.in);
        this.setPrice(69.99);

        this.setType("Deluxe burger");

        for (int i = 0; i < maxTopping; i++) {
            System.out.println("Enter type of toping " + (i + 1));
            topping[i] = new Topping(sc.nextLine(), 0);
            countTopping++;
        }
    }

    @Override
    public String toString() {
        StringBuilder template = new StringBuilder();
        for (int i = 0; i < countTopping; i++) {
            if (topping[i] == null) continue;

            template.append(topping[i].toString()).append("|");
        }
        template.replace(template.length() -1, template.length(), "") ;
        return super.toString() + " " + template;
    }
}

class Drink extends Item {
    public Drink(String type, double price) {
        super(type, price);
    }

    public void upSize() {
        this.setPrice(this.getPrice() + 3);
    }
}

class SideItem extends Item {
    public SideItem(String type, double price) {
        super(type, price);
    }
}