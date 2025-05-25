/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.ActivityLogger;
import config.Session;
import config.dbConnector;
import config.passwordHasher;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.NoSuchAlgorithmException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import sampleguigym1.loginForm;

/**
 *
 * @author Karystel
 */
public class createUserForm extends javax.swing.JFrame {

    /**
     * Creates new form createUserForm
     */
    public createUserForm() {
        initComponents();
        
    }
    public void setSelectedUserId(String userId) {
    uid.setText(userId); 
}

    public String destination =""; 
    File selectedFile;
    public String oldpath;
    public String path;
    
    public int FileExistenceChecker(String path){
        File file = new File(path);
        String fileName = file.getName();
        
        Path filePath = Paths.get("src/userimages", fileName);
        boolean fileExists = Files.exists(filePath);
        
        if (fileExists) {
            return 1;
        } else {
            return 0;
        }
    
    }
    public static int getHeightFromWidth(String imagePath, int desiredWidth) {
        try {
            // Read the image file
            File imageFile = new File(imagePath);
            BufferedImage image = ImageIO.read(imageFile);
            
            // Get the original width and height of the image
            int originalWidth = image.getWidth();
            int originalHeight = image.getHeight();
            
            // Calculate the new height based on the desired width and the aspect ratio
            int newHeight = (int) ((double) desiredWidth / originalWidth * originalHeight);
            
            return newHeight;
        } catch (IOException ex) {
            System.out.println("No image found!");
        }
        
        return -1;
    }
    
