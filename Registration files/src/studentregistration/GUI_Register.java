package studentregistration;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.*;
import java.time.*;
import javax.swing.JOptionPane;
public class GUI_Register extends javax.swing.JFrame {

    public GUI_Register() {
        initComponents();
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        S_Name = new javax.swing.JLabel();
        S_URN = new javax.swing.JLabel();
        S_Department = new javax.swing.JLabel();
        Name = new javax.swing.JTextField();
        URN = new javax.swing.JTextField();
        Department = new javax.swing.JTextField();
        Submit = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("ONLINE REGISTRATION");
        setBackground(new java.awt.Color(153, 255, 153));
        setForeground(new java.awt.Color(0, 153, 153));

        jLabel1.setBackground(new java.awt.Color(204, 255, 204));
        jLabel1.setFont(new java.awt.Font("Cambria", 0, 12)); // NOI18N
        jLabel1.setText("Welcome to Library Registration at MSRUAS");

        S_Name.setBackground(new java.awt.Color(0, 204, 51));
        S_Name.setForeground(new java.awt.Color(51, 51, 51));
        S_Name.setText("Enter Name");

        S_URN.setText("Enter URN ");

        S_Department.setText("Department");

        Submit.setBackground(new java.awt.Color(204, 255, 255));
        Submit.setFont(new java.awt.Font("Microsoft JhengHei", 1, 12)); // NOI18N
        Submit.setForeground(new java.awt.Color(204, 0, 0));
        Submit.setText("Register");
        Submit.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        Submit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SubmitActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(141, 141, 141)
                        .addComponent(Submit))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(84, 84, 84)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                        .addComponent(S_URN, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(S_Name, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 72, Short.MAX_VALUE))
                                    .addComponent(S_Department, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(58, 58, 58)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(Name)
                                    .addComponent(URN)
                                    .addComponent(Department, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE))))))
                .addContainerGap(63, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(S_Name, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Name, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(37, 37, 37)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(S_URN, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(URN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(S_Department, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Department, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                .addComponent(Submit)
                .addGap(24, 24, 24))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SubmitActionPerformed
        String url = "jdbc:mysql://localhost:3306/register?useSSl=true";
        String user = "root";
        String pass = "Poornesh@123";
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,user,pass);
            JOptionPane.showMessageDialog(null, "Connected to MSRUAS");
            String Student_Name = Name.getText();
            String Student_URN = URN.getText();
            String Student_Department = Department.getText();
            String query = "Insert into StudentDetails Values('"+Student_Name+"','"+Student_URN+"','"+Student_Department+"');";
            Statement st = con.createStatement();
            st.executeUpdate(query);
            ResultSet rs = st.executeQuery("Select count(*) from Studentdetails");
            rs.next();
            int Total = rs.getInt(1);
            int id = (int)(Math.round(Math.random()*10000));
            JOptionPane.showMessageDialog(null,"Registration successful-- Your Reference key : "+id);
            System.out.println("One Student Added");
            System.out.println("Total Students registered @MSRUAS : "+Total);
            
        }catch(Exception e){System.out.println(e);}
        
    }//GEN-LAST:event_SubmitActionPerformed

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
            java.util.logging.Logger.getLogger(GUI_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(GUI_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(GUI_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(GUI_Register.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new GUI_Register().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField Department;
    private javax.swing.JTextField Name;
    private javax.swing.JLabel S_Department;
    private javax.swing.JLabel S_Name;
    private javax.swing.JLabel S_URN;
    private javax.swing.JButton Submit;
    private javax.swing.JTextField URN;
    private javax.swing.JLabel jLabel1;
    // End of variables declaration//GEN-END:variables
}
