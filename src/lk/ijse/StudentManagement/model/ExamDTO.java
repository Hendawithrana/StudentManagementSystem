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
public class ExamDTO {
    private String eid;
    private String e_name;
    private String e_date;
    private String start_time;
    private String end_time;

    public ExamDTO() {
    }

    public ExamDTO(String eid, String e_name, String e_date, String start_time, String end_time) {
        this.eid = eid;
        this.e_name = e_name;
        this.e_date = e_date;
        this.start_time = start_time;
        this.end_time = end_time;
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
     * @return the e_name
     */
    public String getE_name() {
        return e_name;
    }

    /**
     * @param e_name the e_name to set
     */
    public void setE_name(String e_name) {
        this.e_name = e_name;
    }

    /**
     * @return the e_date
     */
    public String getE_date() {
        return e_date;
    }

    /**
     * @param e_date the e_date to set
     */
    public void setE_date(String e_date) {
        this.e_date = e_date;
    }

    /**
     * @return the start_time
     */
    public String getStart_time() {
        return start_time;
    }

    /**
     * @param start_time the start_time to set
     */
    public void setStart_time(String start_time) {
        this.start_time = start_time;
    }

    /**
     * @return the end_time
     */
    public String getEnd_time() {
        return end_time;
    }

    /**
     * @param end_time the end_time to set
     */
    public void setEnd_time(String end_time) {
        this.end_time = end_time;
    }

    
}
