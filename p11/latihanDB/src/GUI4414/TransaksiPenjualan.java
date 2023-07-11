/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package GUI4414;

/**
 *
 * @MyAsus
 */

import com.mysql.cj.jdbc.Driver;
import javax.swing.JOptionPane;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;


public class TransaksiPenjualan extends javax.swing.JFrame {

    public static Connection konn;
    public static Statement stm;
    ResultSet rs;
    DefaultTableModel tabmod;
    String url;
    
    public TransaksiPenjualan() throws SQLException {
        initComponents();
        
        konn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a112113391","root","");
        stm = konn.createStatement();
        kembali.setText("Rp. "+0);
        grandtot.setText(""+0);
        diskon.setText(""+0);
        ppn.setText(""+0);
        totbayar.setText(""+0);
        tampiltempor();
        
        
    }
    private void tampiltempor() {
        try {
            tabmod = new DefaultTableModel();
            tabmod.addColumn("Kode");
            tabmod.addColumn("Nama Barang");
            tabmod.addColumn("Satuan");
            tabmod.addColumn("Jumlah");
            tabmod.addColumn("Harga");
            tabmod.addColumn("Total");
            jTable1.setModel(tabmod);
            
            String querytampiltem = "SELECT * FROM temporary_jual";
            ResultSet rs = stm.executeQuery(querytampiltem);
            
            while(rs.next()){
                tabmod.addRow(new Object[]{
                    rs.getString("kode_barang"),
                    rs.getString("nama_barang"),
                    rs.getString("satuan_barang"),
                    rs.getString("jumlah_barang"),
                    rs.getString("harga_barang"),
                    rs.getString("total_harga"),
                    
                }); 
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    private void hitungtotal() {
        try {
            rs = stm.executeQuery("SELECT sum(total_harga) as totalnya, sum(total_harga)*0.1 as ppn, (sum(total_harga)+sum(total_harga)*0.1) as total from temporary_jual");
            while(rs.next()){
                grandtot.setText(rs.getString("totalnya"));
                ppn.setText(rs.getString("ppn"));
                totbayar.setText(rs.getString("total"));
            }
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPenjualan.class.getName()).log(Level.SEVERE, null, ex);
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
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        tanggalfak = new javax.swing.JTextField();
        nofak = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        kodepel = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        namapel = new javax.swing.JTextField();
        kotapel = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        namabrg = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        kodebrg = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        satbrg = new javax.swing.JTextField();
        jmlbrg = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        hrgbrg = new javax.swing.JTextField();
        totbrg = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jPanel2 = new javax.swing.JPanel();
        kembali = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel18 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        grandtot = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        ppn = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        totbayar = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        diskon = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        bayar = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(new java.awt.Color(51, 0, 102));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Lucida Fax", 0, 36)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 255));
        jLabel1.setText("TRANSAKSI PENJUALAN");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 20, -1, -1));

        getContentPane().add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 637, 78));

