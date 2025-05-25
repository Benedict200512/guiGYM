/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin;

import config.dbConnector;
import java.awt.Color;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.table.TableModel;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Karystel
 */
public class workoutTablee extends javax.swing.JFrame {

    /**
     * Creates new form workoutTablee
     */
    private createMembership parent;

    public workoutTablee(createMembership parent) {
    initComponents();
    this.parent = parent;
        displayData();
    }
       Color navcolor = new Color(153,255,252);
       Color hovercolor = new Color (0,204,204);
        public void displayData(){
        try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT * FROM tbl_workout");
            workoutTable.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
         try{
            dbConnector dbc = new dbConnector();
            ResultSet rs = dbc.getData("SELECT * FROM tbl_coach");
            coachTable.setModel(DbUtils.resultSetToTableModel(rs));
             rs.close();
        }catch(SQLException ex){
            System.out.println("Errors: "+ex.getMessage());
        
        }
    
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Container = new javax.swing.JPanel();
        Header = new javax.swing.JPanel();
        jPanel1 = new javax.swing.JPanel();
        back = new javax.swing.JButton();
        iddisplay = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        cancel = new javax.swing.JPanel();
        account3 = new javax.swing.JLabel();
        select = new javax.swing.JPanel();
        account2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        coachTable = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        workoutTable = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        Container.setBackground(new java.awt.Color(0, 204, 204));
        Container.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        Header.setBackground(new java.awt.Color(0, 153, 153));
        Header.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        back.setBackground(new java.awt.Color(0, 102, 102));
        back.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 30)); // NOI18N
        back.setText("BACK");
        back.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                backMouseClicked(evt);
            }
        });
        back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backActionPerformed(evt);
            }
        });

        iddisplay.setBackground(new java.awt.Color(255, 255, 255));
        iddisplay.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 38)); // NOI18N
        iddisplay.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);

        jLabel3.setBackground(new java.awt.Color(255, 255, 255));
        jLabel3.setFont(new java.awt.Font("Franklin Gothic Heavy", 3, 38)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("WORKOUT TABLE");

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
                .addComponent(back)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
                    .addComponent(iddisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        Header.add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 30, 1080, 50));

        Container.add(Header, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1090, 110));

        jPanel2.setBackground(new java.awt.Color(153, 255, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        cancel.setBackground(new java.awt.Color(153, 255, 255));
        cancel.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        cancel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cancelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                cancelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                cancelMouseExited(evt);
            }
        });
        cancel.setLayout(null);

        account3.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        account3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        account3.setText("CANCEL");
        account3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                account3MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                account3MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                account3MouseExited(evt);
            }
        });
        cancel.add(account3);
        account3.setBounds(0, 10, 220, 21);

        jPanel2.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 270, 220, 40));

        select.setBackground(new java.awt.Color(153, 255, 255));
        select.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        select.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                selectMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                selectMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                selectMouseExited(evt);
            }
        });
        select.setLayout(null);

        account2.setFont(new java.awt.Font("Franklin Gothic Medium", 1, 18)); // NOI18N
        account2.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        account2.setText("SELECT");
        account2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                account2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                account2MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                account2MouseExited(evt);
            }
        });
        select.add(account2);
        account2.setBounds(0, 10, 220, 21);

        jPanel2.add(select, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 200, 220, 40));

        Container.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 110, 220, 500));

        coachTable.setBackground(new java.awt.Color(0, 102, 102));
        coachTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        coachTable.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        coachTable.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane1.setViewportView(coachTable);

        Container.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 370, 780, 230));

        workoutTable.setBackground(new java.awt.Color(0, 102, 102));
        workoutTable.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));
        workoutTable.setFont(new java.awt.Font("Agency FB", 0, 15)); // NOI18N
        workoutTable.setForeground(new java.awt.Color(255, 255, 255));
        jScrollPane2.setViewportView(workoutTable);

        Container.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 120, 780, 230));

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

    private void backMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_backMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_backMouseClicked

    private void backActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backActionPerformed
        createMembership cb = new createMembership();
        cb.setVisible(true);
        this.dispose();

    }//GEN-LAST:event_backActionPerformed

    private void account3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account3MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_account3MouseClicked

    private void account3MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account3MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_account3MouseEntered

    private void account3MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account3MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_account3MouseExited

    private void cancelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseClicked
        createMembership cb = new createMembership();
        cb.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cancelMouseClicked

    private void cancelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseEntered
        cancel.setBackground(hovercolor);
    }//GEN-LAST:event_cancelMouseEntered

    private void cancelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cancelMouseExited
        cancel.setBackground(navcolor);
    }//GEN-LAST:event_cancelMouseExited

    private void account2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_account2MouseClicked

    private void account2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account2MouseEntered

    }//GEN-LAST:event_account2MouseEntered

    private void account2MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_account2MouseExited

    }//GEN-LAST:event_account2MouseExited

    private void selectMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseClicked
        int rowIndex = workoutTable.getSelectedRow();
if (rowIndex < 0) {
    JOptionPane.showMessageDialog(null, "Please select a workout!");
} else {
    String workoutId = workoutTable.getValueAt(rowIndex, 0).toString(); 
    String coachId   = workoutTable.getValueAt(rowIndex, 1).toString();

    parent.setWorkoutDetails(workoutId, coachId);
    parent.setVisible(true);
    this.dispose();
}

    }//GEN-LAST:event_selectMouseClicked

    private void selectMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseEntered
        select.setBackground(hovercolor);
    }//GEN-LAST:event_selectMouseEntered

    private void selectMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_selectMouseExited
        select.setBackground(navcolor);
    }//GEN-LAST:event_selectMouseExited

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
            java.util.logging.Logger.getLogger(workoutTablee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(workoutTablee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(workoutTablee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(workoutTablee.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Container;
    private javax.swing.JPanel Header;
    private javax.swing.JLabel account2;
    private javax.swing.JLabel account3;
    private javax.swing.JButton back;
    private javax.swing.JPanel cancel;
    private javax.swing.JTable coachTable;
    private javax.swing.JLabel iddisplay;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JPanel select;
    private javax.swing.JTable workoutTable;
    // End of variables declaration//GEN-END:variables
}