    public  ImageIcon ResizeImage(String ImagePath, byte[] pic, JLabel label) {
    ImageIcon MyImage = null;
        if(ImagePath !=null){
            MyImage = new ImageIcon(ImagePath);
        }else{
            MyImage = new ImageIcon(pic);
        }
        
    int newHeight = getHeightFromWidth(ImagePath, label.getWidth());

    Image img = MyImage.getImage();
    Image newImg = img.getScaledInstance(label.getWidth(), newHeight, Image.SCALE_SMOOTH);
    ImageIcon image = new ImageIcon(newImg);
    return image;
}
      public void imageUpdater(String existingFilePath, String newFilePath){
        File existingFile = new File(existingFilePath);
        if (existingFile.exists()) {
            String parentDirectory = existingFile.getParent();
            File newFile = new File(newFilePath);
            String newFileName = newFile.getName();
            File updatedFile = new File(parentDirectory, newFileName);
            existingFile.delete();
            try {
                Files.copy(newFile.toPath(), updatedFile.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Image updated successfully.");
            } catch (IOException e) {
                System.out.println("Error occurred while updating the image: "+e);
            }
        } else {
            try{
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }catch(IOException e){
                System.out.println("Error on update!");
            }
        }
    
      }
            
    public static String em, username;
    
    public boolean duplicateCheck(){
        dbConnector dbc = new dbConnector(); 
        try{
        String query = "SELECT * FROM tbl_user  WHERE user_username = '" +un.getText()+ "' OR user_email = '" +email.getText()+ "'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                em = resultSet.getString("user_email");
                if(em.equals(email.getText())){
                    JOptionPane.showMessageDialog(null, "Email is Already Used!");
                    email.setText("");
                }
                username = resultSet.getString("user_username");
                if(username.equals(un.getText())){
                    JOptionPane.showMessageDialog(null, "Username is Already Used!");
                    un.setText("");
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
        }
        
    }
    
    public boolean updateCheck(){
        dbConnector dbc = new dbConnector();    
        try{
        String query = "SELECT * FROM tbl_user  WHERE (user_username = '" +un.getText()+ "' OR user_email = '" +email.getText()+ "') AND user_id != '"+uid.getText()+"'";
            ResultSet resultSet = dbc.getData(query);
            
            if(resultSet.next()){
                em = resultSet.getString("user_email");
                if(em.equals(email.getText())){
                    JOptionPane.showMessageDialog(null, "Email is Already Used!");
                    email.setText("");
                }
                username = resultSet.getString("user_username");
                if(username.equals(un.getText())){
                    JOptionPane.showMessageDialog(null, "Username is Already Used!");
                    un.setText("");
                }
                return true;
            }else{
                return false;
            }
        }catch(SQLException ex){
            System.out.println(""+ex);
            return false;
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

        jPanel5 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        Container = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel12 = new javax.swing.JPanel();
        jPanel13 = new javax.swing.JPanel();
        cancel5 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        add = new javax.swing.JButton();
        us = new javax.swing.JComboBox<>();
        cn = new javax.swing.JTextField();
        un = new javax.swing.JTextField();
        ut = new javax.swing.JComboBox<>();
        email = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        uid = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pw = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        cancel = new javax.swing.JButton();
        jPanel7 = new javax.swing.JPanel();
        cancel1 = new javax.swing.JButton();
        jPanel10 = new javax.swing.JPanel();
        jPanel11 = new javax.swing.JPanel();
        cancel4 = new javax.swing.JButton();
        refresh = new javax.swing.JButton();
        jPanel14 = new javax.swing.JPanel();
        jPanel15 = new javax.swing.JPanel();
        cancel6 = new javax.swing.JButton();
        delete = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        update = new javax.swing.JButton();
        jPanel4 = new javax.swing.JPanel();
        clear = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        select = new javax.swing.JButton();
        remove1 = new javax.swing.JPanel();
        remove = new javax.swing.JButton();
        jPanel17 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        sq = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        ans = new javax.swing.JPasswordField();
        jLabel16 = new javax.swing.JLabel();

        jPanel5.setBackground(new java.awt.Color(0, 153, 153));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel5.setForeground(new java.awt.Color(0, 153, 153));
        jPanel5.setLayout(null);

        jLabel12.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel12.setText("ADD");
        jPanel5.add(jLabel12);
        jLabel12.setBounds(0, 10, 110, 20);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Container.setBackground(new java.awt.Color(0, 204, 204));
        Container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(0, 153, 153));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("CREATE USER FORM");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        Header.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 860, 30));

        Container.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 860, 70));

        jPanel12.setBackground(new java.awt.Color(0, 153, 153));
        jPanel12.setLayout(null);

        jPanel13.setBackground(new java.awt.Color(0, 153, 153));
        jPanel13.setLayout(null);

        cancel5.setBackground(new java.awt.Color(0, 102, 102));
        cancel5.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        cancel5.setText("CANCEL");
        cancel5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel5ActionPerformed(evt);
            }
        });
        jPanel13.add(cancel5);
        cancel5.setBounds(10, 10, 110, 40);

        jPanel12.add(jPanel13);
        jPanel13.setBounds(510, 300, 130, 60);

        Container.add(jPanel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel2.setLayout(null);

        jPanel8.setBackground(new java.awt.Color(0, 153, 153));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel8.setLayout(null);

        add.setBackground(new java.awt.Color(255, 255, 255));
        add.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        add.setText("ADD");
        add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                addMouseClicked(evt);
            }
        });
        add.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addActionPerformed(evt);
            }
        });
        jPanel8.add(add);
        add.setBounds(10, 10, 100, 40);

        jPanel2.add(jPanel8);
        jPanel8.setBounds(50, 20, 120, 60);

        us.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        us.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Active", "Pending" }));
        us.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        us.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usActionPerformed(evt);
            }
        });
        jPanel2.add(us);
        us.setBounds(170, 430, 240, 30);

        cn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnActionPerformed(evt);
            }
        });
        jPanel2.add(cn);
        cn.setBounds(170, 270, 240, 30);

        un.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        un.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        un.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unActionPerformed(evt);
            }
        });
        jPanel2.add(un);
        un.setBounds(170, 350, 240, 30);

        ut.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "USER" }));
        ut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });
        jPanel2.add(ut);
        ut.setBounds(170, 310, 240, 30);

        email.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        jPanel2.add(email);
        email.setBounds(170, 230, 240, 30);

        lastname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lastname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        jPanel2.add(lastname);
        lastname.setBounds(170, 190, 240, 30);

        firstname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        firstname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        jPanel2.add(firstname);
        firstname.setBounds(170, 150, 240, 30);

        uid.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        uid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        uid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        uid.setEnabled(false);
        uid.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                uidActionPerformed(evt);
            }
        });
        jPanel2.add(uid);
        uid.setBounds(170, 110, 100, 30);

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel3.setText("Password:");
        jPanel2.add(jLabel3);
        jLabel3.setBounds(50, 380, 110, 50);

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel7.setText("Username:");
        jPanel2.add(jLabel7);
        jLabel7.setBounds(50, 340, 110, 50);

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel10.setText("User Type:");
        jPanel2.add(jLabel10);
        jLabel10.setBounds(50, 300, 110, 50);

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel9.setText("Contact num:");
        jPanel2.add(jLabel9);
        jLabel9.setBounds(50, 260, 110, 50);

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel11.setText("Email:");
        jPanel2.add(jLabel11);
        jLabel11.setBounds(50, 220, 70, 50);

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel8.setText("Last Name:");
        jPanel2.add(jLabel8);
        jLabel8.setBounds(50, 180, 110, 50);

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel13.setText("First Name:");
        jPanel2.add(jLabel13);
        jLabel13.setBounds(50, 140, 120, 50);

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel6.setText("User ID:");
        jPanel2.add(jLabel6);
        jLabel6.setBounds(50, 100, 120, 50);

        pw.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwActionPerformed(evt);
            }
        });
        jPanel2.add(pw);
        pw.setBounds(170, 390, 240, 30);

        jPanel6.setBackground(new java.awt.Color(0, 153, 153));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel6.setLayout(null);

        cancel.setBackground(new java.awt.Color(255, 255, 255));
        cancel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cancel.setText("CANCEL");
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel6.add(cancel);
        cancel.setBounds(10, 10, 100, 40);

        jPanel7.setBackground(new java.awt.Color(0, 153, 153));
        jPanel7.setLayout(null);

        cancel1.setBackground(new java.awt.Color(0, 102, 102));
        cancel1.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        cancel1.setText("CANCEL");
        cancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel1ActionPerformed(evt);
            }
        });
        jPanel7.add(cancel1);
        cancel1.setBounds(10, 10, 110, 40);

        jPanel6.add(jPanel7);
        jPanel7.setBounds(510, 300, 130, 60);

        jPanel2.add(jPanel6);
        jPanel6.setBounds(570, 20, 120, 60);

        jPanel10.setBackground(new java.awt.Color(0, 153, 153));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel10.setLayout(null);

        jPanel11.setBackground(new java.awt.Color(0, 153, 153));
        jPanel11.setLayout(null);

        cancel4.setBackground(new java.awt.Color(0, 102, 102));
        cancel4.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        cancel4.setText("CANCEL");
        cancel4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel4ActionPerformed(evt);
            }
        });
        jPanel11.add(cancel4);
        cancel4.setBounds(10, 10, 110, 40);

        jPanel10.add(jPanel11);
        jPanel11.setBounds(510, 300, 130, 60);

        refresh.setBackground(new java.awt.Color(255, 255, 255));
        refresh.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        refresh.setText("REFRESH");
        refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                refreshActionPerformed(evt);
            }
        });
        jPanel10.add(refresh);
        refresh.setBounds(10, 10, 100, 40);

        jPanel2.add(jPanel10);
        jPanel10.setBounds(700, 20, 120, 60);

        jPanel14.setBackground(new java.awt.Color(0, 153, 153));
        jPanel14.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel14.setLayout(null);

        jPanel15.setBackground(new java.awt.Color(0, 153, 153));
        jPanel15.setLayout(null);

        cancel6.setBackground(new java.awt.Color(0, 102, 102));
        cancel6.setFont(new java.awt.Font("Arial", 1, 15)); // NOI18N
        cancel6.setText("CANCEL");
        cancel6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancel6ActionPerformed(evt);
            }
        });
        jPanel15.add(cancel6);
        cancel6.setBounds(10, 10, 110, 40);

        jPanel14.add(jPanel15);
        jPanel15.setBounds(510, 300, 130, 60);

        delete.setBackground(new java.awt.Color(255, 255, 255));
        delete.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        delete.setText("DELETE");
        delete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteActionPerformed(evt);
            }
        });
        jPanel14.add(delete);
        delete.setBounds(10, 10, 100, 40);

        jPanel2.add(jPanel14);
        jPanel14.setBounds(310, 20, 120, 60);

        jPanel3.setBackground(new java.awt.Color(0, 153, 153));
        jPanel3.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel3.setLayout(null);

        update.setBackground(new java.awt.Color(255, 255, 255));
        update.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        update.setText("UPDATE");
        update.setEnabled(false);
        update.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updateActionPerformed(evt);
            }
        });
        jPanel3.add(update);
        update.setBounds(10, 10, 100, 40);

        jPanel2.add(jPanel3);
        jPanel3.setBounds(180, 20, 120, 60);

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(null);

        clear.setBackground(new java.awt.Color(255, 255, 255));
        clear.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        clear.setText("CLEAR");
        clear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                clearActionPerformed(evt);
            }
        });
        jPanel4.add(clear);
        clear.setBounds(10, 10, 100, 40);

        jPanel2.add(jPanel4);
        jPanel4.setBounds(440, 20, 120, 60);

        jPanel9.setBackground(new java.awt.Color(0, 153, 153));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel9.setLayout(null);

        select.setBackground(new java.awt.Color(255, 255, 255));
        select.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        select.setText("SELECT");
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        jPanel9.add(select);
        select.setBounds(10, 10, 100, 40);

        jPanel2.add(jPanel9);
        jPanel9.setBounds(480, 480, 120, 60);

        remove1.setBackground(new java.awt.Color(0, 153, 153));
        remove1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        remove1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        remove.setBackground(new java.awt.Color(255, 255, 255));
        remove.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        remove.setText("REMOVE");
        remove.setEnabled(false);
        remove.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                removeActionPerformed(evt);
            }
        });
        remove1.add(remove, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 100, 40));

        jPanel2.add(remove1);
        remove1.setBounds(670, 480, 120, 60);

        jPanel17.setLayout(null);

        image.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        image.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/781978-200-removebg-preview.png"))); // NOI18N
        jPanel17.add(image);
        image.setBounds(10, 10, 290, 330);

        jPanel2.add(jPanel17);
        jPanel17.setBounds(480, 110, 310, 350);

        jLabel14.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel14.setText("Answer:");
        jPanel2.add(jLabel14);
        jLabel14.setBounds(50, 510, 120, 30);

        sq.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        sq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favorite food?", "What is your mother's maiden name?", "What is your favorite color?", "What is your favorite movie?", "In what city were you born?" }));
        sq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        sq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqActionPerformed(evt);
            }
        });
        jPanel2.add(sq);
        sq.setBounds(170, 470, 240, 30);

        jLabel15.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel15.setText("User Status:");
        jPanel2.add(jLabel15);
        jLabel15.setBounds(50, 430, 120, 30);

        ans.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ans.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ans.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansActionPerformed(evt);
            }
        });
        jPanel2.add(ans);
        ans.setBounds(170, 510, 240, 30);

        jLabel16.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel16.setText("Question:");
        jPanel2.add(jLabel16);
        jLabel16.setBounds(50, 470, 120, 30);

        Container.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 70, 860, 560));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, 860, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed

    }//GEN-LAST:event_emailActionPerformed

    private void usActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usActionPerformed

    private void cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnActionPerformed

    }//GEN-LAST:event_cnActionPerformed

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed

    }//GEN-LAST:event_lastnameActionPerformed

    private void unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unActionPerformed

    }//GEN-LAST:event_unActionPerformed

    private void uidActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_uidActionPerformed

    }//GEN-LAST:event_uidActionPerformed

    private void addActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addActionPerformed