        jPanel3.setBackground(new java.awt.Color(0, 51, 204));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(204, 255, 255));
        jLabel2.setForeground(new java.awt.Color(204, 255, 255));
        jLabel2.setText("Tanggal Jual");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 21, -1, -1));

        tanggalfak.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tanggalfakActionPerformed(evt);
            }
        });
        tanggalfak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tanggalfakKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tanggalfakKeyReleased(evt);
            }
        });
        jPanel3.add(tanggalfak, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 18, 151, -1));

        nofak.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                nofakFocusGained(evt);
            }
        });
        nofak.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                nofakKeyPressed(evt);
            }
        });
        jPanel3.add(nofak, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 46, 151, -1));

        jLabel3.setBackground(new java.awt.Color(204, 255, 255));
        jLabel3.setForeground(new java.awt.Color(204, 255, 255));
        jLabel3.setText("No. Faktur");
        jPanel3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(27, 49, -1, -1));

        kodepel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                kodepelFocusGained(evt);
            }
        });
        kodepel.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodepelKeyPressed(evt);
            }
        });
        jPanel3.add(kodepel, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 18, 153, -1));

        jLabel4.setBackground(new java.awt.Color(204, 255, 255));
        jLabel4.setForeground(new java.awt.Color(204, 255, 255));
        jLabel4.setText("Kode Pelanggan");
        jPanel3.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(336, 21, -1, -1));

        jLabel5.setBackground(new java.awt.Color(204, 255, 255));
        jLabel5.setForeground(new java.awt.Color(204, 255, 255));
        jLabel5.setText("Nama Pelanggan");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(331, 49, -1, -1));

        namapel.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                namapelFocusGained(evt);
            }
        });
        jPanel3.add(namapel, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 46, 153, -1));
        jPanel3.add(kotapel, new org.netbeans.lib.awtextra.AbsoluteConstraints(452, 74, 153, -1));

        jLabel6.setBackground(new java.awt.Color(204, 255, 255));
        jLabel6.setForeground(new java.awt.Color(204, 255, 255));
        jLabel6.setText("Kota");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(398, 77, -1, -1));

        getContentPane().add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 78, 637, 105));

        jPanel4.setBackground(new java.awt.Color(0, 102, 204));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel7.setText("Nama Barang");
        jPanel4.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 12, -1, -1));

        namabrg.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusGained(java.awt.event.FocusEvent evt) {
                namabrgFocusGained(evt);
            }
        });
        jPanel4.add(namabrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(101, 34, 133, -1));

        jLabel8.setText("Kode");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 12, 64, -1));

        kodebrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                kodebrgKeyPressed(evt);
            }
        });
        jPanel4.add(kodebrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(19, 34, 70, -1));

        jLabel9.setText("Satuan");
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 12, 64, -1));
        jPanel4.add(satbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(252, 34, 70, -1));

        jmlbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmlbrgActionPerformed(evt);
            }
        });
        jmlbrg.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jmlbrgKeyReleased(evt);
            }
        });
        jPanel4.add(jmlbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 34, 70, -1));

        jLabel10.setText("Jumlah");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(334, 12, 71, -1));

        jLabel11.setText("Harga");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 12, 71, -1));

        hrgbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                hrgbrgActionPerformed(evt);
            }
        });
        jPanel4.add(hrgbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(417, 34, 80, -1));

        totbrg.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totbrgActionPerformed(evt);
            }
        });
        jPanel4.add(totbrg, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 34, 93, -1));

        jLabel12.setText("Total");
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(506, 12, 71, -1));

        getContentPane().add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 183, 637, 71));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 255, 637, 170));

        jPanel2.setBackground(new java.awt.Color(0, 204, 255));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        kembali.setFont(new java.awt.Font("Segoe UI", 0, 36)); // NOI18N
        kembali.setText("0");
        kembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kembaliActionPerformed(evt);
            }
        });
        jPanel2.add(kembali, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 306, -1));

        jButton1.setText("New");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, -1, -1));

        jButton2.setText("Print");
        jPanel2.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 120, -1, -1));

        jButton5.setText("Exit >>");
        jPanel2.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 120, -1, -1));

        jButton6.setText("Delete");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, -1, -1));

        jLabel18.setText("Kembalian :");
        jPanel2.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, -1, -1));

        getContentPane().add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 419, 340, 170));

        jPanel5.setBackground(new java.awt.Color(0, 204, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setText("Grand Total");
        jPanel5.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 18, -1, -1));

        grandtot.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                grandtotActionPerformed(evt);
            }
        });
        jPanel5.add(grandtot, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 15, 108, -1));

        jLabel14.setText("PPN 10%");
        jPanel5.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 46, -1, -1));

        ppn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ppnActionPerformed(evt);
            }
        });
        jPanel5.add(ppn, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 43, 108, -1));

        jLabel15.setText("Diskon");
        jPanel5.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 74, -1, -1));

        totbayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                totbayarActionPerformed(evt);
            }
        });
        jPanel5.add(totbayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 99, 108, -1));

        jLabel16.setText("Total Bayar");
        jPanel5.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 102, -1, -1));

        diskon.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                diskonActionPerformed(evt);
            }
        });
        diskon.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                diskonKeyPressed(evt);
            }
        });
        jPanel5.add(diskon, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 71, 108, -1));

        jLabel17.setText("Bayar");
        jPanel5.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(6, 130, -1, -1));

        bayar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bayarActionPerformed(evt);
            }
        });
        bayar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bayarKeyPressed(evt);
            }
        });
        jPanel5.add(bayar, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 127, 108, -1));

        getContentPane().add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 420, 300, 170));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tanggalfakActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tanggalfakActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalfakActionPerformed

    private void jmlbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmlbrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmlbrgActionPerformed

    private void hrgbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_hrgbrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_hrgbrgActionPerformed

    private void totbrgActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totbrgActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totbrgActionPerformed

    private void kembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kembaliActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_kembaliActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton1ActionPerformed

    private void grandtotActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_grandtotActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_grandtotActionPerformed

    private void ppnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ppnActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_ppnActionPerformed

    private void totbayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_totbayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_totbayarActionPerformed

    private void diskonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_diskonActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_diskonActionPerformed

    private void bayarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bayarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_bayarActionPerformed

    private void kodepelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_kodepelFocusGained
        if(nofak.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Tidak Boleh Kosong");
            nofak.requestFocus();
        }
        
    }//GEN-LAST:event_kodepelFocusGained

    private void kodepelKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodepelKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            namapel.requestFocus();
        }else{
            
        }
    }//GEN-LAST:event_kodepelKeyPressed

    private void namapelFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namapelFocusGained
        String query = "SELECT * FROM pelanggan WHERE kode_pel ='"+kodepel.getText()+"'";
        if(kodepel.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Tidak Boleh Kosong");
            kodepel.requestFocus();
        }
        try {
            ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
                namapel.setText(rs.getString("nama_pel"));
                kotapel.setText(rs.getString("kota_pel"));
                kodebrg.requestFocus();
            }
            stm.executeQuery(query);
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_namapelFocusGained

    private void namabrgFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_namabrgFocusGained
        String querybrg = "SELECT * FROM stokbarang WHERE kd_brg ='"+kodebrg.getText()+"'";
        if(kodebrg.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Tidak Boleh Kosong");
            kodebrg.requestFocus();
        }
        try {
            ResultSet rs = stm.executeQuery(querybrg);
            while(rs.next()){
                kodebrg.setText(rs.getString("kd_brg"));
                namabrg.setText(rs.getString("nm_brg"));
                satbrg.setText(rs.getString("satuan"));
                jmlbrg.setText(rs.getString("jumlah"));
                hrgbrg.setText(rs.getString("harga"));
                jmlbrg.requestFocus();
            }
            stm.executeQuery(querybrg);
        } catch (SQLException ex) {
            Logger.getLogger(TransaksiPenjualan.class.getName()).log(Level.SEVERE, null, ex);
        }
    }//GEN-LAST:event_namabrgFocusGained

    private void kodebrgKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_kodebrgKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            namabrg.requestFocus();
        }else{
            
        }
    }//GEN-LAST:event_kodebrgKeyPressed

    private void jmlbrgKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jmlbrgKeyReleased
        if(jmlbrg.getText().equals("")){
            jmlbrg.setText(""+0);
        }
        if (evt.getKeyCode() == evt.VK_ENTER) {
            try {
                int jumlah = Integer.parseInt(jmlbrg.getText().toString());
                int harga = Integer.parseInt(hrgbrg.getText().toString());
                int totale = (jumlah * harga);
                totbrg.setText(Integer.toString(totale));
                //save ke table temporary
                Calendar cal= Calendar.getInstance();
                SimpleDateFormat tanggal = new SimpleDateFormat("yyyy-MM-dd");
                String tanggafak = tanggal.format(cal.getTime());
                jLabel1.setText(tanggafak);
                
                String querysavetemp = "insert into temporary_jual values"
                        + "('"+kodebrg.getText()+"',"
                        + "'"+namabrg.getText()+"',"
                        + "'"+satbrg.getText()+"',"
                        + "'"+Integer.parseInt(jmlbrg.getText())+"',"
                        + "'"+Integer.parseInt(hrgbrg.getText())+"',"
                        + "'"+Integer.parseInt(totbrg.getText())+"',"
                        + "'"+kodepel.getText()+"',"
                        + "'"+nofak.getText()+"',"
                        + "'"+ tanggalfak.getText() +"',"
                        + "'"+diskon.getText()+"',"
                        + "'"+namapel.getText()+"',"
                        + "'"+namapel.getText()+"',"
                        + "'"+kotapel.getText()+"',"
                        + "'"+Integer.parseInt(grandtot.getText())+"',"
                        + "'"+Integer.parseInt(totbayar.getText())+"')";
                
                stm.executeUpdate(querysavetemp);
                tampiltempor();
                hitungtotal();
                diskon.requestFocus();
            } catch (SQLException ex) {
                Logger.getLogger(TransaksiPenjualan.class.getName()).log(Level.SEVERE, null, ex);
            }
                    
            
            
        }
    }//GEN-LAST:event_jmlbrgKeyReleased

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton6ActionPerformed

    private void tanggalfakKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tanggalfakKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tanggalfakKeyReleased

    private void tanggalfakKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tanggalfakKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER){
            nofak.requestFocus();
        }else{
            
        }
    }//GEN-LAST:event_tanggalfakKeyPressed

    private void nofakKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nofakKeyPressed
        // TODO add your handling code here:
        if(evt.getKeyCode() == evt.VK_ENTER){
            kodepel.requestFocus();
        }else{
            
        }
    }//GEN-LAST:event_nofakKeyPressed

    private void nofakFocusGained(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_nofakFocusGained
        if(tanggalfak.getText().equals("")){
            JOptionPane.showMessageDialog(rootPane, "Tidak Boleh Kosong");
            tanggalfak.requestFocus();
        }
    }//GEN-LAST:event_nofakFocusGained

    private void diskonKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_diskonKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            hitungtotal();
            bayar.requestFocus();
        }else{
            
        }
    }//GEN-LAST:event_diskonKeyPressed

    private void bayarKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bayarKeyPressed
        if(evt.getKeyCode() == evt.VK_ENTER){
            int kembaliannya = Integer.parseInt(bayar.getText()) - Integer.parseInt(totbayar.getText());
            kembali.setText("Rp. "+kembaliannya);
            kodebrg.requestFocus();
        }else{
            
        }
    }//GEN-LAST:event_bayarKeyPressed

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
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TransaksiPenjualan.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    new TransaksiPenjualan().setVisible(true);
                } catch (SQLException ex) {
                    Logger.getLogger(TransaksiPenjualan.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField bayar;
    private javax.swing.JTextField diskon;
    private javax.swing.JTextField grandtot;
    private javax.swing.JTextField hrgbrg;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
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
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JTextField jmlbrg;
    private javax.swing.JTextField kembali;
    private javax.swing.JTextField kodebrg;
    private javax.swing.JTextField kodepel;
    private javax.swing.JTextField kotapel;
    private javax.swing.JTextField namabrg;
    private javax.swing.JTextField namapel;
    private javax.swing.JTextField nofak;
    private javax.swing.JTextField ppn;
    private javax.swing.JTextField satbrg;
    private javax.swing.JTextField tanggalfak;
    private javax.swing.JTextField totbayar;
    private javax.swing.JTextField totbrg;
    // End of variables declaration//GEN-END:variables



}
