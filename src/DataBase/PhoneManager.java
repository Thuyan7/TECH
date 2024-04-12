/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import database.DatabaseConnection;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
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
    
}
