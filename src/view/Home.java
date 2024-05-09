/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import java.sql.*;
import DataBase.LaptopManager;
import DataBase.PhoneManager;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;
import com.mysql.cj.xdevapi.Statement;
import com.sun.jdi.connect.spi.Connection;
import database.DatabaseConnection;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.dnd.DragSourceListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author AN
 */
public class Home extends javax.swing.JFrame {
    
    /**
     * Creates new form Kcontrols1
     */
    public Home() {
        initComponents();
    }
    
   private void displayLaptop() {
        Color mainColor = new Color(51, 153, 255);
        LaptopManager laptopManager = new LaptopManager();
        List<model.Laptop> laptops = laptopManager.getLaptop(); 

        JPanel displayPanel = new JPanel(new GridLayout(0, 3, 120, 50)); 
        displayPanel.setBackground(Color.WHITE);

        for (model.Laptop laptop : laptops) {
        KGradientPanel laptopPanel = new KGradientPanel(); 
        laptopPanel.setLayout(new BoxLayout(laptopPanel, BoxLayout.Y_AXIS)); 
        laptopPanel.setPreferredSize(new Dimension(30, 250)); 
        laptopPanel.setBackground(Color.WHITE);
        laptopPanel.setkStartColor(mainColor);
        laptopPanel.setkEndColor(Color.white);
        laptopPanel.setkBorderRadius(100);
        laptopPanel.setBackground(Color.WHITE);
        
        ImageIcon imageIcon = new ImageIcon(laptop.getImage());
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        laptopPanel.add(Box.createVerticalStrut(10));
        laptopPanel.add(imageLabel);

        // Name
        JLabel nameLabel = new JLabel(laptop.getName());
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setFont(new Font("Segoe UI",1,12));
        laptopPanel.add(Box.createVerticalStrut(10));
        laptopPanel.add(nameLabel);

        // Description
        JLabel descriptionLabel = new JLabel(laptop.getDescription());
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionLabel.setFont(new Font("Segoe UI",1,12));
        laptopPanel.add(Box.createVerticalStrut(10));
        laptopPanel.add(descriptionLabel);

        // Price
        JLabel priceLabel = new JLabel(laptop.getPrice());
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setFont(new Font("Segoe UI",1,12));
        priceLabel.setForeground(Color.red);
        laptopPanel.add(Box.createVerticalStrut(10));
        laptopPanel.add(priceLabel);
        
        KButton buyButton = new KButton();
        buyButton.setText("BUY");
        buyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Buy1 detailFrame = new Buy1(laptop.getName(), laptop.getPrice());
                    detailFrame.setVisible(true);
                }
            });
        buyButton.setBackground(mainColor);
        buyButton.setkAllowGradient(false);
        buyButton.setkBorderRadius(30);
        buyButton.setkBackGroundColor(mainColor);
        buyButton.setkSelectedColor(Color.WHITE);
        buyButton.setkHoverForeGround(Color.BLACK);
        buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
      
        laptopPanel.add(buyButton);
        
        
        displayPanel.add(laptopPanel);
    }

     JScrollPane scrollPane = new JScrollPane(displayPanel);
    
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setViewportView(scrollPane);
    }
   
   
   private void displayPhone() {
        Color mainColor = new Color(51, 153, 255);
        PhoneManager phoneManager = new PhoneManager();
        List<model.Phone> phones = phoneManager.getPhone(); 

        JPanel displayPanel = new JPanel(new GridLayout(0, 3, 120, 50)); 
        displayPanel.setBackground(Color.WHITE);

        for (model.Phone phone : phones) {
        KGradientPanel phonePanel = new KGradientPanel(); 
        phonePanel.setLayout(new BoxLayout(phonePanel, BoxLayout.Y_AXIS)); 
        phonePanel.setPreferredSize(new Dimension(30, 250)); 
        phonePanel.setBackground(Color.WHITE);
        phonePanel.setkStartColor(mainColor);
        phonePanel.setkEndColor(Color.white);
        phonePanel.setkBorderRadius(100);
        phonePanel.setBackground(Color.WHITE);
        
        ImageIcon imageIcon = new ImageIcon(phone.getImage());
        JLabel imageLabel = new JLabel(imageIcon);
        imageLabel.setAlignmentX(Component.CENTER_ALIGNMENT); 
        phonePanel.add(Box.createVerticalStrut(10));
        phonePanel.add(imageLabel);

        // Name
        JLabel nameLabel = new JLabel(phone.getName());
        nameLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        nameLabel.setFont(new Font("Segoe UI",1,12));
        phonePanel.add(Box.createVerticalStrut(10));
        phonePanel.add(nameLabel);

        // Description
        JLabel descriptionLabel = new JLabel(phone.getDescription());
        descriptionLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        descriptionLabel.setFont(new Font("Segoe UI",1,12));
        phonePanel.add(Box.createVerticalStrut(10));
        phonePanel.add(descriptionLabel);

        // Price
        JLabel priceLabel = new JLabel(phone.getPrice());
        priceLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        priceLabel.setFont(new Font("Segoe UI",1,12));
        priceLabel.setForeground(Color.red);
        phonePanel.add(Box.createVerticalStrut(10));
        phonePanel.add(priceLabel);
        
        KButton buyButton = new KButton();
        buyButton.setText("BUY");
        buyButton.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    Buy1 detailFrame = new Buy1(phone.getName(), phone.getPrice());
                    detailFrame.setVisible(true);
                }
            });
        buyButton.setBackground(mainColor);
        buyButton.setkAllowGradient(false);
        buyButton.setkBorderRadius(30);
        buyButton.setkBackGroundColor(mainColor);
        buyButton.setkSelectedColor(Color.WHITE);
        buyButton.setkHoverForeGround(Color.BLACK);
        buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        phonePanel.add(Box.createVerticalStrut(10));
        phonePanel.add(buyButton);
        
        
        displayPanel.add(phonePanel);
    }

     JScrollPane scrollPane = new JScrollPane(displayPanel);
    
    scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
    jScrollPane1.setViewportView(scrollPane);
    }
   
    private void displayTableFromDatabase() {
        String sql = "SELECT * FROM daily";
        try {
            java.sql.Connection con= DatabaseConnection.getConnection();
            java.sql.Statement stmt= con.createStatement();
            ResultSet resultSet= stmt.executeQuery(sql);
            
            // Lấy số lượng hàng và số lượng cột của kết quả truy vấn
            ResultSetMetaData metaData = resultSet.getMetaData();
            int columnCount = metaData.getColumnCount();
            
            // Tạo một DefaultTableModel để lưu trữ dữ liệu
            DefaultTableModel tableModel = new DefaultTableModel();
            
            // Thêm tên cột vào DefaultTableModel
            for (int columnIndex = 1; columnIndex <= columnCount; columnIndex++) {
                tableModel.addColumn(metaData.getColumnLabel(columnIndex));
            }
            
            // Thêm dữ liệu từ kết quả truy vấn vào DefaultTableModel
            while (resultSet.next()) {
                Object[] rowData = new Object[columnCount];
                for (int i = 0; i < columnCount; i++) {
                    rowData[i] = resultSet.getObject(i + 1);
                }
                tableModel.addRow(rowData);
            }
            
            // Tạo một JTable với DefaultTableModel
            JTable table = new JTable(tableModel);
            
            // Đặt JTable vào JScrollPane
            JScrollPane scrollPane = new JScrollPane(table);
            
            // Đặt thuộc tính cho JScrollPane
            scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
            
            // Thêm JScrollPane vào JScrollPane1
            jScrollPane1.setViewportView(scrollPane);
            
            // Tính tổng giá của các mục trong bảng
            double totalPrice = 0.0;
            for (int row = 0; row < table.getRowCount(); row++) {
                Object priceObject = table.getValueAt(row, columnCount - 1); // Giả sử cột cuối cùng là cột giá
                if (priceObject instanceof Double) {
                    totalPrice += (double) priceObject;
                } else if (priceObject instanceof String) {
                    try {
                        totalPrice += Double.parseDouble((String) priceObject);
                    } catch (NumberFormatException e) {
                        // Xử lý ngoại lệ nếu giá trị không thể chuyển đổi thành số
                        e.printStackTrace();
                    }
                }
            }
            
            // Hiển thị tổng giá ở dưới bảng
            JLabel totalLabel = new JLabel("Total Price: $" + totalPrice);
            totalLabel.setHorizontalAlignment(SwingConstants.CENTER);
            jScrollPane1.setColumnHeaderView(totalLabel);
            
            // Đóng kết nối đến cơ sở dữ liệu
            resultSet.close();
            stmt.close();
            con.close();
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
 
   

   
  

   
   
  



    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        flatMenuUI1 = new com.formdev.flatlaf.ui.FlatMenuUI();
        jPanel1 = new javax.swing.JPanel();
        Menu = new com.k33ptoo.components.KGradientPanel();
        btCustomer = new com.k33ptoo.components.KButton();
        btLaptop = new com.k33ptoo.components.KButton();
        btPhone = new com.k33ptoo.components.KButton();
        btDaily = new com.k33ptoo.components.KButton();
        logOut = new javax.swing.JLabel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        settingbt = new javax.swing.JLabel();
        setting = new com.k33ptoo.components.KGradientPanel();
        add = new javax.swing.JLabel();
        remove = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setkBorderRadius(70);
        Menu.setkEndColor(new java.awt.Color(51, 153, 255));
        Menu.setkStartColor(new java.awt.Color(51, 153, 255));
        Menu.setPreferredSize(new java.awt.Dimension(190, 740));

        btCustomer.setText("CUSTOMER INFORMATION");
        btCustomer.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btCustomer.setkAllowGradient(false);
        btCustomer.setkBackGroundColor(new java.awt.Color(51, 153, 255));
        btCustomer.setkBorderRadius(20);
        btCustomer.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btCustomer.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btCustomer.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btCustomer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCustomerActionPerformed(evt);
            }
        });

        btLaptop.setBackground(new java.awt.Color(51, 153, 255));
        btLaptop.setText("LAPTOP");
        btLaptop.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btLaptop.setkAllowGradient(false);
        btLaptop.setkBackGroundColor(new java.awt.Color(51, 153, 255));
        btLaptop.setkBorderRadius(20);
        btLaptop.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btLaptop.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btLaptop.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btLaptop.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btLaptopMouseClicked(evt);
            }
        });
        btLaptop.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btLaptopActionPerformed(evt);
            }
        });

        btPhone.setText("SMARTPHONE");
        btPhone.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btPhone.setkAllowGradient(false);
        btPhone.setkBackGroundColor(new java.awt.Color(51, 153, 255));
        btPhone.setkBorderRadius(20);
        btPhone.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btPhone.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btPhone.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btPhone.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btPhoneMouseClicked(evt);
            }
        });

        btDaily.setText("DAILY STATISTICS");
        btDaily.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        btDaily.setkAllowGradient(false);
        btDaily.setkBackGroundColor(new java.awt.Color(51, 153, 255));
        btDaily.setkBorderRadius(20);
        btDaily.setkHoverForeGround(new java.awt.Color(0, 0, 0));
        btDaily.setkHoverStartColor(new java.awt.Color(0, 0, 0));
        btDaily.setkSelectedColor(new java.awt.Color(255, 255, 255));
        btDaily.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btDailyMouseClicked(evt);
            }
        });
        btDaily.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btDailyActionPerformed(evt);
            }
        });

        logOut.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/logout.png"))); // NOI18N

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(btCustomer, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btDaily, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btLaptop, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btPhone, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                        .addComponent(logOut)
                        .addGap(82, 82, 82))))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(btLaptop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btDaily, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addComponent(btCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 200, Short.MAX_VALUE)
                .addComponent(logOut)
                .addGap(50, 50, 50))
        );

        jPanel1.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(-20, 0, 220, 720));

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 153, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        settingbt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/settings (2).png"))); // NOI18N
        settingbt.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                settingbtMouseClicked(evt);
            }
        });
        kGradientPanel1.add(settingbt, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 10, 40, 40));

        setting.setkBorderRadius(0);
        setting.setkEndColor(new java.awt.Color(51, 153, 255));
        setting.setkStartColor(new java.awt.Color(51, 153, 255));
        setting.setkTransparentControls(false);

        add.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/plus.png"))); // NOI18N

        remove.setIcon(new javax.swing.ImageIcon(getClass().getResource("/image/minus.png"))); // NOI18N

        javax.swing.GroupLayout settingLayout = new javax.swing.GroupLayout(setting);
        setting.setLayout(settingLayout);
        settingLayout.setHorizontalGroup(
            settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(remove, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(add)
                .addContainerGap())
        );
        settingLayout.setVerticalGroup(
            settingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, settingLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(add, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                .addContainerGap())
            .addComponent(remove, javax.swing.GroupLayout.DEFAULT_SIZE, 60, Short.MAX_VALUE)
        );

        kGradientPanel1.add(setting, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 0, 0, 60));

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 0, 1060, 60));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setAlignmentX(1.0F);
        jScrollPane1.setAlignmentY(1.0F);

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1078, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 752, Short.MAX_VALUE)
        );

        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 60, 1060, 660));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 722, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCustomerActionPerformed
      
    }//GEN-LAST:event_btCustomerActionPerformed

    private void btLaptopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLaptopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btLaptopActionPerformed

    private void btLaptopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLaptopMouseClicked
        displayLaptop();
    }//GEN-LAST:event_btLaptopMouseClicked

    private void btPhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPhoneMouseClicked
        displayPhone();
    }//GEN-LAST:event_btPhoneMouseClicked

    private void btDailyActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btDailyActionPerformed
       displayTableFromDatabase();
        
    }//GEN-LAST:event_btDailyActionPerformed

    private void btDailyMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btDailyMouseClicked
    }//GEN-LAST:event_btDailyMouseClicked

    private void settingbtMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_settingbtMouseClicked
       openSettingBar();
    }//GEN-LAST:event_settingbtMouseClicked
   

  
    
   public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Home.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        FlatMacLightLaf.setup();
        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Home().setVisible(true);
            }
        });
    }
    
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private com.k33ptoo.components.KGradientPanel Menu;
    private javax.swing.JLabel add;
    private com.k33ptoo.components.KButton btCustomer;
    private com.k33ptoo.components.KButton btDaily;
    private com.k33ptoo.components.KButton btLaptop;
    private com.k33ptoo.components.KButton btPhone;
    private com.formdev.flatlaf.ui.FlatMenuUI flatMenuUI1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    private javax.swing.JLabel logOut;
    private javax.swing.JLabel remove;
    private com.k33ptoo.components.KGradientPanel setting;
    private javax.swing.JLabel settingbt;
    // End of variables declaration//GEN-END:variables
int width = 100;
int height = 60;

void openSettingBar() {
    final int initialX = 970; // Vị trí ban đầu của thanh setting theo trục x

    new Thread(new Runnable() {
        @Override
        public void run() {
            for (int i = width; i >= 0; i--) { // Bắt đầu từ phải và di chuyển sang trái
                int newX = initialX - (width - i); // Tính toán vị trí mới
                setting.setBounds(newX, setting.getY(), width - i, height); // Đặt vị trí và kích thước mới của thanh setting
                try {
                    Thread.sleep(2); // Tạm ngưng để tạo hiệu ứng mượt mà
                } catch (InterruptedException ex) {
                    Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }
    }).start();       
}


}
