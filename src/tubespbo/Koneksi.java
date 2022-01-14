/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author Asus
 */
public class Koneksi {
    private String driver = "com.mysql.cj.jdbc.Driver";
    private String host = "jdbc:mysql://localhost:3306/db_maintenancebts";
    private String user = "root";
    private String pass = "";
    private Connection koneksi;

    /**
     * @return the koneksi
     */
    public Connection getKoneksi() {
        //Connect ke koneksi
        try {
            Class.forName(driver);
        }catch(ClassNotFoundException ce){
            JOptionPane.showMessageDialog(null, ce+"Gagal Connect ke driver");
        }
        
        //Connect ke database;
        try{
            koneksi = DriverManager.getConnection(host,user,pass);
        }catch(SQLException ce){
            JOptionPane.showMessageDialog(null, ce+"Gagal Connect ke database");
        }
        return koneksi;
    }

    /**
     * @param koneksi the koneksi to set
     */
    public void setKoneksi(Connection koneksi) {
        this.koneksi = koneksi;
    }
}
