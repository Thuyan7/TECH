package Main;

import java.io.*;
import java.net.*;

public class FileReceiverServer implements Runnable{

    public static void main(String[] args) {
        int port = 12336;  
        try (ServerSocket serverSocket = new ServerSocket(port)) {
            while (true) {
                Socket clientSocket = serverSocket.accept();

                InputStream inputStream = clientSocket.getInputStream();
                
                String filePath = "purchase.xml";
                
                FileOutputStream fileOutputStream = new FileOutputStream(new File(filePath));

                byte[] buffer = new byte[4096];
                int bytesRead;
                while ((bytesRead = inputStream.read(buffer)) != -1) {
                    fileOutputStream.write(buffer, 0, bytesRead);
                }

                fileOutputStream.close();
                clientSocket.close();
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    @Override
    public void run() {
      System.out.println("DatabaseServer started.");
    }
}