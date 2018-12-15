/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.entity;

/**
 *
 * @author USER
 */
public class Result {
    private String rid;
    private String eid;
    private double marks;

    public Result() {
    }

    public Result(String rid, String eid, double marks) {
        this.rid = rid;
        this.eid = eid;
        this.marks = marks;
    }

    /**
     * @return the rid
     */
    public String getRid() {
        return rid;
    }

    /**
     * @param rid the rid to set
     */
    public void setRid(String rid) {
        this.rid = rid;
    }

    /**
     * @return the eid
     */
    public String getEid() {
        return eid;
    }

    /**
     * @param eid the eid to set
     */
    public void setEid(String eid) {
        this.eid = eid;
    }

    /**
     * @return the marks
     */
    public double getMarks() {
        return marks;
    }

    /**
     * @param marks the marks to set
     */
    public void setMarks(double marks) {
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Result{" + "rid=" + rid + ", eid=" + eid + ", marks=" + marks + '}';
    }
    
    
}
