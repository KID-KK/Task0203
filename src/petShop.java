import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.logging.Logger;


public class petShop
{
    private double monney;

    private List<Animal>animalList=new ArrayList<>();

    public petShop(double monney) {
        this.monney = monney;
    }

    public void getanimal() //实现批量进货
    {
        System.out.println("请输入进货宠物数量：");
        Scanner in=new Scanner(System.in);
        int sum=in.nextInt();//批量进货数量
        String ch0=in.nextLine();//吞掉回车符
        int i;
        for( i=1;i<=sum;i++)
        {
            System.out.println("请输入进货宠物信息：");
            String type=in.next();
            String number=in.next();
            int age=in.nextInt();
            double weight=in.nextDouble();
            double cost=in.nextDouble(),price= in.nextDouble();
            String ch1=in.nextLine();//吞掉回车符
            String status="待售";
            try {
                if(monney<cost)//抛出异常，没钱购入新的宠物
                    throw new NoMonneyException();
                else
                {
                    monney-=cost;
                    System.out.println("交易成功！");
                    if(type.equals("Bird"))
                    {
                        Bird bird=new Bird(number,status,age,weight,cost, price, type);
                        animalList.add(bird);
                        System.out.println(bird.toString());
                    }
                    else if(type.equals("Cat"))
                    {
                        Cat cat=new Cat(number,status,age,weight,cost, price, type);
                        animalList.add(cat);
                        System.out.println(cat.toString());
                    }
                    else if(type.equals("Dog"))
                    {
                        Dog dog=new Dog(number,status,age,weight,cost, price, type);
                        animalList.add(dog);
                        System.out.println(dog.toString());
                    }
                }
            }catch (NoMonneyException e)
            {
                e.printStackTrace();
                Logger log=Logger.getGlobal();
                log.warning("钱不够了，交易失败！");
                break;

            }finally {
                LocalDateTime localTime=LocalDateTime.now();
                System.out.println("店铺剩余资金："+monney);
                System.out.println(localTime);
            }

        }
        System.out.println("完成进货，购进"+(i-1)+"只宠物，店内剩余资金："+monney);
    }

    public void sellsetmeal()//实现出售套餐
    {
        Scanner in=new Scanner(System.in);
        System.out.println("请输入想要购买的宠物编号：");
        String buy0=in.nextLine();//输入看中的动物编号
        Optional<Animal> animalOptional = animalList.stream().filter(item -> item.getNumber().equals(buy0)).findFirst();
        try
        {
            if(animalOptional.isPresent())
            {
                System.out.println("请输入疫苗名称：");
                String buy1=in.nextLine();//输入疫苗名称
                SetMeal setsell=new SetMeal();
                Vaccine vaccine=new Vaccine(buy1);
                Animal a=animalOptional.get();
                monney+=setsell.sell(a,vaccine);
                a.setStatus("卖出");
                System.out.println("交易成功！");
                System.out.println("卖出宠物的基本信息：");
                System.out.println(a.toString()+"  注射疫苗："+vaccine.getName());
            }
            else
            {
                throw new NullException();
            }
        }catch (NullException e)
        {
            e.printStackTrace();
            Logger log=Logger.getGlobal();
            log.warning("交易失败！输入的编号不存在！");
        }
        finally {
            LocalDateTime localTime=LocalDateTime.now();
            System.out.println("店铺剩余资金："+monney);
            System.out.println(localTime);
        }
    }
    public void carepet()//实现寄养
    {
        Scanner in=new Scanner(System.in);
        System.out.println("请输入寄养天数：");
        //输入寄养天数，统一寄养一天，鸟类10元，猫类20元，狗类30元
        int days=in.nextInt();
        String ch1=in.nextLine();//吞掉回车符
        System.out.println("请输入宠物基本信息：");
        String type=in.next();
        String number=in.next();
        int age=in.nextInt();
        double weight=in.nextDouble();
        String status="寄养";
        if(type.equals("Bird"))
        {
            Bird bird=new Bird(number,status,age,weight, type);
            animalList.add(bird);
            monney+=10*days;
            System.out.println(bird.toString());
        }
        else if(type.equals("Cat"))
        {
            Cat cat=new Cat(number,status,age,weight,type);
            animalList.add(cat);
            monney+=20*days;
            System.out.println(cat.toString());
        }
        else if(type.equals("Dog"))
        {
            Dog dog=new Dog(number,status,age,weight, type);
            animalList.add(dog);
            monney+=30*days;
            System.out.println(dog.toString());
        }
        System.out.println("交易成功！");
        LocalDateTime localTime=LocalDateTime.now();
        System.out.println("店铺剩余资金："+monney);
        System.out.println(localTime);
    }
    public void inject()
    {
        System.out.println("请输入需要注射的疫苗名称");
        Scanner in=new Scanner(System.in);
        String name=in.nextLine();
        Vaccine vaccine=new Vaccine(name);
        monney+=vaccine.getPrice();
        System.out.println("交易成功！");
        LocalDateTime localTime=LocalDateTime.now();
        System.out.println("店铺剩余资金："+monney);
        System.out.println(localTime);
    }
}
