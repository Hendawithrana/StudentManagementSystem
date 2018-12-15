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
public class SubjectDTO {
    private String sub_id;
    private String su_name;

    public SubjectDTO() {
    }

    public SubjectDTO(String sub_id, String su_name) {
        this.sub_id = sub_id;
        this.su_name = su_name;
    }

    /**
     * @return the sub_id
     */
    public String getSub_id() {
        return sub_id;
    }

    /**
     * @param sub_id the sub_id to set
     */
    public void setSub_id(String sub_id) {
        this.sub_id = sub_id;
    }

    /**
     * @return the su_name
     */
    public String getSu_name() {
        return su_name;
    }

    /**
     * @param su_name the su_name to set
     */
    public void setSu_name(String su_name) {
        this.su_name = su_name;
    }
    
    
}
