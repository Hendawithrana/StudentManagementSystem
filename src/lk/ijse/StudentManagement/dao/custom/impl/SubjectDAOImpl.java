/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.StudentManagement.dao.CrudUtil;
import lk.ijse.StudentManagement.dao.custom.SubjectDAO;
import lk.ijse.StudentManagement.entity.Subject;

/**
 *
 * @author USER
 */
public class SubjectDAOImpl implements SubjectDAO{

    @Override
    public boolean save(Subject entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(Subject entity) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String id) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Subject search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from Subject where sub_id=? ", id);
        if(rst.next()){
            return new Subject(rst.getString(1),rst.getString(2));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Subject> getAll() throws Exception {
        ArrayList<Subject>sub=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * From Subject");
        while(rst.next()){
            sub.add(new Subject(rst.getString(1),rst.getString(2)));
        }
        return sub;
    }
    
}
