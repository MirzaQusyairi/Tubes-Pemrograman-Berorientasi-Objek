
package model;


public class Checklist {
    private int id, id_bts;
    private String team_name, battery, genset_fuel, grounding, date_check;
    
    public Checklist(int id, int id_bts, String team_name, String battery, String genset_fuel, String grounding, String date_check ){
        this.id = id;
        this.id_bts = id_bts;
        this.team_name = team_name;
        this.battery = battery;
        this.genset_fuel = genset_fuel;
        this.grounding = grounding;
        this.date_check = date_check;
        
    }
    
    public int getID(){
       return id; 
    }
    
    public void setID(int id){
        this.id = id;
    }
    
    public int getId_bts(){
        return id_bts;
    }
    
    public void setID_bts(int id_bts){
        this.id_bts = id_bts;
    }
    
    public String getTeam_name(){
        return team_name;
    }
    
    public void setTeam_name(String team_name){
        this.team_name = team_name;
    }
    
    public String getBattery(){
        return battery;
    }
    
    public void setBattery(String battery){
        this.battery = battery;
    }
    
    public String getGenset_fuel(){
        return genset_fuel;
    }
    
    public void setGenset_fuel(String genset_fuel){
        this.genset_fuel = genset_fuel;
    }
    
    public String getGrounding(){
        return grounding;
    }
    
    public void setGrounding(){
        this.grounding = grounding;
    }
    
    public String getDate_check(){
        return date_check;
    }
    
    public void setDate_check(String date_check){
        this.date_check = date_check;
    }
    
    
}
