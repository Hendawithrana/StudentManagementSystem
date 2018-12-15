/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.custom.Co_SubBO;
import lk.ijse.StudentManagement.dao.custom.Co_SubDAO;
import lk.ijse.StudentManagement.dao.custom.impl.Co_SubDAOImpl;
import lk.ijse.StudentManagement.entity.Co_Sub;
import lk.ijse.StudentManagement.model.Co_SubDTO;

/**
 *
 * @author USER
 */
public class Co_SubBOImpl implements Co_SubBO{
    
    Co_SubDAO coSubDao=new Co_SubDAOImpl();

    @Override
    public boolean saveCo_Sub(Co_SubDTO co_Sub) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateCo_Sub(Co_SubDTO co_Sub) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteCo_Sub(String sub_Id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Co_SubDTO searchCo_Sub(String sid) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<Co_SubDTO> getCo_Subs() throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> getCo_SubsIDS() throws Exception {
        ArrayList<Co_Sub>coSubIDS=coSubDao.getAll();
        ArrayList<String>id=new ArrayList<>();
        for (Co_Sub cos : coSubIDS) {
            id.add(cos.getCo_sub_ID());
        }
        return id;
    }

    @Override
    public ArrayList<Co_SubDTO> searchGetIdsSub() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ArrayList<String> searchGetIdsSub(String id) throws Exception {
        ArrayList<Co_Sub>searchIDS=coSubDao.getSearchIDS(id);
        ArrayList<String>ids=new ArrayList<>();
        for (Co_Sub cos : searchIDS) {
            ids.add(cos.getCo_sub_ID());
        }
        return ids;
    }

    @Override
    public ArrayList<String> serachSub_IDS(String cos_Sub_ID) throws Exception{
        ArrayList<Co_Sub>searchIDS=coSubDao.getSearchSubJectIDS(cos_Sub_ID);
        ArrayList<String>ids=new ArrayList<>();
        for (Co_Sub cos : searchIDS) {
            ids.add(cos.getSub_id());
        }
        return ids;
    }

    
    
}
