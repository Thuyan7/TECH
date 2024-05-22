/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.io.*;
import java.net.*;
import java.util.*;
import javax.swing.*;
import java.awt.*;

public class ChatServer extends JFrame {
    private JTextArea chatArea;
    private ArrayList<PrintWriter> clientOutputs;
    private HashMap<String, PrintWriter> clientMap;

    public ChatServer() {
        setTitle("Chat Server");
        setSize(400, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        setVisible(true);

        clientOutputs = new ArrayList<>();
        clientMap = new HashMap<>();

        new Thread(new Runnable() {
            public void run() {
                try (ServerSocket serverSocket = new ServerSocket(12346)) {
                    while (true) {
                        Socket clientSocket = serverSocket.accept();
                        new ClientHandler(clientSocket).start();
                    }
                } catch (IOException e) {
                }
            }
        }).start();

       
    }

    private class ClientHandler extends Thread {
        private Socket socket;
        private PrintWriter out;
        private BufferedReader in;
        private String clientName;

        public ClientHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            try {
                in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                out = new PrintWriter(socket.getOutputStream(), true);

                synchronized (clientOutputs) {
                    clientOutputs.add(out);
                }

                clientName = in.readLine();
                synchronized (clientMap) {
                    clientMap.put(clientName, out);
                }

                chatArea.append(clientName + " đã tham gia trò chuyện.\n");
                broadcast(clientName + " đã tham gia trò chuyện.");

                String message;
                while ((message = in.readLine()) != null) {
                    chatArea.append(clientName + ": " + message + "\n");
//                    broadcast(clientName + ": " + message);
                }
            } catch (IOException e) {
            } finally {
                if (clientName != null) {
                    synchronized (clientMap) {
                        clientMap.remove(clientName);
                    }
                    chatArea.append(clientName + " đã rời khỏi trò chuyện.\n");
                    broadcast(clientName + " đã rời khỏi trò chuyện.");
                }
                if (out != null) {
                    synchronized (clientOutputs) {
                        clientOutputs.remove(out);
                    }
                }
                try {
                    socket.close();
                } catch (IOException e) {
                }
            }
        }

      private void broadcast(String message) {
        synchronized (clientOutputs) {
            for (PrintWriter writer : clientOutputs) {
                writer.println(message);
            }
        }
    }
}
     public static void main(String[] args) {
        new ChatServer();
    }
}
