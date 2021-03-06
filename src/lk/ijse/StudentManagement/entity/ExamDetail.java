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
public class ExamDetail {
    private String ed_id;
    private String eid;
    private String co_sub_id;
    private String rid;
    private double marks;

    public ExamDetail() {
    }

    public ExamDetail(String ed_id, String eid, String co_sub_id, String rid, double marks) {
        this.ed_id = ed_id;
        this.eid = eid;
        this.co_sub_id = co_sub_id;
        this.rid = rid;
        this.marks = marks;
    }

    /**
     * @return the ed_id
     */
    public String getEd_id() {
        return ed_id;
    }

    /**
     * @param ed_id the ed_id to set
     */
    public void setEd_id(String ed_id) {
        this.ed_id = ed_id;
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
     * @return the co_sub_id
     */
    public String getCo_sub_id() {
        return co_sub_id;
    }

    /**
     * @param co_sub_id the co_sub_id to set
     */
    public void setCo_sub_id(String co_sub_id) {
        this.co_sub_id = co_sub_id;
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
        return "ExamDetail{" + "ed_id=" + ed_id + ", eid=" + eid + ", co_sub_id=" + co_sub_id + ", rid=" + rid + ", marks=" + marks + '}';
    }

    
}
