/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Phone;



/**
 *
 * @author AN
 */
public class PhoneManager {
    public static List<Phone> getPhone(){
        List<Phone> phoneList = new ArrayList<>();
        String sql = "SELECT * FROM phone";
        try {
           Connection con= DatabaseConnection.getConnection();
            Statement stmt= con.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            
            while (rs.next()) {
                String name = rs.getString("name");
                String price = rs.getString("price");
                String image = rs.getString("image");
                String description = rs.getString("description"); 

                Phone phone = new Phone(name, price, image, description);
                phoneList.add(phone);
            }

            DatabaseConnection.closeConnection(con);
        } catch (Exception e) {
        }
        return phoneList;
    }
    
       public static void addPhone(String name, String price, String des, String img) {
        try {
            Connection conn = DatabaseConnection.getConnection();
            String sql = "INSERT INTO phone (name, price, description, image) VALUES (?, ?, ?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, price);
            statement.setString(3, des);
            statement.setString(4, img);

            int rowsInserted = statement.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("A new phone was inserted successfully!");
            }
            DatabaseConnection.closeConnection(conn);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
