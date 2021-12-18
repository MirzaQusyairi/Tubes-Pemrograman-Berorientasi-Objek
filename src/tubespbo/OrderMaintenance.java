
package tubespbo;

import java.time.LocalDate;


public class OrderMaintenance {
    private int id, id_bts, id_user;
    private String problem, solution, notes, approval;
    private LocalDate finish_date;
    
    public OrderMaintenance(int id, int id_bts, int id_user, String problem, String solution, String notes, String approval, LocalDate finish_date){
        this.id = id;
        this.id_bts = id_bts;
        this.id_user = id_user;
        this.problem = problem;
        this.solution = solution;
        this.notes = notes;
        this.approval = approval;
        this.finish_date = finish_date;
    }
    
    public int getId(){
        return id;
    }
    
    public void setID(int id){
        this.id = id ;
    }
    
    public int getId_bts(){
        return id;
    }
    
    public void setId_bts(int id_bts){
        this.id_bts = id_bts ;
    }
    
    public String getProblem(){
        return problem ;
    }
    
    public void setProblem(String problem){
        this.problem = problem ;
    }
    
    public String getSolution(){
        return solution ;
    }
    
    public void setSolutiom(String solution){
        this.solution = solution ;
    }
    
    public String getNotes(){
        return notes ;
    }
    
    public void setNotes(String notes){
        this.notes = notes ;
    }
    
    public String getApproval(){
        return approval ;
    }
    
    public void setApproval(String approval){
        this.approval = approval ;
    }
    
    public LocalDate getfinish_date(){
        return finish_date;
    }
    
    public void set(LocalDate finish_date){
        this.finish_date = finish_date ;
    }
    
    
    
}
