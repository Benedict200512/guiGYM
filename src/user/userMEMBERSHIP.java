/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

import config.Session;
import config.dbConnector;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import sampleguigym1.loginForm;

/**
 *
 * @author Karystel
 */
public class userMEMBERSHIP extends javax.swing.JFrame {

    dbConnector connector = new dbConnector(); 

    public userMEMBERSHIP() {
        initComponents();
        loadMembershipDetails();
    }
    Color navcolor = new Color(153,255,252);
    Color hovercolor = new Color (0,204,204);

    private void loadMembershipDetails() {
    int userId = Session.getInstance().getUserId(); 

    String query = "SELECT m.workout_id, w.coach_id, " +
               "w.workout_name, w.description, w.difficulty_level, w.duration_minutes " +
               "FROM tbl_membership m " +
               "JOIN tbl_workout w ON m.workout_id = w.workout_id " +
               "WHERE m.user_id = ?";


    try {
        Connection con = connector.getConnection(); 
        PreparedStatement pst = con.prepareStatement(query);
        pst.setInt(1, userId);
        ResultSet rs = pst.executeQuery();

        if (rs.next()) {
            wid.setText(rs.getString("workout_id"));
            coachid.setText(rs.getString("coach_id"));
            wn.setText(rs.getString("workout_name"));
            descrip.setText(rs.getString("description"));
            dl.setText(rs.getString("difficulty_level"));
            dm.setText(rs.getString("duration_minutes"));
        } else {
            JOptionPane.showMessageDialog(this, "No membership found for your account.");
        }

        pst.close();
        rs.close();

    } catch (SQLException e) {
        e.printStackTrace();
        JOptionPane.showMessageDialog(this, "Error retrieving membership details: " + e.getMessage());
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        iddisplay = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        panel = new javax.swing.JPanel();
        acc_name = new javax.swing.JLabel();
        p_add = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        p_add4 = new javax.swing.JPanel();
        jLabel20 = new javax.swing.JLabel();
        p_add8 = new javax.swing.JPanel();
        jLabel21 = new javax.swing.JLabel();
        p_add9 = new javax.swing.JPanel();
        jLabel22 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        dll = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jPanel9 = new javax.swing.JPanel();
        jPanel10 = new javax.swing.JPanel();
        dm = new javax.swing.JTextField();
        wid = new javax.swing.JTextField();
        coachid = new javax.swing.JTextField();
        wn = new javax.swing.JTextField();
        descrip = new javax.swing.JTextField();
        dl = new javax.swing.JTextField();
        jSeparator1 = new javax.swing.JSeparator();
        jSeparator2 = new javax.swing.JSeparator();
        jPanel11 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowActivated(java.awt.event.WindowEvent evt) {
                formWindowActivated(evt);
            }
        });

