/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sampleguigym1;

import config.dbConnector;
import config.passwordHasher;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author Karystel
 */
public class registrationform extends javax.swing.JFrame {

    /**
     * Creates new form registrationform
     */
    public registrationform() {
        initComponents();
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
    
   public static String em, uname;
    
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
                uname = resultSet.getString("user_username");
                if(uname.equals(un.getText())){
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

        Container = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        pw = new javax.swing.JPasswordField();
        reg = new javax.swing.JButton();
        Cancel = new javax.swing.JButton();
        firstname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        lastname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cn = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        sq = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        sp = new javax.swing.JCheckBox();
        jLabel12 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        ans = new javax.swing.JPasswordField();
        cpass = new javax.swing.JPasswordField();
        ut = new javax.swing.JComboBox<>();
        jPanel3 = new javax.swing.JPanel();
        image = new javax.swing.JLabel();
        select = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Container.setBackground(new java.awt.Color(0, 204, 204));
        Container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(0, 153, 153));
        Header.setBorder(javax.swing.BorderFactory.createMatteBorder(2, 2, 2, 2, new java.awt.Color(0, 0, 0)));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setBackground(new java.awt.Color(255, 255, 255));
        jLabel1.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 30)); // NOI18N
        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("WELCOME TO GYM MANAGEMENT SYSTEM ");
        Header.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1130, 30));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1130, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 30, Short.MAX_VALUE)
        );

        Header.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 40, 1130, 30));

        Container.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1130, 110));

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Dark Blue and Brown Illustrative Fitness Gym Logo (5).png"))); // NOI18N
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 420, 500));

        Container.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 420, 500));

        jLabel2.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 24)); // NOI18N
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setText("REGISTRATION FORM");
        Container.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 120, 420, -1));

        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel3.setText("Password:");
        Container.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 390, 110, 50));

        pw.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        pw.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        pw.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        pw.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pwActionPerformed(evt);
            }
        });
        Container.add(pw, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 400, 240, 30));

        reg.setBackground(new java.awt.Color(0, 102, 102));
        reg.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        reg.setText("REGISTER");
        reg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                regActionPerformed(evt);
            }
        });
        Container.add(reg, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 560, 110, -1));

        Cancel.setBackground(new java.awt.Color(0, 102, 102));
        Cancel.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        Cancel.setText("CANCEL");
        Cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CancelActionPerformed(evt);
            }
        });
        Container.add(Cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 560, 110, -1));

        firstname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        firstname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        Container.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 240, 30));

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel6.setText("First Name:");
        Container.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 150, 120, 50));

        un.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        un.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        un.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unActionPerformed(evt);
            }
        });
        Container.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 360, 240, 30));

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel7.setText("Username:");
        Container.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 350, 110, 50));

        lastname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lastname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastname.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        Container.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 200, 240, 30));

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel8.setText("Last Name:");
        Container.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 190, 110, 50));

        cn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnActionPerformed(evt);
            }
        });
        Container.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 280, 240, 30));

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel9.setText("Contact num:");
        Container.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 270, 110, 50));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel10.setText("User Type:");
        Container.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 310, 110, 50));

        sq.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        sq.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "What is your favorite food?", "What is your mother's maiden name?", "What is your favorite color?", "What is your favorite movie?", "In what city were you born?" }));
        sq.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        sq.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sqActionPerformed(evt);
            }
        });
        Container.add(sq, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 480, 240, 30));

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel5.setText("Answer:");
        Container.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 510, 120, 50));

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel11.setText("Email:");
        Container.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 230, 70, 50));

        email.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        Container.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 240, 240, 30));

        sp.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        sp.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 2, true));
        sp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spActionPerformed(evt);
            }
        });
        Container.add(sp, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 400, 20, 30));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel12.setText("Confirm Pass:");
        Container.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 430, 120, 50));

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 15)); // NOI18N
        jLabel13.setText("Security Question:");
        Container.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 470, 160, 50));

        ans.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ans.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        ans.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ans.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ansActionPerformed(evt);
            }
        });
        Container.add(ans, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 520, 240, 30));

        cpass.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cpass.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cpass.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cpass.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cpassActionPerformed(evt);
            }
        });
        Container.add(cpass, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 440, 240, 30));

        ut.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "USER" }));
        ut.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });
        Container.add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 320, 240, 30));

        jPanel3.setLayout(null);
        jPanel3.add(image);
        image.setBounds(10, 10, 200, 160);

        Container.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(880, 160, 220, 180));

        select.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        select.setText("SELECT");
        select.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        select.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                selectActionPerformed(evt);
            }
        });
        Container.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(930, 360, 130, 30));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, 1126, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void pwActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pwActionPerformed
        
    }//GEN-LAST:event_pwActionPerformed

    private void CancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CancelActionPerformed
       loginForm lfm = new loginForm();
       lfm.setVisible(true);
       this.dispose();
    }//GEN-LAST:event_CancelActionPerformed

    private void unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unActionPerformed
        
    }//GEN-LAST:event_unActionPerformed

    private void cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnActionPerformed
    
    }//GEN-LAST:event_cnActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed

    }//GEN-LAST:event_firstnameActionPerformed

    private void regActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_regActionPerformed
                       
    if (firstname.getText().isEmpty() || lastname.getText().isEmpty() || email.getText().isEmpty() ||
        cn.getText().isEmpty() || un.getText().isEmpty() || pw.getText().isEmpty() || 
        cpass.getText().isEmpty() || ans.getText().isEmpty()) {

        JOptionPane.showMessageDialog(null, "All fields are required!");
        return;

    } else if (pw.getText().length() < 8) {
        JOptionPane.showMessageDialog(null, "Password must be at least 8 characters long.");
        pw.setText("");
        cpass.setText("");
        return;

    } else if (!pw.getText().equals(cpass.getText())) {
        JOptionPane.showMessageDialog(null, "Passwords do not match.");
        pw.setText("");
        cpass.setText("");
        return;

    } else if (!email.getText().matches("^[\\w.-]+@gmail\\.com$")) {
        JOptionPane.showMessageDialog(null, "Invalid email format. Must end with @gmail.com.");
        email.setText("");
        return;

    } else if (!cn.getText().matches("\\d{11}")) {
        JOptionPane.showMessageDialog(null, "Contact number must contain only digits and be 11 digits long.");
        cn.setText("");
        return;

    } else if (duplicateCheck()) {
        JOptionPane.showMessageDialog(null, "Duplicate user exists!");
        return;
    }

    try {
        dbConnector dbc = new dbConnector();
        String hashedPass = passwordHasher.hashPassword(pw.getText());
        String hashedAnswer = passwordHasher.hashPassword(ans.getText());
        String status = "Pending";
        String image = "Undecided";
        String question = sq.getSelectedItem().toString();

        String sql = "INSERT INTO tbl_user (user_firstname, user_lastname, user_email, user_contact, user_username, user_password, user_usertype, user_status, user_image, user_security_question, user_security_answer) " +
                     "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        PreparedStatement pst = dbc.connect.prepareStatement(sql);
        pst.setString(1, firstname.getText());
        pst.setString(2, lastname.getText());
        pst.setString(3, email.getText());
        pst.setString(4, cn.getText());
        pst.setString(5, un.getText());
        pst.setString(6, hashedPass);
        pst.setString(7, ut.getSelectedItem().toString());
        pst.setString(8, status);
        pst.setString(9, image);
        pst.setString(10, question);
        pst.setString(11, hashedAnswer);

        int inserted = pst.executeUpdate();

        if (inserted > 0) {
            JOptionPane.showMessageDialog(null, "Inserted Successfully!");
            loginForm lfr = new loginForm();
            lfr.setVisible(true);
            this.dispose();
        } else {
            JOptionPane.showMessageDialog(null, "Registration failed!");
        }

        pst.close();

    } catch (Exception ex) {
        ex.printStackTrace();
        JOptionPane.showMessageDialog(null, "An error occurred: " + ex.getMessage());
    }


    }//GEN-LAST:event_regActionPerformed

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed
     
    }//GEN-LAST:event_lastnameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed
    
    }//GEN-LAST:event_emailActionPerformed

    private void spActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spActionPerformed
        if(sp.isSelected()){
           pw.setEchoChar((char)0);
           cpass.setEchoChar((char)0);
        }
        else {
            pw.setEchoChar('*');
            cpass.setEchoChar('*');
        }
    }//GEN-LAST:event_spActionPerformed

    private void sqActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sqActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_sqActionPerformed

    private void ansActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ansActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ansActionPerformed

    private void cpassActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cpassActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_cpassActionPerformed

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

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
                            select.setEnabled(true);
                           
                        }
                    } catch (Exception ex) {
                        System.out.println("File Error!");
                    }
                }
    }//GEN-LAST:event_selectActionPerformed

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
            java.util.logging.Logger.getLogger(registrationform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(registrationform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(registrationform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(registrationform.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new registrationform().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Cancel;
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Header;
    private javax.swing.JPasswordField ans;
    private javax.swing.JTextField cn;
    private javax.swing.JPasswordField cpass;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel image;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField lastname;
    private javax.swing.JPasswordField pw;
    private javax.swing.JButton reg;
    public javax.swing.JButton select;
    private javax.swing.JCheckBox sp;
    private javax.swing.JComboBox<String> sq;
    private javax.swing.JTextField un;
    private javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
