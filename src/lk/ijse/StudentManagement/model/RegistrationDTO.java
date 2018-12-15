/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.model;

/**
 *
 * @author USER
 */
public class RegistrationDTO {
    private String rid;
    private String sid;
    private String bid;
    private String pid;
    private String reg_date;
    private double reg_fee;

    public RegistrationDTO() {
    }

    public RegistrationDTO(String rid, String sid, String bid, String pid, String reg_date, double reg_fee) {
        this.rid = rid;
        this.sid = sid;
        this.bid = bid;
        this.pid = pid;
        this.reg_date = reg_date;
        this.reg_fee = reg_fee;
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
     * @return the sid
     */
    public String getSid() {
        return sid;
    }

    /**
     * @param sid the sid to set
     */
    public void setSid(String sid) {
        this.sid = sid;
    }

    /**
     * @return the bid
     */
    public String getBid() {
        return bid;
    }

    /**
     * @param bid the bid to set
     */
    public void setBid(String bid) {
        this.bid = bid;
    }

    /**
     * @return the pid
     */
    public String getPid() {
        return pid;
    }

    /**
     * @param pid the pid to set
     */
    public void setPid(String pid) {
        this.pid = pid;
    }

    /**
     * @return the reg_date
     */
    public String getReg_date() {
        return reg_date;
    }

    /**
     * @param reg_date the reg_date to set
     */
    public void setReg_date(String reg_date) {
        this.reg_date = reg_date;
    }

    /**
     * @return the reg_fee
     */
    public double getReg_fee() {
        return reg_fee;
    }

    /**
     * @param reg_fee the reg_fee to set
     */
    public void setReg_fee(double reg_fee) {
        this.reg_fee = reg_fee;
    }

    
}
