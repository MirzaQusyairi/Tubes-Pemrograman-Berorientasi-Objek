/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author Asus
 */
public class Report {
    private OrderMaintenance order;
    private Checklist checklist;
    private Technician technician;
    private BTS bts;

    public Report(OrderMaintenance order, Checklist checklist, BTS bts, Technician technician) {
        this.order = order;
        this.checklist = checklist;
        this.technician = technician;
        this.bts = bts;
    }

    public OrderMaintenance getOrder() {
        return order;
    }

    public void setOrder(OrderMaintenance order) {
        this.order = order;
    }

    public Checklist getChecklist() {
        return checklist;
    }

    public void setChecklist(Checklist checklist) {
        this.checklist = checklist;
    }

    public Technician getTechnician() {
        return technician;
    }

    public void setTechnician(Technician technician) {
        this.technician = technician;
    }

    public BTS getBts() {
        return bts;
    }

    public void setBts(BTS bts) {
        this.bts = bts;
    }

    
    
    
}
