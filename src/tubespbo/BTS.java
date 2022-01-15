/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tubespbo;

/**
 *
 * @author COMPUTER
 */
public class BTS {
    private int id, id_merk;
    private String name, address, city;
    private Merk_BTS merk;

    public BTS(int id, String name, String address, String city, Merk_BTS merk) {
        this.id = id;
        this.merk = merk;
        this.name = name;
        this.address = address;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
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
    
    
}
