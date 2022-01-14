/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.FormMainMenu;
import java.sql.*;
import javax.swing.JOptionPane;
import tubespbo.*;
import view.*;

/**
 *
 * @author Asus
 */
public class Model {
    Koneksi kn = new Koneksi();
    Connection kon = kn.getKoneksi();
    
    
    public boolean user_login(String username,String password) {
        try {
            Statement stmt = (Statement) kn.getKoneksi().createStatement();
            String sql = "SELECT * FROM user WHERE username ='"+username+"' AND password='"+password+"'";
            ResultSet rs = stmt.executeQuery(sql);
            if (rs.next()){
                if (username.equals(rs.getString("username")) && password.equals(rs.getString("password"))){
                    User user_info = new User(rs.getInt("id"), rs.getString("name"), rs.getString("username"), rs.getString("password"), rs.getString("phone"), rs.getString("position"));
                    JOptionPane.showMessageDialog(null,"Login Success");
                    new FormMainMenu(user_info).setVisible(true);
                    return true;
                }
            } else {
                JOptionPane.showMessageDialog(null,"Username or Password wrong");
                return false;
            }
        } catch (SQLException sqle) {
            JOptionPane.showMessageDialog(null,sqle.getMessage());
            return false;
        }
        return false;
    }
}
