
package model;


public class Schedule {
    private int id, id_bts;
    private String date_schedule, status;
    
    public Schedule(int id, int id_bts, String date_schedule, String status){
        this.id = id;
        this.id_bts = id_bts;
        this.date_schedule = date_schedule;
        this.status = status;
    }

    public int getId(){
        return id ;
    }
    
    public void setId(int id){
        this.id = id ;
    }
    
    public int getId_bts(){
        return id_bts;
    }
    
    public void setId_bts(int id_bts){
        this.id_bts = id_bts ;
    }
    
    public String getDate_schedule(){
        return date_schedule;
    }
    
    public void setDate_schedule(String date_schedule){
        this.date_schedule = date_schedule;
    }
    
    public String getStatus(){
        return status ;
    }
    
    public void setStatus(String status){
        this.status = status ;
    }
    
}
