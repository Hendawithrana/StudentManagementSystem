/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.custom.SubjectBO;
import lk.ijse.StudentManagement.dao.custom.SubjectDAO;
import lk.ijse.StudentManagement.dao.custom.impl.SubjectDAOImpl;
import lk.ijse.StudentManagement.entity.Subject;
import lk.ijse.StudentManagement.model.SubjectDTO;

/**
 *
 * @author USER
 */
public class SubjectBOImpl implements SubjectBO{
    
    SubjectDAO subjectDao=new SubjectDAOImpl();

    @Override
    public boolean saveSubject(SubjectDTO subject) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateSubject(SubjectDTO subject) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean deleteSubject(String sid) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public SubjectDTO searchSubject(String id) throws Exception {
        Subject subject=subjectDao.search(id);
        return new SubjectDTO(subject.getSub_id(),subject.getSu_name());
    }

    @Override
    public ArrayList<SubjectDTO> getAllSubjects() throws Exception {
        ArrayList<Subject>subjects=subjectDao.getAll();
        ArrayList<SubjectDTO>cdto=new ArrayList<>();
        for (Subject subject : subjects){
            cdto.add(new SubjectDTO(subject.getSub_id(),subject.getSu_name()));
        }
        return cdto;
    }

    @Override
    public ArrayList<String> getAllSubjectIDS() throws Exception {
        ArrayList<Subject>allIDS=subjectDao.getAll();
        ArrayList<String>subID=new ArrayList<>();
        for (Subject subject : allIDS) {
            subID.add(subject.getSub_id());
        }
        return subID;
    }
    
}
