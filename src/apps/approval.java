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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author FBS
 */
public class approval extends javax.swing.JFrame {
private DefaultTableModel data;
    Connection conn;
    Statement stm;
    ResultSet rs;
    apps.session session = new apps.session();
    /**
     * Creates new form approval
     */
    public approval() {
        initComponents();
        tabel();
        ImageIcon img = new ImageIcon("src/focon/logo.png");
        this.setIconImage(img.getImage());
        initUI();
        kosong();
        block();
        kode();
        idapprove.setVisible(false);
        idwarga.setVisible(false);
        idapprove.setText("" + session.getU_id());
        namaapproval.setText("" + session.getU_username());
    }
    
    protected void block(){
    idapproval.setEnabled(false);
    idwarga.setEnabled(false);
    idpengajuan.setEnabled(false);
    namawarga.setEnabled(false);
    masukan.setEnabled(false);
    namaapproval.setEnabled(false);
    }

     protected void kosong(){
        save.setEnabled(true);
        status.setSelectedItem(0);
        idwarga.setText("");
        idpengajuan.setText("");
        namawarga.setText("");
        idapprove.setText("");
        masukan.setText("");
        keterangan.setText("");
        namaapproval.setText("");
        tanggalapprove.setDate(null); 
    }
     
    public void kode() {
        try {
            String sql = "SELECT * FROM approval ORDER by id_approval desc";
            java.sql.Statement stat = conn.createStatement();
            ResultSet r = stat.executeQuery(sql);
            if (r.next()) {
                String nofak = r.getString("id_approval").substring(1);
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
               idapproval.setText("A" + Nol + AN);
            } else {
               idapproval.setText("A0001");
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
        Object header[]={"ID PERMOHONAN","ID WARGA","NAMA WARGA","KATEGORI","MASUKAN","STATUS","KELUARAN"};
        DefaultTableModel data=new DefaultTableModel(null,header);
        tabel.setModel(data);
        setKoneksi();
        String sql = "SELECT * FROM pengajuan WHERE status = 'SEDANG DIPROSES'";
        try {
            ResultSet rs=stm.executeQuery(sql);
            while (rs.next())
            {
                String kolom1=rs.getString("id");
                String kolom2=rs.getString("id_warga");
                String kolom3=rs.getString("nama_warga");
                String kolom4=rs.getString("kategori");
                String kolom5=rs.getString("masukan");
                String kolom6=rs.getString("status");
                String kolom7=rs.getString("keluaran");

                String kolom[]={kolom1,kolom2,kolom3,kolom4,kolom5,kolom6,kolom7};
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tabel = new javax.swing.JTable();
        idpengajuan = new javax.swing.JTextField();
        namawarga = new javax.swing.JTextField();
        status = new javax.swing.JComboBox<>();
        jScrollPane2 = new javax.swing.JScrollPane();
        keterangan = new javax.swing.JTextArea();
        save = new javax.swing.JButton();
        cancel = new javax.swing.JButton();
        idapproval = new javax.swing.JTextField();
        idapprove = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        masukan = new javax.swing.JTextArea();
        jLabel13 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        tanggalapprove = new com.toedter.calendar.JDateChooser();
        idwarga = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        namaapproval = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("APPROVAL");
        setUndecorated(true);
        setResizable(false);

        jPanel1.setPreferredSize(new java.awt.Dimension(950, 475));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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
        jPanel1.add(idpengajuan, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 40, 90, 30));
        jPanel1.add(namawarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 80, 370, 30));

        status.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "STATUS APPROVAL", "DISETUJUI", "DITOLAK" }));
        jPanel1.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 120, 370, 30));

        keterangan.setColumns(20);
        keterangan.setRows(5);
        jScrollPane2.setViewportView(keterangan);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 250, 370, 40));

        save.setIcon(new javax.swing.ImageIcon(getClass().getResource("/focon/save.png"))); // NOI18N
        save.setText("S I M P A N");
        save.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        save.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveActionPerformed(evt);
            }
        });
        jPanel1.add(save, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 210, 250, 30));

        cancel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/focon/refresh.png"))); // NOI18N
        cancel.setText("B A T A L");
        cancel.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        cancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cancelActionPerformed(evt);
            }
        });
        jPanel1.add(cancel, new org.netbeans.lib.awtextra.AbsoluteConstraints(660, 260, 250, 30));
        jPanel1.add(idapproval, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 40, 90, 30));
        jPanel1.add(idapprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 40, -1, 30));

        jLabel2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel2MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, 50, 50));

        jLabel9.setText("KETERANGAN *");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, -1, 30));

        jLabel10.setText("STATUS");
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 120, -1, 30));

        jLabel11.setText("NAMA WARGA");
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 80, -1, 30));

        jLabel12.setText("ID / NAMA APPROVAL");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 40, -1, 30));

        masukan.setColumns(20);
        masukan.setRows(5);
        jScrollPane3.setViewportView(masukan);

        jPanel1.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 200, 370, 40));

        jLabel13.setText("MASUKAN");
        jPanel1.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 200, -1, 30));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/focon/close.png"))); // NOI18N
        jLabel8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jLabel8.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel8MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 10, -1, -1));
        jPanel1.add(tanggalapprove, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 160, 370, 30));
        jPanel1.add(idwarga, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 40, 80, -1));

        jLabel3.setText("TANGGAL APPROVE");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 160, -1, 30));
        jPanel1.add(namaapproval, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 40, 170, 30));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/focon/MENU APPROVAL.png"))); // NOI18N
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

    private void jLabel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel2MouseClicked
        // TODO add your handling code here:
        this.setVisible(false);
        new apps. menu_approval().setVisible(true);
    }//GEN-LAST:event_jLabel2MouseClicked

    private void tabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelMouseClicked
        // TODO add your handling code here:
        save.setEnabled(true);
        int baris = tabel.getSelectedRow();
        idpengajuan.setText(tabel.getModel().getValueAt(baris, 0).toString());
        idwarga.setText(tabel.getModel().getValueAt(baris, 1).toString());
        namawarga.setText(tabel.getModel().getValueAt(baris, 2).toString());
        masukan.setText(tabel.getModel().getValueAt(baris, 3).toString());
    }//GEN-LAST:event_tabelMouseClicked

    private void cancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cancelActionPerformed
        // TODO add your handling code here:
        kosong();
        tabel();
        kode();
    }//GEN-LAST:event_cancelActionPerformed

    private void saveActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveActionPerformed
    String insertQuery = "INSERT INTO approval "
            + "(id_approval, "
            + "id_pengajuan, "
            + "id_approv, "
            + "id_warga, "
            + "nama_approv, "
            + "tanggal,"
            + "nama_warga, "
            + "status, "
            + "masukan, "
            + "keterangan, "
            + "aktif)"
            + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try {
        // Validasi tanggal yang dipilih
        java.util.Date selectedDate = tanggalapprove.getDate();
        if (selectedDate != null) {
            // Periksa apakah tanggal yang dipilih adalah hari ini atau berikutnya
            java.util.Date currentDate = new java.util.Date();
            if  (selectedDate.after(currentDate)) {
                // Eksekusi query INSERT
                PreparedStatement insertStatement = conn.prepareStatement(insertQuery);
                insertStatement.setString(1, idapproval.getText());
                insertStatement.setString(2, idpengajuan.getText());
                insertStatement.setString(3, idapprove.getText());
                insertStatement.setString(4, idwarga.getText());
                insertStatement.setString(5, namaapproval.getText());
                insertStatement.setDate(6, new java.sql.Date(selectedDate.getTime()));
                insertStatement.setString(7, namawarga.getText());
                insertStatement.setString(8, status.getSelectedItem().toString());
                insertStatement.setString(9, masukan.getText());
                insertStatement.setString(10, keterangan.getText());
                insertStatement.setString(11, "0");
                insertStatement.executeUpdate();

                // Setelah berhasil menyimpan data, perbarui status di tabel pengajuan
                String updateQuery = "UPDATE pengajuan SET status = ?, tanggal_approve = ?, keluaran = ? WHERE id = ?";
                PreparedStatement updateStatement = conn.prepareStatement(updateQuery);
                updateStatement.setString(1, status.getSelectedItem().toString());
                updateStatement.setDate(2, new java.sql.Date(selectedDate.getTime()));
                updateStatement.setString(3, keterangan.getText());
                updateStatement.setString(4, idpengajuan.getText());
                updateStatement.executeUpdate();

                JOptionPane.showMessageDialog(null, "Data berhasil disimpan");
                kosong();
                idapproval.requestFocus();
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
            java.util.logging.Logger.getLogger(approval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(approval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(approval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(approval.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new approval().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton cancel;
    private javax.swing.JTextField idapproval;
    private javax.swing.JTextField idapprove;
    private javax.swing.JTextField idpengajuan;
    private javax.swing.JTextField idwarga;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextArea keterangan;
    private javax.swing.JTextArea masukan;
    private javax.swing.JTextField namaapproval;
    private javax.swing.JTextField namawarga;
    private javax.swing.JButton save;
    private javax.swing.JComboBox<String> status;
    private javax.swing.JTable tabel;
    private com.toedter.calendar.JDateChooser tanggalapprove;
    // End of variables declaration//GEN-END:variables
}
