public abstract class Animal {
    protected String number;//编号
    protected String status;//状态，三种：待售，卖出，寄养
    protected int age;//年龄
    protected double weight;//体重
    protected double cost;//进货价格
    protected double price;//卖出价格
    //以下这个构造方法适用于进货时添加宠物，对所有参数进行初始化

    public Animal(String number, String status, int age, double weight, double cost, double price) {
        this.number = number;
        this.status = status;
        this.age = age;
        this.weight = weight;
        this.cost = cost;
        this.price = price;
    }

    //以下这个方法适用于寄养时添加宠物，没有对参数cost和price进行初始化

    public Animal(String number, String status, int age, double weight) {
        this.number = number;
        this.status = status;
        this.age = age;
        this.weight = weight;
    }

    public abstract String toString();

    public double getCost() {
        return cost;
    }

    public double getPrice() {
        return price;
    }

    public String getNumber() {
        return number;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
