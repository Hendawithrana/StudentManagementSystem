/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.dao.custom.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import lk.ijse.StudentManagement.dao.CrudUtil;
import lk.ijse.StudentManagement.dao.custom.RegistrationDAO;
import lk.ijse.StudentManagement.entity.Registration;

/**
 *
 * @author USER
 */
public class RegistrationDAOImpl implements RegistrationDAO{

    @Override
    public boolean save(Registration registration) throws Exception {
        return CrudUtil.executeUpdate("Insert into registration values(?,?,?,?,?,?) ", registration.getRid(),registration.getSid(),registration.getBid(),registration.getPid(),registration.getReg_date(),registration.getReg_fee())>0;
    }

    @Override
    public boolean update(Registration rsgistration) throws Exception {
        return CrudUtil.executeUpdate("Update Registration set sid=?,cid=?,pid=? reg_date=?,reg_fee=? where rid=? ", rsgistration.getSid(),rsgistration.getBid(),rsgistration.getPid(),rsgistration.getReg_date(),rsgistration.getReg_fee(),rsgistration.getRid())>0;
    }

    @Override
    public boolean delete(String id) throws Exception {
        return CrudUtil.executeUpdate("Delete from Registration where sid=? ", id)>0;
    }

    @Override
    public Registration search(String id) throws Exception {
        ResultSet rst=CrudUtil.executeQuery("Select * from Registration where sid=? ", id);
        if(rst.next()){
            return new Registration(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getDouble(6));
        }else{
            return null;
        }
    }

    @Override
    public ArrayList<Registration> getAll() throws Exception {
       ArrayList<Registration>register=new ArrayList<>();
        ResultSet rst=CrudUtil.executeQuery("Select * From registration");
        while(rst.next()){
            register.add(new Registration(rst.getString(1),rst.getString(2),rst.getString(3),rst.getString(4),rst.getString(5),rst.getDouble(6)));
        }
        return register;
    }
    
}
