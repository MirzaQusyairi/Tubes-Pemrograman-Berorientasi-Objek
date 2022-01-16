
package model;


public class Checklist {
    
    private int id, id_maintenance, id_technician;
    private String battery, genset_fuel, grounding, date_check;
    
    public Checklist(int id, int id_maintenance, int id_technician, String battery, String genset_fuel, String grounding, String date_check) {
        this.id = id;
        this.id_maintenance = id_maintenance;
        this.id_technician = id_technician;
        this.battery = battery;
        this.genset_fuel = genset_fuel;
        this.grounding = grounding;
        this.date_check = date_check;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_maintenance() {
        return id_maintenance;
    }

    public void setId_maintenance(int id_maintenance) {
        this.id_maintenance = id_maintenance;
    }

    public int getId_technician() {
        return id_technician;
    }

    public void setId_technician(int id_technician) {
        this.id_technician = id_technician;
    }

    public String getBattery() {
        return battery;
    }

    public void setBattery(String battery) {
        this.battery = battery;
    }

    public String getGenset_fuel() {
        return genset_fuel;
    }

    public void setGenset_fuel(String genset_fuel) {
        this.genset_fuel = genset_fuel;
    }

    public String getGrounding() {
        return grounding;
    }

    public void setGrounding(String grounding) {
        this.grounding = grounding;
    }

    public String getDate_check() {
        return date_check;
    }

    public void setDate_check(String date_check) {
        this.date_check = date_check;
    }
 
}
