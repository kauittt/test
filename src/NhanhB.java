public class NhanhB {
    private String name;
    private String address;
    private int age;

    public static void main(String[] args) {
        System.out.println("Hello Nhánh B!");
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
