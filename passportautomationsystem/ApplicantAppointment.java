/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package passportautomationsystem;

import javax.swing.JOptionPane;


/**
 *
 * @author User
 */
public class ApplicantAppointment extends javax.swing.JFrame {
    private Applicant applicant;

    /**
     * Creates new form ApplicantAppointment
     */
    public ApplicantAppointment() {
        initComponents();
        applicant = new Applicant();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        timePicker1 = new com.raven.swing.TimePicker();
        applicantregistration = new javax.swing.JLabel();
        backBtn = new javax.swing.JButton();
        reenterpassword4 = new javax.swing.JLabel();
        reenterpassword5 = new javax.swing.JLabel();
        reenterpassword6 = new javax.swing.JLabel();
        time = new javax.swing.JTextField();
        idInput = new javax.swing.JTextField();
        daySelectionn = new javax.swing.JComboBox<>();
        monthSelectionn = new javax.swing.JComboBox<>();
        yearSelectionn = new javax.swing.JComboBox<>();
        enterBtn = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APPLICANT SCHEDULE APPOINTMENT");

        jPanel1.setBackground(new java.awt.Color(153, 204, 255));

        timePicker1.setForeground(new java.awt.Color(0, 102, 102));
        timePicker1.setDisplayText(time);

        applicantregistration.setFont(new java.awt.Font("Segoe UI", 1, 36)); // NOI18N
        applicantregistration.setForeground(new java.awt.Color(0, 51, 51));
        applicantregistration.setText("DOCUMENT VERIFICATION APPOINTMENT");

        backBtn.setFont(new java.awt.Font("Rockwell", 1, 14)); // NOI18N
        backBtn.setText("BACK");
        backBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                backBtnActionPerformed(evt);
            }
        });

        reenterpassword4.setBackground(new java.awt.Color(0, 0, 0));
        reenterpassword4.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        reenterpassword4.setText("Enter your Application ID :");

        reenterpassword5.setBackground(new java.awt.Color(0, 0, 0));
        reenterpassword5.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        reenterpassword5.setText("Select the Time :");

        reenterpassword6.setBackground(new java.awt.Color(0, 0, 0));
        reenterpassword6.setFont(new java.awt.Font("Segoe UI", 1, 18)); // NOI18N
        reenterpassword6.setText("Select the Date :");

        time.setBackground(new java.awt.Color(204, 255, 255));
        time.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                timeActionPerformed(evt);
            }
        });

        idInput.setBackground(new java.awt.Color(204, 255, 255));

        daySelectionn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        daySelectionn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31" }));
        daySelectionn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daySelectionnActionPerformed(evt);
            }
        });

        monthSelectionn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        monthSelectionn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        monthSelectionn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                monthSelectionnActionPerformed(evt);
            }
        });

        yearSelectionn.setFont(new java.awt.Font("Segoe UI", 0, 14)); // NOI18N
        yearSelectionn.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "2024", "2025", "2026", "2027" }));
        yearSelectionn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                yearSelectionnActionPerformed(evt);
            }
        });

        enterBtn.setFont(new java.awt.Font("Rockwell", 1, 24)); // NOI18N
        enterBtn.setText("ENTER");
        enterBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enterBtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addComponent(reenterpassword4)
                        .addGap(45, 45, 45)
                        .addComponent(idInput))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(109, 109, 109)
                        .addComponent(reenterpassword6)
                        .addGap(143, 143, 143)
                        .addComponent(reenterpassword5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, 268, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(41, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addComponent(daySelectionn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(monthSelectionn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(yearSelectionn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(59, 59, 59)
                                .addComponent(backBtn)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(enterBtn)
                        .addGap(134, 134, 134)))
                .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(120, 120, 120))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(applicantregistration)
                .addGap(58, 58, 58))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(applicantregistration)
                .addGap(50, 50, 50)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(reenterpassword4)
                    .addComponent(idInput, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 65, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(reenterpassword5)
                    .addComponent(reenterpassword6)
                    .addComponent(time, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(daySelectionn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(monthSelectionn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(yearSelectionn, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(119, 119, 119)
                        .addComponent(enterBtn)
                        .addGap(114, 114, 114)
                        .addComponent(backBtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(timePicker1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(118, 118, 118))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void backBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backBtnActionPerformed
        // TODO add your handling code here:
        ApplicantSelection applicantselection = new ApplicantSelection();
        applicantselection.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_backBtnActionPerformed

    private void daySelectionnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daySelectionnActionPerformed
        // TODO add your handling code here:
        String selectedDay = (String) daySelectionn.getSelectedItem();
    }//GEN-LAST:event_daySelectionnActionPerformed

    private void monthSelectionnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_monthSelectionnActionPerformed
        // TODO add your handling code here:
        String selectedMonth = (String) monthSelectionn.getSelectedItem();
    }//GEN-LAST:event_monthSelectionnActionPerformed

    private void yearSelectionnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_yearSelectionnActionPerformed
        // TODO add your handling code here:
        String selectedYear = (String) yearSelectionn.getSelectedItem();
    }//GEN-LAST:event_yearSelectionnActionPerformed

    private void timeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_timeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_timeActionPerformed

    private void enterBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enterBtnActionPerformed
        // TODO add your handling code here:
        String applicationID = idInput.getText();
        String selectedDay = (String) daySelectionn.getSelectedItem();
        String selectedMonth = (String) monthSelectionn.getSelectedItem();
        String selectedYear = (String) yearSelectionn.getSelectedItem();
        String selectedDate = selectedDay + "-" + selectedMonth + "-" + selectedYear;
        String selectedTime = time.getText();

        boolean success = applicant.scheduleAppointment(applicationID, selectedDate, selectedTime);

        if (success) {
                String successMessage = "Appointment Scheduled Successfully.";
                JOptionPane.showMessageDialog(this, successMessage, "Success", JOptionPane.INFORMATION_MESSAGE);
        }
        else {
            JOptionPane.showMessageDialog(this, "Update failed.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_enterBtnActionPerformed

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
            java.util.logging.Logger.getLogger(ApplicantAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(ApplicantAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(ApplicantAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(ApplicantAppointment.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ApplicantAppointment().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel applicantregistration;
    private javax.swing.JButton backBtn;
    private javax.swing.JComboBox<String> daySelectionn;
    private javax.swing.JButton enterBtn;
    private javax.swing.JTextField idInput;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JComboBox<String> monthSelectionn;
    private javax.swing.JLabel reenterpassword4;
    private javax.swing.JLabel reenterpassword5;
    private javax.swing.JLabel reenterpassword6;
    private javax.swing.JTextField time;
    private com.raven.swing.TimePicker timePicker1;
    private javax.swing.JComboBox<String> yearSelectionn;
    // End of variables declaration//GEN-END:variables


}
