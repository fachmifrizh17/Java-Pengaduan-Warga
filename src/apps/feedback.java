/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package apps;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GraphicsEnvironment;
import java.awt.Point;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FBS
 */
public class feedback extends javax.swing.JFrame {
private DefaultTableModel data;
    Connection conn;
    Statement stm;
    ResultSet rs;
    /**
     * Creates new form feedback
     */
    public feedback() {
        initComponents();
        tabel();
        ImageIcon img = new ImageIcon("src/focon/logo.png");
        this.setIconImage(img.getImage());
        initUI();
        kosong();
        block();
        kode();
        idwarga.setVisible(false);
    }
    
    protected void block(){
    id.setEnabled(false);
    idpengajuan.setEnabled(false);
    idwarga.setEnabled(false);
    namawarga.setEnabled(false);
    masukan.setEnabled(false);
    status.setEnabled(false);
    tanggal.setEnabled(false);
    }

     protected void kosong(){
        save.setEnabled(true);
        idpengajuan.setText("");
        idwarga.setText("");
        namawarga.setText("");
        status.setText("");
        tanggal.setText("");
        tanggalapprove.setDate(null);
        masukan.setText("");
        keterangan.setText(""); 
    }
     
    public void kode() {
        try {
            String sql = "SELECT * FROM feedback ORDER by id_feedback desc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet r = stat.executeQuery(sql);
            if (r.next()) {
                String nofak = r.getString("id_feedback").substring(1);
                String AN = "" + (Integer.parseInt(nofak) + 1);
                String Nol = "";
                if (AN.length() == 1) {
                    Nol = "000";
                } else if (AN.length() == 2) {
                    Nol = "00";
                } else if (AN.length() == 3) {
                    Nol = "0";
                } else if (AN.length() == 4) {
                    Nol = "";
                }
               id.setText("F" + Nol + AN);
            } else {
               id.setText("F0001");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
    }
    
    private void initUI(){ 
        getContentPane().setBackground(new Color(245, 245, 245));
        
        Dimension windowSize = getSize();
        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        Point centerPoint = ge.getCenterPoint();
        int dx = centerPoint.x - windowSize.width / 2;
        int dy = centerPoint.y - windowSize.height / 2;    
        setLocation(dx, dy);
    }
     
     public Connection setKoneksi(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost/projectwarga","root","");
            stm=conn.createStatement();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null,"Koneksi Gagal :" +e);
        }
       return conn; 
    }

    public void tabel(){
        Object header[]={"ID PENGAJUAN","ID WARGA","NAMA WARGA","STATUS","TANGGAL","MASUKAN"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabel.setModel(data);
        setKoneksi();
        String sql = "SELECT * FROM approval WHERE status = 'DISETUJUI' and aktif='0'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString("id_pengajuan");
                String kolom2=rs.getString("id_warga");
                String kolom3=rs.getString("nama_warga");
                String kolom4=rs.getString("status");
                String kolom5=rs.getString("tanggal");
                String kolom6=rs.getString("masukan");

                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6};
                data.addRow(kolom);
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "data gagal dipanggil"+e);
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

