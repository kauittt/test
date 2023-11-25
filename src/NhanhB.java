import java.util.List;

public class NhanhB {

    private String name;
    private String address;
    private int age;

    private List<String> names;

    public static void main(String[] args) {
        // không có hello nữa
    }


    public NhanhB(String name, String address, int age) {
        this.name = name;
        this.address = address;
        this.age = age;
    }

    @Override
    public String toString() {
        return "NhanhB{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", age=" + age +
                '}';
    }
}