        Container.setBackground(new java.awt.Color(0, 204, 204));
        Container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(0, 153, 153));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jButton1.setBackground(new java.awt.Color(0, 102, 102));
        jButton1.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 30)); // NOI18N
        jButton1.setText("BACK");
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

        iddisplay.setBackground(new java.awt.Color(255, 255, 255));
        iddisplay.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 38)); // NOI18N
        iddisplay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        iddisplay.setText("(UID)");

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 38)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("M E M B E R S H I P");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 385, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(iddisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 364, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 155, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(iddisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Header.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1080, 50));

        Container.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 110));

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/pngtree-avatar-icon-profile-icon-member-login-vector-isolated-png-image_1978396-removebg-preview.png"))); // NOI18N
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-70, 30, 280, 190));

        panel.setBackground(new java.awt.Color(0, 153, 153));
        panel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        panel.setLayout(null);

        acc_name.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        acc_name.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        acc_name.setText("USER");
        acc_name.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                acc_nameMouseClicked(evt);
            }
        });
        panel.add(acc_name);
        acc_name.setBounds(-2, 6, 220, 20);

        jPanel2.add(panel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 240, 220, 30));

        p_add.setBackground(new java.awt.Color(153, 255, 252));
        p_add.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                p_addMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_addMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_addMouseExited(evt);
            }
        });
        p_add.setLayout(null);

        jLabel5.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 18)); // NOI18N
        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("COACHES");
        p_add.add(jLabel5);
        jLabel5.setBounds(0, 50, 220, 30);

        p_add4.setBackground(new java.awt.Color(153, 255, 252));
        p_add4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_add4MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_add4MouseExited(evt);
            }
        });
        p_add4.setLayout(null);

        jLabel20.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 18)); // NOI18N
        jLabel20.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel20.setText("ADD");
        p_add4.add(jLabel20);
        jLabel20.setBounds(80, 10, 60, 30);

        p_add.add(p_add4);
        p_add4.setBounds(0, 0, 0, 0);

        p_add8.setBackground(new java.awt.Color(153, 255, 252));
        p_add8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_add8MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_add8MouseExited(evt);
            }
        });
        p_add8.setLayout(null);

        jLabel21.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 18)); // NOI18N
        jLabel21.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel21.setText("ADD");
        p_add8.add(jLabel21);
        jLabel21.setBounds(80, 10, 60, 30);

        p_add9.setBackground(new java.awt.Color(153, 255, 252));
        p_add9.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                p_add9MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                p_add9MouseExited(evt);
            }
        });
        p_add9.setLayout(null);

        jLabel22.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 18)); // NOI18N
        jLabel22.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel22.setText("ADD");
        p_add9.add(jLabel22);
        jLabel22.setBounds(80, 10, 60, 30);

        p_add8.add(p_add9);
        p_add9.setBounds(0, 0, 0, 0);

        p_add.add(p_add8);
        p_add8.setBounds(0, 0, 0, 0);

        jLabel6.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 18)); // NOI18N
        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("WORKOUTS");
        p_add.add(jLabel6);
        jLabel6.setBounds(0, 10, 220, 30);

        jLabel13.setFont(new java.awt.Font("Franklin Gothic Heavy", 1, 18)); // NOI18N
        jLabel13.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel13.setText("AND");
        p_add.add(jLabel13);
        jLabel13.setBounds(0, 30, 220, 30);

        jPanel2.add(p_add, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 330, 220, 90));

        Container.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 220, 500));

        jPanel4.setBackground(new java.awt.Color(0, 153, 153));
        jPanel4.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        jPanel4.setLayout(null);

        jLabel8.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 18)); // NOI18N
        jLabel8.setText("Duration minutes:");
        jPanel4.add(jLabel8);
        jLabel8.setBounds(50, 330, 230, 50);

        dll.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 18)); // NOI18N
        dll.setText("Difficulty level:");
        jPanel4.add(dll);
        dll.setBounds(50, 280, 270, 50);

        jLabel11.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 18)); // NOI18N
        jLabel11.setText("Description:");
        jPanel4.add(jLabel11);
        jLabel11.setBounds(50, 230, 260, 50);

        jLabel10.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 18)); // NOI18N
        jLabel10.setText("Workout Name:");
        jPanel4.add(jLabel10);
        jLabel10.setBounds(50, 180, 250, 50);

        jLabel9.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 18)); // NOI18N
        jLabel9.setText("Coach ID:");
        jPanel4.add(jLabel9);
        jLabel9.setBounds(50, 130, 120, 50);

        jLabel7.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 18)); // NOI18N
        jLabel7.setText("Workout ID:");
        jPanel4.add(jLabel7);
        jLabel7.setBounds(50, 80, 160, 50);

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel5);
        jPanel5.setBounds(40, 190, 160, 30);

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));
        jPanel6.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 108, Short.MAX_VALUE)
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel6);
        jPanel6.setBounds(40, 140, 110, 30);

        jPanel7.setBackground(new java.awt.Color(255, 255, 255));
        jPanel7.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel7);
        jPanel7.setBounds(40, 90, 130, 30);

        jPanel8.setBackground(new java.awt.Color(255, 255, 255));
        jPanel8.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 128, Short.MAX_VALUE)
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel8);
        jPanel8.setBounds(40, 240, 130, 30);

        jPanel9.setBackground(new java.awt.Color(255, 255, 255));
        jPanel9.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 158, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel9);
        jPanel9.setBounds(40, 290, 160, 30);

        jPanel10.setBackground(new java.awt.Color(255, 255, 255));
        jPanel10.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));

        javax.swing.GroupLayout jPanel10Layout = new javax.swing.GroupLayout(jPanel10);
        jPanel10.setLayout(jPanel10Layout);
        jPanel10Layout.setHorizontalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 188, Short.MAX_VALUE)
        );
        jPanel10Layout.setVerticalGroup(
            jPanel10Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 28, Short.MAX_VALUE)
        );

        jPanel4.add(jPanel10);
        jPanel10.setBounds(40, 340, 190, 30);

        dm.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        dm.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dm.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(dm);
        dm.setBounds(240, 340, 250, 30);

        wid.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        wid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(wid);
        wid.setBounds(180, 90, 250, 30);

        coachid.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        coachid.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        coachid.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(coachid);
        coachid.setBounds(160, 140, 250, 30);

        wn.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        wn.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        wn.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        wn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wnActionPerformed(evt);
            }
        });
        jPanel4.add(wn);
        wn.setBounds(210, 190, 250, 30);

        descrip.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        descrip.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        descrip.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(descrip);
        descrip.setBounds(180, 240, 250, 30);

        dl.setFont(new java.awt.Font("Arial", 1, 16)); // NOI18N
        dl.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        dl.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)));
        jPanel4.add(dl);
        dl.setBounds(210, 290, 250, 30);

        jSeparator1.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jSeparator1);
        jSeparator1.setBounds(0, 50, 820, 2);

        jSeparator2.setBackground(new java.awt.Color(0, 0, 0));
        jPanel4.add(jSeparator2);
        jSeparator2.setBounds(0, 402, 820, 10);

        jPanel11.setLayout(null);

        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/Dark Blue and Brown Illustrative Fitness Gym Logo (5).png"))); // NOI18N
        jPanel11.add(jLabel2);
        jLabel2.setBounds(1, -4, 220, 320);

        jPanel4.add(jPanel11);
        jPanel11.setBounds(560, 70, 220, 310);

        Container.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 130, 820, 460));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1080, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, 1080, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 610, Short.MAX_VALUE)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(Container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void acc_nameMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_acc_nameMouseClicked

    }//GEN-LAST:event_acc_nameMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        userDashboard usd = new userDashboard();
        usd.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1MouseClicked

    private void wnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_wnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_wnActionPerformed

    private void p_add4MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_add4MouseEntered

    }//GEN-LAST:event_p_add4MouseEntered

    private void p_add4MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_add4MouseExited

    }//GEN-LAST:event_p_add4MouseExited

    private void p_add9MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_add9MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_p_add9MouseEntered

    private void p_add9MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_add9MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_p_add9MouseExited

    private void p_add8MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_add8MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_p_add8MouseEntered

    private void p_add8MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_add8MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_p_add8MouseExited

    private void p_addMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseClicked
        workoutTable wt = new workoutTable();
        wt.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_p_addMouseClicked

    private void p_addMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseEntered
        p_add.setBackground(hovercolor);
    }//GEN-LAST:event_p_addMouseEntered

    private void p_addMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_p_addMouseExited
        p_add.setBackground(navcolor);
    }//GEN-LAST:event_p_addMouseExited

    private void formWindowActivated(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowActivated
Session sess = Session.getInstance();

if (sess.getUserId() == 0) {
    JOptionPane.showMessageDialog(null, "No account, Login First!");
    loginForm lfr = new loginForm();
    lfr.setVisible(true);
    this.dispose();       
    return;
} else {
    acc_name.setText(sess.getFirstname());
    iddisplay.setText("USER ID: " + sess.getUserId()); 
}
    }//GEN-LAST:event_formWindowActivated

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
            java.util.logging.Logger.getLogger(userMEMBERSHIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(userMEMBERSHIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(userMEMBERSHIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(userMEMBERSHIP.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new userMEMBERSHIP().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel acc_name;
    private javax.swing.JTextField coachid;
    private javax.swing.JTextField descrip;
    private javax.swing.JTextField dl;
    private javax.swing.JLabel dll;
    private javax.swing.JTextField dm;
    private javax.swing.JLabel iddisplay;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel10;
    private javax.swing.JPanel jPanel11;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JPanel p_add;
    private javax.swing.JPanel p_add4;
    private javax.swing.JPanel p_add8;
    private javax.swing.JPanel p_add9;
    private javax.swing.JPanel panel;
    private javax.swing.JTextField wid;
    private javax.swing.JTextField wn;
    // End of variables declaration//GEN-END:variables
}