        jPanel1 = new javax.swing.JPanel();
        jLabel12 = new javax.swing.JLabel();
        cancel = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        id = new javax.swing.JTextField();
        idpengajuan = new javax.swing.JTextField();
        namawarga = new javax.swing.JTextField();
        tanggalapprove = new com.toedter.calendar.JDateChooser();
        jScrollPane4 = new javax.swing.JScrollPane();
        masukan = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        keterangan = new javax.swing.JTextArea();
        save = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        status = new javax.swing.JTextField();
        tanggal = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        idwarga = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FEEDBACK");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(950, 475));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel12.setText("ID / ID MASUKAN");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/focon/refresh.png"))); // NOI18N
        cancel.setText("B A T A L");
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 250, 30));

        tabel.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabel);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 320, 890, 130));

        jLabel3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel3MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 50, 50));

        jLabel11.setText("NAMA WARGA");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        jLabel10.setText("STATUS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        jLabel13.setText("MASUKAN");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 30));

        jLabel9.setText("FEEDBACK *");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 30));
        jPanel1.add(id, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 90, 30));
        jPanel1.add(idpengajuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 90, 30));
        jPanel1.add(namawarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 370, 30));
        jPanel1.add(tanggalapprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 160, 170, 30));

        masukan.setColumns(20);
        masukan.setRows(5);
        jScrollPane4.setViewportView(masukan);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 370, 40));

        keterangan.setColumns(20);
        keterangan.setRows(5);
        jScrollPane5.setViewportView(keterangan);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 370, 40));

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/focon/save.png"))); // NOI18N
        save.setText("S I M P A N");
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 250, 30));

        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 50, 50));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/focon/close.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, -1));
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 370, 30));
        jPanel1.add(tanggal, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 190, 30));

        jLabel4.setText("TANGGAL APPROVE / TANGGAL");
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 30));
        jPanel1.add(idwarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 80, 40, -1));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/focon/MENU FEEDBACK.png"))); // NOI18N
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, -1));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jLabel3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel3MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new apps. menu_petugas().setVisible(true);
    }//GEN-LAST:event_jLabel3MouseClicked

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
        // TODO add your handling code here:
        String insertQuery = "INSERT INTO feedback "
            + "(id_feedback, "
            + "id_pengajuan, "
            + "id_warga, "
            + "nama_warga, "
            + "tanggal_feedback, "
            + "tanggal_approve,"
            + "status,"
            + "masukan, "
            + "feedback) "
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        // Validasi tanggal yang dipilih
        java.util.Date selectedDate = tanggalapprove.getDate();
        System.out.println("Selected Date: " + selectedDate);
        if (selectedDate != null) {
            // Periksa apakah tanggal yang dipilih adalah hari ini atau berikutnya
            java.util.Date currentDate = new java.util.Date();
            if  (selectedDate.after(currentDate)) {
                // Eksekusi query INSERT
                PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
                insertStatement.setString(1, id.getText());
                insertStatement.setString(2, idpengajuan.getText());
                insertStatement.setString(3, idwarga.getText());
                insertStatement.setString(4, namawarga.getText());
                insertStatement.setString(5, tanggal.getText());
                insertStatement.setDate(6, new java.sql.Date(selectedDate.getTime()));
                insertStatement.setString(7, "SUDAH SELESAI");
                insertStatement.setString(8, masukan.getText());
                insertStatement.setString(9, keterangan.getText());
                  
                insertStatement.executeUpdate();

                // Setelah berhasil menyimpan data, perbarui status di tabel pengajuan
                String updateQuery = "UPDATE pengajuan SET status = ?, tanggal_feedback = ?, keluaran = ? WHERE id = ?";
                PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
                updateStatement.setString(1, "SUDAH SELESAI");
                updateStatement.setDate(2, new java.sql.Date(selectedDate.getTime()));
                updateStatement.setString(3, keterangan.getText());
                updateStatement.setString(4, idpengajuan.getText());
                updateStatement.executeUpdate();
                
                String updateApprovalQuery = "UPDATE approval SET aktif = ? WHERE id_pengajuan = ?";
                PreparedStatement updateApprovalStatement = conn.prepareStatement(updateApprovalQuery);
                updateApprovalStatement.setInt(1, 1); // Aktif = 1
                updateApprovalStatement.setString(2, idpengajuan.getText());
                updateApprovalStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                kosong();
                id.requestFocus();
                tabel();
                kode();
            } else {
                JOptionPane.showMessageDialog(null, "Pilih tanggal hari ini atau tanggal berikutnya.");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Tanggal belum dipilih.");
        }
    } catch (SQLException e) {
        JOptionPane.showMessageDialog(null, "Data gagal disimpan: " + e.getMessage());
        tabel();
    }
    }//GEN-LAST:event_saveActionPerformed

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new apps. menu_approval().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        kosong();
        tabel();
        kode();
    }//GEN-LAST:event_cancelActionPerformed

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        save.setEnabled(true);
        int baris = tabel.getSelectedRow();
        idpengajuan.setText(tabel.getModel().getValueAt(baris, 0).toString());
        idwarga.setText(tabel.getModel().getValueAt (baris,1).toString());
        namawarga.setText(tabel.getModel().getValueAt(baris, 2).toString());
        status.setText(tabel.getModel().getValueAt(baris, 3).toString());
        tanggal.setText(tabel.getModel().getValueAt(baris, 4).toString());
        masukan.setText(tabel.getModel().getValueAt(baris, 5).toString());
    }//GEN-LAST:event_tabelMouseClicked

    private void jLabel8MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel8MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new apps. menu_warga().setVisible(true);
    }//GEN-LAST:event_jLabel8MouseClicked

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
            java.util.logging.Logger.getLogger(feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(feedback.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new feedback().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JTextField id;
    private javax.swing.JTextField idpengajuan;
    private javax.swing.JTextField idwarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTextArea keterangan;
    private javax.swing.JTextArea masukan;
    private javax.swing.JTextField namawarga;
    private javax.swing.JButton save;
    private javax.swing.JTextField status;
    private javax.swing.JTable tabel;
    private javax.swing.JTextField tanggal;
    private com.toedter.calendar.JDateChooser tanggalapprove;
    // End of variables declaration//GEN-END:variables
}