if (firstname.getText().isEmpty() || lastname.getText().isEmpty() || email.getText().isEmpty()
        || cn.getText().isEmpty() || un.getText().isEmpty() || ans.getText().isEmpty()) {

    JOptionPane.showMessageDialog(null, "All fields are required!");

} else if (!email.getText().endsWith("@gmail.com")) {

    JOptionPane.showMessageDialog(null, "Invalid email format.");
    email.setText("");

} else if (!isValidContactNumber(cn.getText())) {

    JOptionPane.showMessageDialog(null, "Contact number must contain only digits and be 11 digits long.");
    cn.setText("");

} else if (pw.getText().length() < 8) {

    JOptionPane.showMessageDialog(null, "Password must be at least 8 characters.");
    pw.setText("");

} else if (duplicateCheck()) {

    JOptionPane.showMessageDialog(null, "Duplicate record exists!");

} else {
    dbConnector dbc = new dbConnector();
    String hashedPassword = "";
    String hashedAnswer = "";

    try {
        hashedPassword = passwordHasher.hashPassword(pw.getText());
        hashedAnswer = passwordHasher.hashPassword(ans.getText());
    } catch (NoSuchAlgorithmException ex) {
        JOptionPane.showMessageDialog(null, "Error hashing credentials: " + ex.getMessage());
        return;
    }

    try {
        String sql = "INSERT INTO tbl_user (user_firstname, user_lastname, user_email, user_contact, user_username, user_usertype, user_password, user_status, user_security_question, user_security_answer, user_image) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pst = dbc.connect.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

        pst.setString(1, firstname.getText());
        pst.setString(2, lastname.getText());
        pst.setString(3, email.getText());
        pst.setString(4, cn.getText());
        pst.setString(5, un.getText());
        pst.setString(6, ut.getSelectedItem().toString());
        pst.setString(7, hashedPassword);
        pst.setString(8, us.getSelectedItem().toString());
        pst.setString(9, sq.getSelectedItem().toString());
        pst.setString(10, hashedAnswer);
        pst.setString(11, destination);

        int affectedRows = pst.executeUpdate();

        if (affectedRows > 0) {
            ResultSet generatedKeys = pst.getGeneratedKeys();
            int generatedId = -1;
            if (generatedKeys.next()) {
                generatedId = generatedKeys.getInt(1);
            }

           
            if (selectedFile != null) {
                Files.copy(selectedFile.toPath(), new File(destination).toPath(), StandardCopyOption.REPLACE_EXISTING);
            }

            
            Session sess = Session.getInstance();
            int currentUserId = sess.getUserId();

            if (currentUserId > 0) {
                String logAction = "Created User Record with ID No. " + generatedId;
                String logQuery = "INSERT INTO logs (user_id, action, date) VALUES (?, ?, ?)";
                PreparedStatement logPst = dbc.connect.prepareStatement(logQuery);
                logPst.setInt(1, currentUserId);
                logPst.setString(2, logAction);
                logPst.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                logPst.executeUpdate();
                logPst.close();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid session user ID. Logging skipped.");
            }

            JOptionPane.showMessageDialog(null, "Registration Success!");

            usersForm usf = new usersForm();
            usf.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "Failed to insert user.");
        }

    } catch (SQLException | IOException ex) {
        JOptionPane.showMessageDialog(null, "Error: " + ex.getMessage());
    }
}
    }


