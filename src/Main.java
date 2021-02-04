import java.util.Scanner;
/*
前提：保证编号唯一
***测试样例***
1          //模式1：进货
8          //进货数量
Cat 001 1 1.3 150 200
Cat 002 2 1.9 130 170
Dog 003 1 2.3 200 270
Dog 004 2 2.5 250 300
Bird 005 2 1.1 70 100
Bird 006 1 1.3 90 120
Cat 007 2 1.7 180 260   //此处会抛出异常，钱不够

2         //模式2：卖出
001       //宠物编号
c        //疫苗名称

3        //模式3：寄养
10       //寄养天数
Cat 008 1 1.3

4        //模式4：打疫苗
c        //疫苗名称
 */
public class Main {
    public static void main(String []args)
    {
        petShop West2=new petShop(1000);
        Scanner in=new Scanner(System.in);
        for(;;)
        {
            System.out.println("模式选择：");
            String ch=in.nextLine();
            if(ch.equals("1"))//进货
            {
                West2.getanimal();
            }
            else if(ch.equals("2"))//卖出
            {
                West2.sellsetmeal();
            }
            else if(ch.equals("3"))//寄养
            {
                West2.carepet();
            }
            else if(ch.equals("4"))//打疫苗
            {
                West2.inject();
            }
            else
            {
                break;
            }
        }
    }
}
