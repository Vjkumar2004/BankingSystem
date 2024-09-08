package Bank.Database;

import java.sql.*;

public class NewUser {

    public static void insert(String name,int age, int accountNo, int pass){
        String url = "jdbc:mysql://localhost:3306/newuserDb";
        String username = "root";
        String password = "vijay2004";

        String sql = "INSERT INTO newuserDetails (name , age , accountNo, pass, balance) VALUES (? , ? , ?, ?, ?)";

        try(Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement state = connection.prepareStatement(sql)){
                state.setString(1, name);
                state.setInt(2, age);
                state.setInt(3, accountNo);
                state.setInt(4, pass);
                state.setInt(5, 0);

                int rowsInsert = state.executeUpdate();

                if(rowsInsert > 0){
                    System.out.println("Inserted successfully");
                }
            }
        catch(SQLException e){
            e.printStackTrace();
        }
    }
}
