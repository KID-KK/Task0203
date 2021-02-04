public class Bird extends Animal {

    public Bird(String number, String status, int age, double weight, double cost, double price, String type) {
        super(number, status, age, weight, cost, price);
    }

    public Bird(String number, String status, int age, double weight, String type) {
        super(number, status, age, weight);
    }

    @Override
    public String toString() {
        return "鸟类  "+"编号："+number+" 状态："+status+" 年龄："+age+" 体重："+weight;
    }
}
