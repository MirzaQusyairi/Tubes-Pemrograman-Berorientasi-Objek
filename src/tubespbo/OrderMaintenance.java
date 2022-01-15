
package tubespbo;

import java.time.LocalDate;


public class OrderMaintenance {
    private String id, id_bts, id_user;
    private String problem, solution, notes, approval;
    private String finish_date;

    public OrderMaintenance(String id, String id_user, String id_bts,  String problem, String solution, String notes, String finish_date, String approval) {
        this.id = id;
        this.id_user = id_user;
        this.id_bts = id_bts;
        this.problem = problem;
        this.solution = solution;
        this.notes = notes;
        this.finish_date = finish_date;
        this.approval = approval;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId_bts() {
        return id_bts;
    }

    public void setId_bts(String id_bts) {
        this.id_bts = id_bts;
    }

    public String getId_user() {
        return id_user;
    }

    public void setId_user(String id_user) {
        this.id_user = id_user;
    }

    public String getProblem() {
        return problem;
    }

    public void setProblem(String problem) {
        this.problem = problem;
    }

    public String getSolution() {
        return solution;
    }

    public void setSolution(String solution) {
        this.solution = solution;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    public String getApproval() {
        return approval;
    }

    public void setApproval(String approval) {
        this.approval = approval;
    }

    public String getFinish_date() {
        return finish_date;
    }

    public void setFinish_date(String finish_date) {
        this.finish_date = finish_date;
    }
    
    
    
    
    
}
