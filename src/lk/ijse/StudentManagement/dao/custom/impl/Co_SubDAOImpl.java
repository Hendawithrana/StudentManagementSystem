/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.StudentManagement.dao.CrudUtil;
import lk.ijse.StudentManagement.dao.custom.Co_SubDAO;
import lk.ijse.StudentManagement.entity.Co_Sub;

/**
 *
 * @author USER
 */
public class Co_SubDAOImpl implements Co_SubDAO{

    @Override
    public boolean save(Co_Sub entity) throws Exception {
        return CrudUtil.executeUpdate("Insert Into Co_Sub values(?,?,?)", entity.getCo_sub_ID(),entity.getCid(),entity.getSub_id())>0;
    }

    @Override
    public boolean update(Co_Sub entity) throws Exception {
        return CrudUtil.executeUpdate("Update Co_Sub set cid=?,sub_id=? where Co_sub_Id=? ", entity.getCid(),entity.getSub_id(),entity.getCo_sub_ID())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from Co_Sub where id=? ", id)>0;
    }

    @Override
    public Co_Sub search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from Batch where bid=? ", id);
        if(rst.next()){
            return new Co_Sub(rst.getString("co_sub_id"),rst.getString("cid"),rst.getString("sub_id"));
        }else{
            return null;
        }

    }

    @Override
    public ArrayList<Co_Sub> getAll() throws Exception {
        ArrayList<Co_Sub>cosub=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * From co_sub");
        while(rst.next()){
            cosub.add(new Co_Sub(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return cosub;
    }


    @Override
    public ArrayList<Co_Sub> getSearchIDS(String id) throws Exception {
        ArrayList<Co_Sub>cosub=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * From co_sub where cid=? ",id);
        while(rst.next()){
            cosub.add(new Co_Sub(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return cosub;
    }

    @Override
    public ArrayList<Co_Sub> getSearchSubJectIDS(String cos_Sub_ID) throws Exception {
        ArrayList<Co_Sub>cosub=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * From co_sub where co_sub_id=? ",cos_Sub_ID);
        while(rst.next()){
            cosub.add(new Co_Sub(rst.getString(1),rst.getString(2),rst.getString(3)));
        }
        return cosub;
    }

    
    
}
