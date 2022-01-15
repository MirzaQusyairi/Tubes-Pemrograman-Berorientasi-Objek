/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author COMPUTER
 */
public class BTS {
    private String id, name, address, city;
    private Merk_BTS merk;

    public BTS(String id, String name, String address, String city, Merk_BTS merk) {
        this.id = id;
        this.merk = merk;
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

//    public int getId_merk() {
//        return id_merk;
//    }
//
//    public void setId_merk(int id_merk) {
//        this.id_merk = id_merk;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Merk_BTS getMerk() {
        return merk;
    }

    public void setMerk(Merk_BTS merk) {
        this.merk = merk;
    }

    public Object getId_User() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
