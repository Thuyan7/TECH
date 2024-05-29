package Main;


import Main.ServerThread;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import model.Laptop;
import database.DatabaseConnection;
import model.Phone;

public class DatabaseServer implements Runnable{

    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1232)) {

            while (true) {
                Socket socket = serverSocket.accept();

                new ServerThread(socket).start();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
    }
}

class ServerThread extends Thread {

    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (ObjectOutputStream output = new ObjectOutputStream(socket.getOutputStream()); ObjectInputStream input = new ObjectInputStream(socket.getInputStream())) {

String request = (String) input.readObject();

            switch (request) {
                case "GET_LAPTOPS":
                    List<Laptop> laptopList = getLaptopList();
                    output.writeObject(laptopList);
                    output.flush();
                    break;

                case "ADD_LAPTOP":
                    String[] laptopData = (String[]) input.readObject();
                    boolean addSuccess = addLaptop(laptopData[0], laptopData[1], laptopData[2], laptopData[3]);
                    output.writeBoolean(addSuccess);
                    output.flush();
                    break;

                case "DELETE_LAPTOP":
                    int deleteId = (Integer) input.readObject();
                    boolean deleteSuccess = deleteLaptop(deleteId);
                    output.writeBoolean(deleteSuccess);
                    output.flush();
                    break;

                case "UPDATE_LAPTOP":
                    Laptop laptopToUpdate = (Laptop) input.readObject();
                    boolean updateSuccess = updateLaptop(laptopToUpdate);
                    output.writeBoolean(updateSuccess);
                    output.flush();
                    break;

                case "GET_LAPTOP_BY_ID":
                    int getId = (Integer) input.readObject();
                    Laptop laptop = getLaptopById(getId);
                    output.writeObject(laptop);
                    output.flush();
                    break;
                case "GET_PHONES":
                    List<Phone> phoneList = getPhoneList();
                    output.writeObject(phoneList);
                    output.flush();
                    break;

                case "ADD_PHONE":
                    String[] phoneData = (String[]) input.readObject();
                    boolean addSuccess2 = addPhone(phoneData[0], phoneData[1], phoneData[2], phoneData[3]);
                    output.writeBoolean(addSuccess2);
                    output.flush();
                    break;

                case "DELETE_PHONE":
                    int deleteId2 = (Integer) input.readObject();
                    boolean deleteSuccess2 = deletePhone(deleteId2);
                    output.writeBoolean(deleteSuccess2);
                    output.flush();
                    break;

                case "UPDATE_PHONE":
                    Phone phoneToUpdate = (Phone) input.readObject();
                    boolean updateSuccess2 = updatePhone(phoneToUpdate);
                    output.writeBoolean(updateSuccess2);
                    output.flush();
                    break;

                case "GET_PHONE_BY_ID":
                    int getId2 = (Integer) input.readObject();
                    Phone phone = getPhoneById(getId2);
                    output.writeObject(phone);
                    output.flush();
                    break;
                default:
                    break;
            }

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private List<Laptop> getLaptopList() {
        List<Laptop> laptopList = new ArrayList<>();
        String sql = "SELECT * FROM laptop";
        try {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String price = rs.getString("price");
                String image = rs.getString("image");
                String description = rs.getString("description");

                Laptop laptop = new Laptop(id, name, price, image, description);
                laptopList.add(laptop);
            }

            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptopList;
    }

    private boolean addLaptop(String name, String price, String des, String img) {
        String sql = "INSERT INTO laptop (name, price, description, image) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, price);
            statement.setString(3, des);
            statement.setString(4, img);

            int rowsInserted = statement.executeUpdate();
            DatabaseConnection.closeConnection(conn);
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private boolean deleteLaptop(int id) {
        String sql = "DELETE FROM laptop WHERE id=?";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsDeleted = ps.executeUpdate();
            DatabaseConnection.closeConnection(con);
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean updateLaptop(Laptop l) {
        String sql = "UPDATE laptop SET name=?, price=?, image=?, description=? WHERE id=?";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, l.getName());
            ps.setString(2, l.getPrice());
            ps.setString(3, l.getImage());
            ps.setString(4, l.getDescription());
            ps.setInt(5, l.getId());
            int rowsUpdated = ps.executeUpdate();
            DatabaseConnection.closeConnection(con);
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Laptop getLaptopById(int id) {
        Laptop laptop = null;
        String sql = "SELECT * FROM laptop WHERE id = ?";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String price = rs.getString("price");
                String image = rs.getString("image");
                String description = rs.getString("description");

                laptop = new Laptop(id, name, price, image, description);
            }

            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return laptop;
    }

    private List<Phone> getPhoneList() {
        List<Phone> phoneList = new ArrayList<>();
        String sql = "SELECT * FROM phone";
        try {
            Connection con = DatabaseConnection.getConnection();
            Statement stmt = con.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                String price = rs.getString("price");
                String image = rs.getString("image");
                String description = rs.getString("description");

                Phone phone = new Phone(id, name, price, image, description);
                phoneList.add(phone);
            }

            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phoneList;
    }

    private boolean addPhone(String name, String price, String des, String img) {
        String sql = "INSERT INTO phone (name, price, description, image) VALUES (?, ?, ?, ?)";
        try {
            Connection conn = DatabaseConnection.getConnection();
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, name);
            statement.setString(2, price);
            statement.setString(3, des);
            statement.setString(4, img);

            int rowsInserted = statement.executeUpdate();
            DatabaseConnection.closeConnection(conn);
            return rowsInserted > 0;
        } catch (SQLException ex) {
            ex.printStackTrace();
            return false;
        }
    }

    private boolean deletePhone(int id) {
        String sql = "DELETE FROM phone WHERE id=?";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            int rowsDeleted = ps.executeUpdate();
            DatabaseConnection.closeConnection(con);
            return rowsDeleted > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private boolean updatePhone(Phone p) {
        String sql = "UPDATE phone SET name=?, price=?, image=?, description=? WHERE id=?";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, p.getName());
            ps.setString(2, p.getPrice());
            ps.setString(3, p.getImage());
            ps.setString(4, p.getDescription());
            ps.setInt(5, p.getId());
            int rowsUpdated = ps.executeUpdate();
            DatabaseConnection.closeConnection(con);
            return rowsUpdated > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private Phone getPhoneById(int id) {
        Phone phone = null;
        String sql = "SELECT * FROM phone WHERE id = ?";
        try {
            Connection con = DatabaseConnection.getConnection();
            PreparedStatement pstmt = con.prepareStatement(sql);
            pstmt.setInt(1, id);
            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                String name = rs.getString("name");
                String price = rs.getString("price");
                String image = rs.getString("image");
                String description = rs.getString("description");

                phone = new Phone(id, name, price, image, description);
            }

            DatabaseConnection.closeConnection(con);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return phone;
    }
}
