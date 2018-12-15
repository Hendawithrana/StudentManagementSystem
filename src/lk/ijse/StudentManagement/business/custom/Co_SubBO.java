/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.SuperBO;
import lk.ijse.StudentManagement.model.Co_SubDTO;

/**
 *
 * @author USER
 */
public interface Co_SubBO extends SuperBO{
    public boolean saveCo_Sub(Co_SubDTO co_Sub)throws Exception;
    public boolean updateCo_Sub(Co_SubDTO co_Sub)throws Exception;
    public boolean deleteCo_Sub(String sub_Id)throws Exception;
    public Co_SubDTO searchCo_Sub(String sid)throws Exception;
    public ArrayList<Co_SubDTO>getCo_Subs()throws Exception;
    public ArrayList<String>getCo_SubsIDS()throws Exception;

    public ArrayList<Co_SubDTO> searchGetIdsSub() throws Exception;

    public ArrayList<String> searchGetIdsSub(String id) throws Exception;

    public ArrayList<String> serachSub_IDS(String cos_Sub_ID) throws Exception;
}
