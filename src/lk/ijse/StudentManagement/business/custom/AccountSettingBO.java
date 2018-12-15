/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.SuperBO;
import lk.ijse.StudentManagement.model.LoginDTO;

/**
 *
 * @author USER
 */
public interface AccountSettingBO extends SuperBO{
    public boolean saveLogin(LoginDTO login)throws Exception;
    public boolean updateLogin(LoginDTO login)throws Exception;
    public boolean deleteLogin(String user)throws Exception;
    public LoginDTO searchLogin(String user)throws Exception;
    public ArrayList<LoginDTO>getAllLogins()throws Exception;
    public ArrayList<String>getAllLoginS()throws Exception;
}
