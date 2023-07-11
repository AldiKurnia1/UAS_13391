/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI4414;

/**
 *
 * @author D2A_01
 */
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

public class KoneksiDB {
    public Connection konn;
    public Statement stm;
    public String usr;

    public KoneksiDB(String usr) {
        this.usr = usr;
        try {
            konn = DriverManager.getConnection("jdbc:mysql://localhost:3306/a112113391",
                    "root", "");
            stm = konn.createStatement();
            JOptionPane.showMessageDialog(null, "Koneksi Sukses Bang!");
        } catch (SQLException ex) {
            Logger.getLogger(KoneksiDB.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public Connection getKonn() {
        return konn;
    }
    
    public static void main(String[] args) {
        KoneksiDB conn = new KoneksiDB("root");
        
    }
    
}
