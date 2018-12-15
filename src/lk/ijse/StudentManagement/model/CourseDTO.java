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
public class CourseDTO {
    private String cid;
    private String name;
    private String duration;
    private double fee;
    private Co_SubDTO coSub;

    public CourseDTO() {
    }

    public CourseDTO(String cid, String name, String duration, double fee, Co_SubDTO coSub) {
        this.cid = cid;
        this.name = name;
        this.duration = duration;
        this.fee = fee;
        this.coSub = coSub;
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
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the duration
     */
    public String getDuration() {
        return duration;
    }

    /**
     * @param duration the duration to set
     */
    public void setDuration(String duration) {
        this.duration = duration;
    }

    /**
     * @return the fee
     */
    public double getFee() {
        return fee;
    }

    /**
     * @param fee the fee to set
     */
    public void setFee(double fee) {
        this.fee = fee;
    }

    /**
     * @return the coSub
     */
    public Co_SubDTO getCoSub() {
        return coSub;
    }

    /**
     * @param coSub the coSub to set
     */
    public void setCoSub(Co_SubDTO coSub) {
        this.coSub = coSub;
    }
    

    
}
