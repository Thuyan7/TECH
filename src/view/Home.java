/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package view;

import DataBase.LaptopManager;
import DataBase.PhoneManager;
import com.formdev.flatlaf.FlatIntelliJLaf;
import com.formdev.flatlaf.FlatLightLaf;
import com.formdev.flatlaf.intellijthemes.FlatAllIJThemes;
import com.formdev.flatlaf.intellijthemes.FlatArcDarkIJTheme;
import com.formdev.flatlaf.intellijthemes.FlatGradiantoNatureGreenIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatGitHubIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMaterialLighterIJTheme;
import com.formdev.flatlaf.intellijthemes.materialthemeuilite.FlatMoonlightIJTheme;
import com.formdev.flatlaf.themes.FlatMacLightLaf;
import com.k33ptoo.components.KButton;
import com.k33ptoo.components.KGradientPanel;
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
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

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
        
        JButton buyButton = new JButton("BUY");
        buyButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        buyButton.setBorderPainted(false);
        buyButton.setBackground(Color.LIGHT_GRAY);
        laptopPanel.add(Box.createVerticalStrut(10));
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
        buyButton.setBackground(mainColor);
        buyButton.setkAllowGradient(false);
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
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel2 = new javax.swing.JPanel();
        kGradientPanel1 = new com.k33ptoo.components.KGradientPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Menu.setBackground(new java.awt.Color(255, 255, 255));
        Menu.setkBorderRadius(20);
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

        jLabel1.setIcon(new javax.swing.ImageIcon("C:\\Users\\AN\\Downloads\\logout.png")); // NOI18N

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setIcon(new javax.swing.ImageIcon("C:\\Users\\AN\\Downloads\\close.png")); // NOI18N
        jLabel3.setToolTipText("X");
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout MenuLayout = new javax.swing.GroupLayout(Menu);
        Menu.setLayout(MenuLayout);
        MenuLayout.setHorizontalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jLabel3))
                    .addComponent(btPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addGroup(MenuLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addComponent(btDaily, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                            .addGroup(MenuLayout.createSequentialGroup()
                                .addComponent(btLaptop, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, MenuLayout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(71, 71, 71))
        );
        MenuLayout.setVerticalGroup(
            MenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MenuLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(161, 161, 161)
                .addComponent(btLaptop, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btPhone, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btDaily, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(41, 41, 41)
                .addComponent(btCustomer, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 240, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(40, 40, 40))
        );

        jPanel1.add(Menu, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 0, -1));

        jScrollPane1.setHorizontalScrollBarPolicy(javax.swing.ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        jScrollPane1.setToolTipText("");
        jScrollPane1.setAlignmentX(1.0F);
        jScrollPane1.setAlignmentY(1.0F);

        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jScrollPane1.setViewportView(jPanel2);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 60, 1050, 660));

        kGradientPanel1.setkEndColor(new java.awt.Color(51, 153, 255));
        kGradientPanel1.setkStartColor(new java.awt.Color(255, 255, 255));
        kGradientPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setIcon(new javax.swing.ImageIcon("C:\\Users\\AN\\Downloads\\list.png")); // NOI18N
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        kGradientPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 12, 90, 40));

        jPanel1.add(kGradientPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1050, 60));

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
    }// </editor-fold>//GEN-END:initComponents

    private void btCustomerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCustomerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btCustomerActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        openMenuBar();
    }//GEN-LAST:event_jLabel2MouseClicked

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        closeMenuBar();
    }//GEN-LAST:event_jLabel3MouseClicked

    private void btLaptopActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btLaptopActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btLaptopActionPerformed

    private void btLaptopMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btLaptopMouseClicked
        displayLaptop();
    }//GEN-LAST:event_btLaptopMouseClicked

    private void btPhoneMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btPhoneMouseClicked
        displayPhone();
    }//GEN-LAST:event_btPhoneMouseClicked
   

  
    
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
    private com.k33ptoo.components.KButton btCustomer;
    private com.k33ptoo.components.KButton btDaily;
    private com.k33ptoo.components.KButton btLaptop;
    private com.k33ptoo.components.KButton btPhone;
    private com.formdev.flatlaf.ui.FlatMenuUI flatMenuUI1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private com.k33ptoo.components.KGradientPanel kGradientPanel1;
    // End of variables declaration//GEN-END:variables
    
    int width = 190;
    int height = 740;
    void openMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=0;i< width;i++){
                    Menu.setSize(i,height);
                    
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();       
    }
    
    void closeMenuBar() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i=width;i>0;i--){
                    Menu.setSize(i,height);
                    
                    try {
                        Thread.sleep(2);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(Home.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
            }
        }).start();       
    }
    
    
}
