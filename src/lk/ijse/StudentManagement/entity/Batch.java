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
public class Batch {
    private String bid;
    private String cid;
    private int b_no;
    private String b_date;
    private String b_Time;

    public Batch() {
    }

    public Batch(String bid, String cid, int b_no, String b_date, String b_Time) {
        this.bid = bid;
        this.cid = cid;
        this.b_no = b_no;
        this.b_date = b_date;
        this.b_Time = b_Time;
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
     * @return the cid
     */
    public String getCid() {
        return cid;
    }

    /**
     * @param cid the cid to set
     */
    public void setCid(String cid) {
        this.cid = cid;
    }

    /**
     * @return the b_no
     */
    public int getB_no() {
        return b_no;
    }

    /**
     * @param b_no the b_no to set
     */
    public void setB_no(int b_no) {
        this.b_no = b_no;
    }

    /**
     * @return the b_date
     */
    public String getB_date() {
        return b_date;
    }

    /**
     * @param b_date the b_date to set
     */
    public void setB_date(String b_date) {
        this.b_date = b_date;
    }

    /**
     * @return the b_Time
     */
    public String getB_Time() {
        return b_Time;
    }

    /**
     * @param b_Time the b_Time to set
     */
    public void setB_Time(String b_Time) {
        this.b_Time = b_Time;
    }

    @Override
    public String toString() {
        return "Batch{" + "bid=" + bid + ", cid=" + cid + ", b_no=" + b_no + ", b_date=" + b_date + ", b_Time=" + b_Time + '}';
    }

    
    
}
