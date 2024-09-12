package Bank.Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Bank.Database.Assets.*;


public class ViewDetails {
    public static void viewUser() throws InterruptedException{

        Colours color = new Colours();
        NewUser newUser = new NewUser();

        Scanner in = new Scanner(System.in);

        System.out.print(color.YELLOW+"Enter your Account no :"+color.RESET);
        int accnum = in.nextInt();
        System.out.println();
        System.out.print(color.YELLOW+"Enter your Password :"+color.RESET);
        int password = in.nextInt();
        System.out.println();

        System.out.println("Please Wait");

        for (int i = 0; i < 10; i++) {
            System.out.print("**");
            Thread.sleep(100);
        }
        System.out.println();

        String url = "jdbc:mysql://localhost:3306/newuserdb"; 
        String user = "root";  
        String pass = "vijay2004";

        String quary = "Select * from newuserDetails where accountNo = ? and pass = ?";

        try {
            
            Connection conn = DriverManager.getConnection(url, user, pass);
            PreparedStatement stmt = conn.prepareStatement(quary);

            stmt.setInt(1, accnum);
            stmt.setInt(2, password);

            ResultSet rs = stmt.executeQuery();

            if(rs.next()){
                System.out.println("Name :"+rs.getString("name"));
                System.out.println("Age :"+rs.getInt("age"));
                System.out.println("Account Number :"+rs.getInt("accountNo"));
                System.out.println("Balance :"+rs.getInt("balance"));
                System.out.println("Phone Number :"+rs.getString("phoneNumber"));
                System.out.println();
                System.out.println("***************************");
            }
            else{
                System.out.println(color.RED+"Invalid accNo or password..."+color.RESET);
            }

            conn.close();
            rs.close();
            stmt.close();

        } catch (Exception e) {
            
            System.out.println(e);
        }

    }
}
