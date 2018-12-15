/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.dao.custom;

import java.util.ArrayList;
import lk.ijse.StudentManagement.dao.CrudDAO;
import lk.ijse.StudentManagement.entity.Co_Sub;

/**
 *
 * @author USER
 */
public interface Co_SubDAO extends CrudDAO<Co_Sub, String>{

    public ArrayList<Co_Sub> getSearchIDS(String id)throws Exception;

    public ArrayList<Co_Sub> getSearchSubJectIDS(String cos_Sub_ID) throws Exception;
    
}
