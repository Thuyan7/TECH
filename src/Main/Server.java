package Main;

import database.DatabaseConnection;
import java.io.*;
import java.net.*;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

public class Server implements Runnable{
    public static void main(String[] args) {
        try (ServerSocket serverSocket = new ServerSocket(1236)) {
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
        try (InputStream input = socket.getInputStream();
             ObjectInputStream objectInput = new ObjectInputStream(input);
             OutputStream output = socket.getOutputStream();
             ObjectOutputStream objectOutput = new ObjectOutputStream(output)) {

            // Nhận yêu cầu đăng ký từ client
            String[] userInfo = (String[]) objectInput.readObject();
            String username = userInfo[0];
            String password = userInfo[1];

            // Xử lý đăng ký
            boolean isRegistered = registerUser(username, password);
            objectOutput.writeBoolean(isRegistered);
            objectOutput.flush();

        } catch (IOException | ClassNotFoundException ex) {
            ex.printStackTrace();
        }
    }

    private boolean registerUser(String username, String password) {
        Connection connection = DatabaseConnection.getConnection();
        String hashedPassword = hashPassword(password);

        String query = "INSERT INTO accoutuser (username, password) VALUES (?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(query)) {
            statement.setString(1, username);
            statement.setString(2, hashedPassword);
            statement.executeUpdate();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(password.getBytes());
            byte[] byteData = md.digest();

            StringBuilder hexString = new StringBuilder();
            for (byte b : byteData) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }
}