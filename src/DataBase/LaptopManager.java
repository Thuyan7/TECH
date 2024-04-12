/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DataBase;

import database.DatabaseConnection;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import model.Laptop;

/**
 *
 * @author AN
 */
public class LaptopManager {
    public static List<Laptop> getLaptop(){
        List<Laptop> laptopList = new ArrayList<>();
        String sql = "SELECT * FROM laptop";
        try {
           Connection con= DatabaseConnection.getConnection();
            Statement stmt= con.createStatement();
            ResultSet rs= stmt.executeQuery(sql);
            
            while (rs.next()) {
                String name = rs.getString("name");
                String price = rs.getString("price");
                String image = rs.getString("image");
                String description = rs.getString("description"); 

                Laptop laptop = new Laptop(name, price, image, description);
                laptopList.add(laptop);
            }

            DatabaseConnection.closeConnection(con);
        } catch (Exception e) {
        }
        return laptopList;
    } 
}
