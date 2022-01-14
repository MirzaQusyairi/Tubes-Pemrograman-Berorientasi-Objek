/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import View.FormMainMenu;
import java.sql.*;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
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
    
    public void insert_technician(String name, String phone, String teamname, String username, String password) {
        try {
            PreparedStatement stmt = kn.getKoneksi().prepareStatement("INSERT INTO technician(name,username,password,phone,team_name) VALUES (?,?,?,?,?)");            
            stmt.setString(1,name);
            stmt.setString(2,username);
            stmt.setString(3,password);
            stmt.setString(4,phone);
            stmt.setString(5,teamname);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Insert Technician Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Insert Technician Failed");
        }
    }
    
    public void update_technician(String id, String name, String phone, String teamname, String username, String password){
        try {
            PreparedStatement stmt = kn.getKoneksi().prepareStatement("UPDATE technician set name=?,username=?,password=?,phone=?,team_name=? WHERE id=?");   
            stmt.setString(1,name);
            stmt.setString(2,username);
            stmt.setString(3,password);
            stmt.setString(4,phone);
            stmt.setString(5,teamname);
            stmt.setString(6,id);
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Technician Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Update Technician Failed");
        }
    }
    
    public void delete_technician(int id) {
        try {
            Statement stmt = (Statement) kn.getKoneksi().createStatement();
            String sql = "DELETE FROM technician WHERE id ='"+id+"'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Delete Technician Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Delete Technician Failed");
        }
    }
    
    public void display_technician(JTable JT) {
        try{
            DefaultTableModel tblModel = (DefaultTableModel) JT.getModel();
            tblModel.setRowCount(0);
            Statement stmt = (Statement) kn.getKoneksi().createStatement();
            String sql = "SELECT * FROM technician";
            ResultSet rs = stmt.executeQuery(sql);
            
            while(rs.next()){
                String id = String.valueOf(rs.getInt("id"));
                String name = rs.getString("name");
                String username = rs.getString("username");
                String password = rs.getString("password");
                String phone = rs.getString("phone");
                String teamname = rs.getString("team_name");
                String tbData[] = {id,name,username,password,phone,teamname};
                tblModel.addRow(tbData);
            }
            
        }catch(SQLException sqle){
            System.out.println(sqle);
        }
    }
}