private boolean isValidContactNumber(String contact) {
    return contact.matches("\\d{11}");

    }//GEN-LAST:event_addActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_firstnameActionPerformed

    private void deleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_deleteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_deleteActionPerformed

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        usersForm usf = new usersForm();
        usf.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelActionPerformed

    private void updateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updateActionPerformed

    if (firstname.getText().isEmpty() || lastname.getText().isEmpty() || email.getText().isEmpty()
            || cn.getText().isEmpty() || pw.getText().isEmpty() || un.getText().isEmpty()) {

        JOptionPane.showMessageDialog(null, "All fields are required!");
        return;

    } else if (!email.getText().endsWith("@gmail.com")) {
        JOptionPane.showMessageDialog(null, "Invalid email format.");
        email.setText("");
        return;

    } else if (!isValidContactNumber(cn.getText())) {
        JOptionPane.showMessageDialog(null, "Contact number must contain only digits and be 11 digits long.");
        cn.setText("");
        return;

    } else if (updateCheck()) {
        JOptionPane.showMessageDialog(null, "Duplicate record exists!");
        return;
    }

    dbConnector dbc = new dbConnector();
    String hashedPassword = "";
    String hashedAnswer = "";

    try {
        hashedPassword = passwordHasher.hashPassword(pw.getText());
        hashedAnswer = passwordHasher.hashPassword(ans.getText());
    } catch (NoSuchAlgorithmException ex) {
        JOptionPane.showMessageDialog(null, "Error hashing credentials: " + ex.getMessage());
        return;
    }

    try {
        String updateSQL = "UPDATE tbl_user SET user_firstname = ?, user_lastname = ?, user_email = ?, "
                + "user_contact = ?, user_username = ?, user_password = ?, user_usertype = ?, "
                + "user_status = ?, user_security_question = ?, user_security_answer = ?, user_image = ? "
                + "WHERE user_id = ?";

        PreparedStatement pst = dbc.connect.prepareStatement(updateSQL);
        pst.setString(1, firstname.getText());
        pst.setString(2, lastname.getText());
        pst.setString(3, email.getText());
        pst.setString(4, cn.getText());
        pst.setString(5, un.getText());
        pst.setString(6, hashedPassword);
        pst.setString(7, ut.getSelectedItem().toString());
        pst.setString(8, us.getSelectedItem().toString());
        pst.setString(9, sq.getSelectedItem().toString());
        pst.setString(10, hashedAnswer);
        pst.setString(11, destination);
        pst.setInt(12, Integer.parseInt(uid.getText()));

        int rowsAffected = pst.executeUpdate();
        pst.close();

        if (rowsAffected > 0) {
           
            if (destination.isEmpty()) {
                File existingFile = new File(oldpath);
                if (existingFile.exists()) {
                    existingFile.delete();
                }
            } else if (!oldpath.equals(path)) {
                imageUpdater(oldpath, path);
            }

           
            Session sess = Session.getInstance();
            int currentUserId = sess.getUserId();
            if (currentUserId > 0) {
                String action = "Updated user with ID No. " + uid.getText();
                String logQuery = "INSERT INTO logs (user_id, action, date) VALUES (?, ?, ?)";
                PreparedStatement logPst = dbc.connect.prepareStatement(logQuery);
                logPst.setInt(1, currentUserId);
                logPst.setString(2, action);
                logPst.setTimestamp(3, Timestamp.valueOf(LocalDateTime.now()));
                logPst.executeUpdate();
                logPst.close();
            } else {
                JOptionPane.showMessageDialog(null, "Invalid session user ID. Logging skipped.");
            }

            JOptionPane.showMessageDialog(null, "Update Success!");

            usersForm usf = new usersForm();
            usf.setVisible(true);
            this.dispose();

        } else {
            JOptionPane.showMessageDialog(null, "No user record was updated.");
        }

    } catch (SQLException ex) {
        JOptionPane.showMessageDialog(null, "Database error: " + ex.getMessage());

    }

    }//GEN-LAST:event_updateActionPerformed

    private void clearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_clearActionPerformed
        uid.setText("");
        firstname.setText("");
        lastname.setText("");
        email.setText("");
        cn.setText("");
        ut.setSelectedIndex(0);
        un.setText("");
        pw.setText("");
        us.setSelectedIndex(0);
        sq.setSelectedIndex(0);
        ans.setText("");
        
    }//GEN-LAST:event_clearActionPerformed

    private void pwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pwActionPerformed

    private void cancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel1ActionPerformed

    private void cancel4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel4ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel4ActionPerformed

    private void selectActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_selectActionPerformed
            JFileChooser fileChooser = new JFileChooser();
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {
                    try {
                        selectedFile = fileChooser.getSelectedFile();
                        destination = "src/userimages/" + selectedFile.getName();
                        path  = selectedFile.getAbsolutePath();
                        
                        
                        if(FileExistenceChecker(path) == 1){
                          JOptionPane.showMessageDialog(null, "File Already Exist, Rename or Choose another!");
                            destination = "";
                            path="";
                        }else{
                            image.setIcon(ResizeImage(path, null, image));
                            select.setEnabled(false);
                            remove.setEnabled(true);
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }

    }//GEN-LAST:event_selectActionPerformed

    private void cancel5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel5ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel5ActionPerformed

    private void cancel6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancel6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cancel6ActionPerformed

    private void refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_refreshActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_refreshActionPerformed

    private void removeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_removeActionPerformed
       remove.setEnabled(false);
       select.setEnabled(true);
       image.setIcon(null);
       destination="";
       path="";
    }//GEN-LAST:event_removeActionPerformed

    private void sqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sqActionPerformed

    private void ansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ansActionPerformed

    private void addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_addMouseClicked
        
    }//GEN-LAST:event_addMouseClicked

    /**
     * @param args the command line arguments
     */
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
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(createUserForm.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new createUserForm().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Header;
    public javax.swing.JButton add;
    public javax.swing.JPasswordField ans;
    public javax.swing.JButton cancel;
    private javax.swing.JButton cancel1;
    private javax.swing.JButton cancel4;
    private javax.swing.JButton cancel5;
    private javax.swing.JButton cancel6;
    public javax.swing.JButton clear;
    public javax.swing.JTextField cn;
    public javax.swing.JButton delete;
    public javax.swing.JTextField email;
    public javax.swing.JTextField firstname;
    public javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel13;
    public javax.swing.JPanel jPanel14;
    private javax.swing.JPanel jPanel15;
    public javax.swing.JPanel jPanel17;
    private javax.swing.JPanel jPanel2;
    public javax.swing.JPanel jPanel3;
    public javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    public javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    public javax.swing.JPanel jPanel8;
    public javax.swing.JPanel jPanel9;
    public javax.swing.JTextField lastname;
    public javax.swing.JTextField pw;
    public javax.swing.JButton refresh;
    public javax.swing.JButton remove;
    public javax.swing.JPanel remove1;
    public javax.swing.JButton select;
    public javax.swing.JComboBox<String> sq;
    public javax.swing.JTextField uid;
    public javax.swing.JTextField un;
    public javax.swing.JButton update;
    public javax.swing.JComboBox<String> us;
    public javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables

   
}
