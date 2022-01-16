/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controller;

import model.BTS;
import model.User;
import model.Koneksi;
import model.Technician;
import model.Schedule;
import model.Checklist;
import model.OrderMaintenance;
import model.Merk_BTS;
import View.FormMainMenu;
import View.FormMainMenuTechnician;
import java.sql.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import view.*;

/**
 *
 * @author Asus
 */
public class Controller {
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
    
    public boolean tech_login(String username,String password) {
        try {
            Statement stmt2 = (Statement) kn.getKoneksi().createStatement();
            String sql = "SELECT * FROM technician WHERE username ='"+username+"' AND password='"+password+"'";
            ResultSet rs2 = stmt2.executeQuery(sql);
            if (rs2.next()){
                if (username.equals(rs2.getString("username")) && password.equals(rs2.getString("password"))){
                    Technician tech_info = new Technician(rs2.getInt("id"), rs2.getString("name"), rs2.getString("username"), rs2.getString("password"), rs2.getString("phone"), rs2.getString("team_name"));
                    JOptionPane.showMessageDialog(null,"Login Success");
                    new FormMainMenuTechnician(tech_info).setVisible(true);
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
    
    public void insert_bts(BTS b) {
        try {
            PreparedStatement stmt = kn.getKoneksi().prepareStatement("INSERT INTO bts(name,address,city,id_merkbts) VALUES (?,?,?,?)");            
            stmt.setString(1,b.getName());
            stmt.setString(2,b.getAddress());
            stmt.setString(3,b.getCity());
            stmt.setInt(4,b.getMerk().getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Insert BTS Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Insert BTS Failed");
        }
    }
    
    public void update_bts(BTS b){
        try {
            PreparedStatement stmt = kn.getKoneksi().prepareStatement("UPDATE bts set name=?,address=?,city=?,id_merkbts=? WHERE id=?");   
            stmt.setString(1,b.getName());
            stmt.setString(2,b.getAddress());
            stmt.setString(3,b.getCity());
            stmt.setInt(4,b.getMerk().getId());
            stmt.setString(5,b.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Technician Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Update Technician Failed");
        }
    }
    
    public void delete_bts(int id) {
        try {
            Statement stmt = (Statement) kn.getKoneksi().createStatement();
            String sql = "DELETE FROM bts WHERE id ='"+id+"'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Delete BTS Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Delete BTS Failed");
        }
    }
    
    public void insert_schedule(Schedule s) {
         try {
            PreparedStatement stmt = kn.getKoneksi().prepareStatement("INSERT INTO schedule(id_bts,date,status) VALUES (?,?,?)");            
            stmt.setString(1,s.getId_bts());
            stmt.setString(2,s.getDate_schedule());
            stmt.setString(3,s.getStatus());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Insert Schedule Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Insert Schedule Failed");
        }
    }
    
    public void update_schedule(Schedule s){
        try {
            PreparedStatement stmt = kn.getKoneksi().prepareStatement("UPDATE schedule set date=?,status=?,id_bts=? WHERE id=?");   
            stmt.setString(1,s.getDate_schedule());
            stmt.setString(2,s.getStatus());
            stmt.setString(3,s.getId_bts());
            stmt.setString(4,s.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Schedule Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Update Schedule Failed");
        }
    }
    
    public void delete_schedule(int id) {
        try {
            Statement stmt = (Statement) kn.getKoneksi().createStatement();
            String sql = "DELETE FROM schedule WHERE id ='"+id+"'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Delete Schedule Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Delete Schedule Failed");
        }
    }
 
    public List<BTS> getAllBTS() {
        List<BTS> bts = new ArrayList<BTS>();
        String sql = "SELECT * FROM bts INNER JOIN merk_bts ON merk_bts.id=bts.id_merkbts";
        try {
            if (kn.getKoneksi()==null){
                return null;
            }else{
                PreparedStatement statement = kn.getKoneksi().prepareStatement(sql);

                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    BTS b = new BTS(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            new Merk_BTS(rs.getInt(5),rs.getString(7))
                    );
                    bts.add(b);
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(BTS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return bts;
    }
    
    public List<Schedule> getAllSchedule() {
        List<Schedule> schedule = new ArrayList<Schedule>();
        String sql = "SELECT * FROM schedule";
        try {
            if (kn.getKoneksi()==null){
                return null;
            }else{
                PreparedStatement statement = kn.getKoneksi().prepareStatement(sql);

                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    Schedule s = new Schedule(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4)
                    );
                    schedule.add(s);                    
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(BTS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return schedule;
    }
    
    public List<Merk_BTS> getAllMerk() {
        List<Merk_BTS> merk_bts = new ArrayList<Merk_BTS>();
        String sql = "SELECT * FROM merk_bts";
        try {
            if (kn.getKoneksi()==null){
                return null;
            }else{
                PreparedStatement statement = kn.getKoneksi().prepareStatement(sql);

                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    Merk_BTS m = new Merk_BTS(
                            rs.getInt(1),
                            rs.getString(2)
                    );
                    merk_bts.add(m);
                }
                statement.close();
            }
        } catch (Exception ex) {
            
        }
        
        return merk_bts; 
    }
    
    public void insert_orderMaintenance(OrderMaintenance o) {
        try {
            PreparedStatement stmt = kn.getKoneksi().prepareStatement("INSERT INTO order_maintenance(id_user,id_bts,problem,solution,notes,finish_date) VALUES (?,?,?,?,?,?)");            
            stmt.setString(1,o.getId_user());
            stmt.setString(2,o.getId_bts());
            stmt.setString(3,o.getProblem());
            stmt.setString(4,o.getSolution());
            stmt.setString(5,o.getNotes());
            stmt.setString(6,o.getFinish_date());
            stmt.executeUpdate();
            System.out.println(o.getId_user());
            JOptionPane.showMessageDialog(null,"Insert Order Maintenance Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Insert Order Maintenance Failed");
        }
    }
    
    public void update_orderMaintenance(OrderMaintenance o){
        try {
            PreparedStatement stmt = kn.getKoneksi().prepareStatement("UPDATE order_maintenance set id_user = ?, id_bts = ?, problem = ?, solution = ?, notes = ?, finish_date = ? WHERE id=?");   
            stmt.setString(1,o.getId_user());
            stmt.setString(2,o.getId_bts());
            stmt.setString(3,o.getProblem());
            stmt.setString(4,o.getSolution());
            stmt.setString(5,o.getNotes());
            stmt.setString(6,o.getFinish_date());
            stmt.setString(7,o.getId());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Order Maintenance Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Update Order Maintenance Failed");
        }
    }
    
    public void delete_orderMaintenance(int id) {
        try {
            Statement stmt = (Statement) kn.getKoneksi().createStatement();
            String sql = "DELETE FROM order_maintenance WHERE id ='"+id+"'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Delete Order Maintenance Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Delete Order Maintenance Failed");
        }
    }

    
    public List<OrderMaintenance> getAllOrder() {
        List<OrderMaintenance> order = new ArrayList<OrderMaintenance>();
        String sql = "SELECT * FROM order_maintenance";
        try {
            if (kn.getKoneksi()==null){
                return null;
            }else{
                PreparedStatement statement = kn.getKoneksi().prepareStatement(sql);

                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    OrderMaintenance o = new OrderMaintenance(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7),
                            rs.getString(8)
                    );
                    order.add(o);
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(OrderMaintenance.class.getName()).log(Level.SEVERE, null, ex);
        }
        return order;
    }

    
    public void insert_checklist(Checklist c) {
        try {
            PreparedStatement stmt = kn.getKoneksi().prepareStatement("INSERT INTO checklist(id_maintenance,id_technician,battery,genset_fuel,grounding,date_check) VALUES (?,?,?,?,?,?)");            
            stmt.setString(1,c.getId_maintenance());
            stmt.setString(2,c.getId_technician());
            stmt.setString(3,c.getBattery());
            stmt.setString(4,c.getGenset_fuel());
            stmt.setString(5,c.getGrounding());
            stmt.setString(6,c.getDate_check());
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Insert checklist Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Insert checklist Failed");
        }
    }
    
    public void update_checklist(Checklist c){
        try {
            PreparedStatement stmt = kn.getKoneksi().prepareStatement("UPDATE checklist set battery=?,genset_fuel=?,grounding=?,date_check=? WHERE id=?");   
            stmt.setString(1,c.getBattery());
            stmt.setString(2,c.getGenset_fuel());
            stmt.setString(3,c.getGrounding());
            stmt.setString(4,c.getDate_check());
            stmt.setString(5,c.getId());            
            stmt.executeUpdate();
            JOptionPane.showMessageDialog(null,"Update Checklist Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Update Checklist Failed");
        }
    }
     
    public void delete_checklist(int id) {
        try {
            Statement stmt = (Statement) kn.getKoneksi().createStatement();
            String sql = "DELETE FROM checklist WHERE id ='"+id+"'";
            stmt.executeUpdate(sql);
            JOptionPane.showMessageDialog(null,"Delete Checklist Success");
        } catch (SQLException sqle) {
            System.out.println(sqle.getMessage());
            JOptionPane.showMessageDialog(null,"Delete Checklist Failed");
        }
    }
    
    public List<Checklist> getAllChecklist() {
        List<Checklist> checklist = new ArrayList<Checklist>();
        String sql = "SELECT * FROM checklist";
        try {
            if (kn.getKoneksi()==null){
                return null;
            }else{
                PreparedStatement statement = kn.getKoneksi().prepareStatement(sql);

                ResultSet rs = statement.executeQuery();
                while (rs.next()){
                    Checklist c = new Checklist(
                            rs.getString(1),
                            rs.getString(2),
                            rs.getString(3),
                            rs.getString(4),
                            rs.getString(5),
                            rs.getString(6),
                            rs.getString(7)

                    );
                    checklist.add(c);                    
                }
                statement.close();
            }
        } catch (Exception ex) {
            Logger.getLogger(BTS.class.getName()).log(Level.SEVERE, null, ex);
        }
        return checklist;
    }
    
}
