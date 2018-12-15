/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.SuperBO;
import lk.ijse.StudentManagement.model.RegistrationDTO;

/**
 *
 * @author USER
 */
public interface RegistrationBO extends SuperBO{
    public boolean saveRegistration(RegistrationDTO registration)throws Exception;
    public boolean updateRegistration(RegistrationDTO registration)throws Exception;
    public boolean deleteRegistration(String rid)throws Exception;
    public RegistrationDTO searchRegistration(String rid)throws Exception;
    public ArrayList<RegistrationDTO>getAllRegistrations()throws Exception;
    public ArrayList<String>getAllRegistrationIDS()throws Exception;
}
