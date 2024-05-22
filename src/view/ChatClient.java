package view;
import java.io.*;
import java.net.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ChatClient extends JFrame {
    private JTextArea chatArea;
    private JTextField inputField;
    private PrintWriter out;

    public ChatClient(String serverAddress, String clientName) {
        setTitle("Chat Client - " + clientName);
        setSize(400, 300);
         setLocationRelativeTo(null); 

        chatArea = new JTextArea();
        chatArea.setEditable(false);
        add(new JScrollPane(chatArea), BorderLayout.CENTER);

        inputField = new JTextField();
        add(inputField, BorderLayout.SOUTH);

        inputField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String message = inputField.getText();
                out.println(message);
                inputField.setText("");
            }
        });

        setVisible(true);

        // Thiết lập kết nối
        new Thread(new Runnable() {
            public void run() {
                try (Socket socket = new Socket(serverAddress, 12346)) {
                    chatArea.append("Đã kết nối tới " + serverAddress + "\n");

                    BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    out = new PrintWriter(socket.getOutputStream(), true);

                    out.println(clientName);

                    String serverMessage;
                    while ((serverMessage = in.readLine()) != null) {
                        chatArea.append(serverMessage + "\n");
                    }
                } catch (IOException e) {
                }
            }
        }).start();
    }

    public static void main(String[] args) {
        String serverAddress = "192.168.127.250";
        String clientName = JOptionPane.showInputDialog("Nhập tên của bạn:");

        if (clientName != null && !clientName.trim().isEmpty()) {
            new ChatClient(serverAddress, clientName);
        } else {
            JOptionPane.showMessageDialog(null, "Tên không được để trống.");
        }
    }
}