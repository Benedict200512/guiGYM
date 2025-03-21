/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import admin.adminDashboard;
import config.Session;
import config.dbConnector;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sampleguigym1.loginForm;
import sampleguigym1.registrationform;

/**
 *
 * @author Karystel
 */
public class accountDetails extends javax.swing.JFrame {

    /**
     * Creates new form userDashboard
     */
    public accountDetails() {
        initComponents();
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
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        iddisplay = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        acc_lname = new javax.swing.JTextField();
        acc_fname = new javax.swing.JTextField();
        firstname = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        un = new javax.swing.JTextField();
        lastname = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cn = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        ut = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        email = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Container.setBackground(new java.awt.Color(0, 204, 204));
        Container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(0, 153, 153));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 30)); // NOI18N
        jButton1.setText("LOG-OUT");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 38)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("ACCOUNT INFORMATION");

        iddisplay.setBackground(new java.awt.Color(255, 255, 255));
        iddisplay.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 38)); // NOI18N
        iddisplay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        iddisplay.setText("(UID)");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 483, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(iddisplay, javax.swing.GroupLayout.DEFAULT_SIZE, 381, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(iddisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Header.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1080, 50));

        Container.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 110));

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngtree-avatar-icon-profile-icon-member-login-vector-isolated-png-image_1978396-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 40, 280, 190));

        acc_lname.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 18)); // NOI18N
        acc_lname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        acc_lname.setText("USER");
        acc_lname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_lnameActionPerformed(evt);
            }
        });
        jPanel2.add(acc_lname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 280, 220, 30));

        acc_fname.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 18)); // NOI18N
        acc_fname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        acc_fname.setText("acc_fn");
        acc_fname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acc_fnameActionPerformed(evt);
            }
        });
        jPanel2.add(acc_fname, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 220, 30));

        Container.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 220, 500));

        firstname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        firstname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        firstname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                firstnameActionPerformed(evt);
            }
        });
        Container.add(firstname, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 180, 260, 40));

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 17)); // NOI18N
        jLabel6.setText("First Name:");
        Container.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 180, 120, 40));

        un.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        un.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        un.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                unActionPerformed(evt);
            }
        });
        Container.add(un, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 430, 260, 40));

        lastname.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        lastname.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        lastname.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                lastnameActionPerformed(evt);
            }
        });
        Container.add(lastname, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 230, 260, 40));

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 17)); // NOI18N
        jLabel8.setText("Last Name:");
        Container.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 220, 110, 60));

        cn.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        cn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        cn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cnActionPerformed(evt);
            }
        });
        Container.add(cn, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 330, 260, 40));

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 17)); // NOI18N
        jLabel9.setText("Contact num:");
        Container.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 320, -1, 60));

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 17)); // NOI18N
        jLabel10.setText("User Type:");
        Container.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 370, 110, 60));

        ut.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        ut.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "ADMIN", "USER" }));
        ut.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                utActionPerformed(evt);
            }
        });
        Container.add(ut, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 380, 260, 40));

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 17)); // NOI18N
        jLabel11.setText("Email:");
        Container.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 270, 70, 60));

        email.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        email.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        email.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                emailActionPerformed(evt);
            }
        });
        Container.add(email, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 280, 260, 40));

        jLabel12.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 17)); // NOI18N
        jLabel12.setText("Username:");
        Container.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 420, 110, 60));

        jLabel4.setFont(new java.awt.Font("Arial", 3, 16)); // NOI18N
        jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel4.setText("Do you want to change password?");
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        Container.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 480, 380, 20));

        jPanel4.setBackground(new java.awt.Color(0, 102, 102));
        jPanel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel4MouseClicked(evt);
            }
        });
        jPanel4.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 18)); // NOI18N
        jLabel5.setText("SAVE");
        jLabel5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel5MouseClicked(evt);
            }
        });
        jPanel4.add(jLabel5);
        jLabel5.setBounds(30, 10, 50, 30);

        jPanel5.setBackground(new java.awt.Color(0, 102, 102));
        jPanel5.setLayout(null);

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 18)); // NOI18N
        jLabel7.setText("SAVE");
        jPanel5.add(jLabel7);
        jLabel7.setBounds(30, 10, 50, 30);

        jPanel4.add(jPanel5);
        jPanel5.setBounds(0, 0, 0, 0);

        Container.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(750, 510, 110, 50));

        getContentPane().add(Container, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1080, -1));

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to logout?", "Logout Confirmation", JOptionPane.YES_NO_OPTION);

        if (confirm == JOptionPane.YES_OPTION) {
           // Clear user session (if applicable)
           Object loggedInUser = null; 

        // Redirect to login form
        loginForm login = new loginForm();
        login.setVisible(true);

        // Close current dashboard
        this.dispose();
    }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void acc_lnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_lnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_lnameActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
        Session sess = Session.getInstance();
        if(sess.getUserId()== 0){
             JOptionPane.showMessageDialog(null, "No account, Login First!");
             userDashboard usd = new userDashboard();
             usd.setVisible(true);
             this.dispose();      
        }else{
        acc_fname.setText(""+sess.getFirstname());
        acc_lname.setText(""+sess.getLastname());
        }
        
        iddisplay.setText("USER ID:"+sess.getUserId());
        firstname.setText(""+sess.getFirstname());
        lastname.setText(""+sess.getLastname());
        email.setText(""+sess.getEmail());
        cn.setText(""+sess.getContact());
        un.setText(""+sess.getUsername());
     
    }//GEN-LAST:event_formWindowActivated

    private void utActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_utActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_utActionPerformed

    private void lastnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_lastnameActionPerformed

    }//GEN-LAST:event_lastnameActionPerformed

    private void emailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_emailActionPerformed

    }//GEN-LAST:event_emailActionPerformed

    private void unActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_unActionPerformed

    }//GEN-LAST:event_unActionPerformed

    private void cnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cnActionPerformed

    }//GEN-LAST:event_cnActionPerformed

    private void firstnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_firstnameActionPerformed

    }//GEN-LAST:event_firstnameActionPerformed

    private void acc_fnameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acc_fnameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acc_fnameActionPerformed

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
       int confirm = JOptionPane.showConfirmDialog(this, "Do you want to change password?", "IloveSirMike", JOptionPane.YES_NO_OPTION);

    if (confirm == JOptionPane.YES_OPTION) {
           Object loggedInUser = null; 

        // Redirect to login form
        changePass cps = new changePass();
        cps.setVisible(true);

        // Close current dashboard
        this.dispose();
    }
        
    }//GEN-LAST:event_jLabel4MouseClicked

    private void jLabel5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel5MouseClicked
        try {
    dbConnector dbc = new dbConnector();
    Session sess = Session.getInstance();
    
    String query = "SELECT * FROM tbl_user WHERE user_id = '" + sess.getUserId() + "'";
    ResultSet rs = dbc.getData(query);
    
    if (rs.next()) {
        // Retrieve user inputs
        String fname = firstname.getText().trim();
        String lname = lastname.getText().trim();
        String em = email.getText().trim();
        String contact = cn.getText().trim();
        String userType = ut.getSelectedItem().toString();
        String username = un.getText().trim();

        // Validation checks
        if (fname.isEmpty() || lname.isEmpty() || em.isEmpty() || contact.isEmpty() || username.isEmpty()) {
            JOptionPane.showMessageDialog(null, "All fields are required!");
            return;
        }
        
        if (!em.matches("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$")) {
            JOptionPane.showMessageDialog(null, "Invalid email format!");
            return;
        }
        
        if (!contact.matches("^\\d{10,15}$")) {
            JOptionPane.showMessageDialog(null, "Invalid contact number! It must be 10-15 digits long.");
            return;
        }
        
        // Update query
        String updateQuery = "UPDATE tbl_user SET user_firstname = '" + fname + "', user_lastname = '" + lname + "', " +
                             "user_email = '" + em + "', user_contact = '" + contact + "', " +
                             "user_usertype = '" + userType + "', user_username = '" + username + "' " +
                             "WHERE user_id = '" + sess.getUserId() + "'";
        
        dbc.updateData(updateQuery);
        JOptionPane.showMessageDialog(null, "User details successfully updated!");
        
        loginForm lg = new loginForm();
        lg.setVisible(true);
        this.dispose();
    }
} catch (SQLException ex) {
    System.out.println("SQL Error: " + ex);
}

    }//GEN-LAST:event_jLabel5MouseClicked

    private void jPanel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel4MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jPanel4MouseClicked

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
            java.util.logging.Logger.getLogger(accountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(accountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(accountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(accountDetails.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new accountDetails().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Header;
    private javax.swing.JTextField acc_fname;
    private javax.swing.JTextField acc_lname;
    private javax.swing.JTextField cn;
    private javax.swing.JTextField email;
    private javax.swing.JTextField firstname;
    private javax.swing.JLabel iddisplay;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JTextField lastname;
    private javax.swing.JTextField un;
    private javax.swing.JComboBox<String> ut;
    // End of variables declaration//GEN-END:variables
}
