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
public class Co_SubDTO {
    private String co_sub_ID;
    private String cid;
    private String sub_id;

    public Co_SubDTO() {
    }

    public Co_SubDTO(String co_sub_ID, String cid, String sub_id) {
        this.co_sub_ID = co_sub_ID;
        this.cid = cid;
        this.sub_id = sub_id;
    }

    /**
     * @return the co_sub_ID
     */
    public String getCo_sub_ID() {
        return co_sub_ID;
    }

    /**
     * @param co_sub_ID the co_sub_ID to set
     */
    public void setCo_sub_ID(String co_sub_ID) {
        this.co_sub_ID = co_sub_ID;
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
    
    
}
