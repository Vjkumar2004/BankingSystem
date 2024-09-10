package Bank.Database;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

import Bank.Database.Assets.*;


public class Withdraw {
    
    public static void  withdraw() throws InterruptedException{

        Colours colour = new Colours();
        Scanner in = new Scanner(System.in);

        System.out.print(colour.GREEN+"Enter your account number :"+colour.RESET);
        int accNo = in.nextInt();
        System.out.println();
        System.out.print(colour.GREEN+"Enter your pin number :"+colour.RESET);
        int pin = in.nextInt();
        System.out.println();

        System.out.println("Please wait for Transaction");
        for (int i = 0; i < 10; i++) {
            System.out.print("**");
            Thread.sleep(100);
        }

        System.out.println();

        String url = "jdbc:mysql://localhost:3306/newuserdb"; 
        String user = "root";
        String password = "vijay2004";

        String quary = "select * from newuserDetails where accountNo = ? and pass = ?";
        String updateQuary = "update newuserDetails set balance = ? where accountNo = ?";

        try {
            Connection conn = DriverManager.getConnection(url, user, password);
            PreparedStatement stmt = conn.prepareStatement(quary);
            PreparedStatement updatestmt = conn.prepareStatement(updateQuary);

            stmt.setInt(1, accNo);
            stmt.setInt(2, pin);

            ResultSet rs = stmt.executeQuery();

            if (rs.next()) {
                int balanceAmt = rs.getInt("balance");
                System.out.print("Enter your amount :");
                int amt = in.nextInt();
                System.out.println();

                int totalAmt = balanceAmt-amt;

                updatestmt.setInt(1, totalAmt);
                updatestmt.setInt(2, accNo);

                int rowsUpdated = updatestmt.executeUpdate();

                if (rowsUpdated > 0) {
                    System.out.println("Withdrwing");
                    for (int i = 0; i < 10; i++) {
                        System.out.print(colour.GREEN + "**" + colour.RESET);
                        Thread.sleep(100);
                    }

                    System.out.println();
                    System.out.println("Successfully deposited. New Balance: " + totalAmt);
                } else {
                    System.out.println("Failed to update balance.");
                }


            }
            else{
                System.out.println(colour.RED+"Invalid account"+colour.RESET);
            }
            rs.close();
            conn.close();
            stmt.close();
            updatestmt.close();
            
        } catch (Exception e) {
            // TODO: handle exception
            System.out.println(e);
            
        }
    }
}
