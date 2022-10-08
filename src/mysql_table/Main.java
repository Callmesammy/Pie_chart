
package mysql_table;

import Connectivity.dataConnection;
import Model.Model_chart;
import java.awt.Color;
import java.sql.SQLException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class Main extends javax.swing.JFrame {

  
    
    public Main() {
        initComponents();
        getContentPane().setBackground(new Color(255,255,255));
    }

 
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pieChart1 = new Chart.PieChart();
        jLabel3 = new javax.swing.JLabel();
        comboMonth = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        comboyear = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel3.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel3.setText("Month");

        comboMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboMonthActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Segoe UI", 1, 12)); // NOI18N
        jLabel1.setText("Year");

        comboyear.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboyearActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(473, Short.MAX_VALUE)
                .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(40, 40, 40)
                .addComponent(comboyear, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(comboMonth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1)
                    .addComponent(comboyear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pieChart1, javax.swing.GroupLayout.DEFAULT_SIZE, 366, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            dataConnection.instance().tConnection();
            Showmonth();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }//GEN-LAST:event_formWindowOpened

    private void comboMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboMonthActionPerformed
             if (comboMonth.getSelectedIndex()>=0) {
            int year = Integer.valueOf(comboMonth.getSelectedItem().toString());
            try {
                comboyear.removeAllItems();
                Showyear(year);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }//GEN-LAST:event_comboMonthActionPerformed

    private void comboyearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboyearActionPerformed

        if (comboyear.getSelectedIndex()>=0) {
            int year = Integer.valueOf(comboyear.getSelectedItem().toString());
            Model_chart mode = (Model_chart)comboyear.getSelectedItem();
            showData(year, mode.getMonthNo());
            
        }
    }//GEN-LAST:event_comboyearActionPerformed
  
  private void Showmonth() throws SQLException {
      PreparedStatement p = dataConnection.instance().getConnection().prepareStatement("SELECT DATE_FORMAT(birth_date,'%Y') AS Month FROM customers GROUP BY Month");
      ResultSet t = p.executeQuery();
      while(t.next()){
          int yr = t.getInt("Month");
          comboMonth.addItem(yr + "");
          
      }
      p.close();
      t.close();
  }
  
  private void Showyear(int year) throws SQLException{
      PreparedStatement p = dataConnection.instance().getConnection().prepareStatement("SELECT DATE_FORMAT(birth_date,'%M')AS MonthText, DATE_FORMAT (birth_date,'%m') AS MonthNo FROM customers WHERE DATE_FORMAT(birth_date,'%Y') =? GROUP BY MonthNo");
      p.setInt(1, year);
      ResultSet t = p.executeQuery();
      
      while(t.next()){
          String Monthtext = t.getString("MonthText");
          int MonthNo = t.getInt("MonthNo");
          comboyear.addItem(new Model.Model_chart(MonthNo, Monthtext));         
      }
      
  }
    public void showData(int month, int year){
        try {
            PreparedStatement t = dataConnection.instance().getConnection().prepareStatement("");
            t.setInt(1, year);
            t.setInt(2, year);
            ResultSet p = t.executeQuery();
            while (p.next()){
        
            }
            t.close();
            p.close();
        } catch (Exception e) {
        }
        
    }
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox<String> comboMonth;
    private javax.swing.JComboBox<Object> comboyear;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private Chart.PieChart pieChart1;
    // End of variables declaration//GEN-END:variables
}
