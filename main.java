
import java.util.Scanner;

import Bank.Database.CreatUser;

import Bank.Database.ViewDetails;
import Bank.Database.Withdraw;
import Bank.Database.AddMoney;
import Bank.Database.Assets.*;


public class main {
    public static void main(String[] args) throws InterruptedException {
   
        
        boolean flag = true;
        Colours colour = new Colours();
        CreatUser creatUser = new CreatUser();
        ViewDetails view = new ViewDetails();
        AddMoney addMoney = new AddMoney();
        Withdraw withdraw = new Withdraw();
        

        Scanner in = new Scanner(System.in);
        System.out.println(colour.GREEN+"Welcome Vj Bank"+colour.RESET);

        for (int i = 0; i < 10; i++) {
            System.out.print("**");
            Thread.sleep(100);
        }
        System.out.println();

        System.out.println(colour.YELLOW+"1 -> New create User.."+colour.RESET);
        System.out.println(colour.YELLOW+"2 -> View details user.."+colour.RESET);
        System.out.println(colour.YELLOW+"3 -> Balance Enqury..."+colour.RESET);
        System.out.println(colour.YELLOW+"4 -> Add Money"+colour.RESET);
        System.out.println(colour.YELLOW+"5 -> Withdraw Money.."+colour.RESET);
        System.out.println(colour.YELLOW+"6 -> Delete Account"+colour.RESET);
        System.out.println(colour.YELLOW+"7 -> View Statement.."+colour.RESET);

        while(flag){
            System.out.println("________________________");
            System.out.print(colour.PURPLE+"Enter the choice: "+colour.PURPLE);
            int input = in.nextInt();
            System.out.println();
            

            switch (input) {
                case 1:
                    creatUser.createUser();
                    break;

                case 2:
                    view.viewUser();
                    break;
                case 4:
                    addMoney.addMoney();
                    break;

                case 5:
                    withdraw.withdraw();
                    break;

                    default:
                     flag = false;
                     break;
            }
        }
    }
}
