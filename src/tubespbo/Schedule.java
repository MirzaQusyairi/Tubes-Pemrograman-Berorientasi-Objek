
package tubespbo;

import java.time.LocalDate;


public class Schedule {
    private String id;
    private String id_bts;
    private String date_schedule;
    private String status;
    
    public Schedule(String id, String id_bts, String date_schedule, String status){
        this.id = id;
        this.id_bts = id_bts;
        this.date_schedule = date_schedule;
        this.status = status;
        
    }

    public Schedule(String string, String string0, String string1) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getId(){
        return id ;
    }
    
    public void setId(String id){
        this.id = id ;
    }
    
    public String getId_bts(){
        return id_bts;
    }
    
    public void setId_bts(String id_bts){
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
