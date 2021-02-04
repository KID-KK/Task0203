public class SetMeal
{

    public double sell(Animal a, Vaccine v)
    {
        return a.getPrice()+v.getPrice();
    }
    public String toString(Animal a,Vaccine v)
    {

        return ""+"卖出动物："+a.toString()+"  注射疫苗："+v.getName();
    }
}
