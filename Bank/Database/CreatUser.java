package Bank.Database;

import java.util.Random;
import java.util.Scanner;

import Bank.Database.Assets.*; 

public class CreatUser {
    public static void createUser(){
        Scanner in = new Scanner(System.in);
        Colours colour = new Colours();
        NewUser newUser = new NewUser();

        System.out.print(colour.GREEN+"Enter the name :"+colour.RESET);
        String name = in.nextLine();
        System.out.println();
        System.out.print(colour.GREEN+"Enter the age :"+colour.RESET);
        int age = in.nextInt();
        System.out.println();

        Random random = new Random();

        final int accountNo = random.nextInt(999999999);

                    System.out.print(colour.GREEN+"Enter the phonenumber :"+colour.RESET);
                    String phone = in.next();
                    System.out.println();

                    System.out.print(colour.GREEN+"Generate the password :"+colour.RESET);
                    final int createpass = in.nextInt(); 
                    System.out.println();

                    System.out.print(colour.GREEN+"Confirm password :"+colour.RESET);
                    final int confirmpass = in.nextInt();

                    if(createpass == confirmpass){
                        newUser.insert(name, age, accountNo,createpass,phone);
                        System.out.println(colour.GREEN+"Create successfully ....");
                        System.out.println(colour.BLUE+"Your account number :"+accountNo+colour.RESET);
                    }
                    else{
                        System.err.println("Not Match Password...");
                    }

    }
}
