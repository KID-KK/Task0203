public class Vaccine {
    private String name;//疫苗名称
    private  double price;//疫苗价格
    public Vaccine(String name) {
        this.name = name;
        switch (this.name)
        {
            case "a":price=100;break;
            case "b":price=150;break;
            case "c":price=200;break;
            default:break;
        }
    }



    public double getPrice() {
        return price;
    }

    public String getName() {
        return name;
    }

}
