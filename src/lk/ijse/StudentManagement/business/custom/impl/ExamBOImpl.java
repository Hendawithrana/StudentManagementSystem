/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.custom.ExamBO;
import lk.ijse.StudentManagement.dao.custom.ExamDAO;
import lk.ijse.StudentManagement.dao.custom.ExamDetailDAO;
import lk.ijse.StudentManagement.dao.custom.impl.ExamDAOImpl;
import lk.ijse.StudentManagement.dao.custom.impl.ExamDetailDAOImpl;
import lk.ijse.StudentManagement.entity.Exam;
import lk.ijse.StudentManagement.model.ExamDTO;

/**
 *
 * @author USER
 */
public class ExamBOImpl implements ExamBO{
    
    ExamDAO examDao=new ExamDAOImpl();
    ExamDetailDAO detailDao=new ExamDetailDAOImpl();

    @Override
    public boolean saveExam(ExamDTO exam) throws Exception {
        return examDao.save(new Exam(exam.getEid(),exam.getE_name(),exam.getE_date(),exam.getStart_time(),exam.getEnd_time()));
    }

    @Override
    public boolean updateExam(ExamDTO exam) throws Exception {
        return examDao.update(new Exam(exam.getEid(),exam.getE_name(),exam.getE_date(),exam.getStart_time(),exam.getEnd_time()));
    }

    @Override
    public boolean deleteExam(String eid) throws Exception {
        return examDao.delete(eid);
    }

    @Override
    public ExamDTO searchExam(String id) throws Exception {
        Exam exam=examDao.search(id);
        return new ExamDTO(exam.getEid(),exam.getE_name(),exam.getE_date(),exam.getStart_time(),exam.getEnd_time());
    }

    @Override
    public ArrayList<ExamDTO> getAllExams() throws Exception {
        ArrayList<Exam>exams=examDao.getAll();
        ArrayList<ExamDTO>edto=new ArrayList<>();
        for (Exam exam : exams){
            edto.add(new ExamDTO(exam.getEid(),exam.getE_name(),exam.getE_date(),exam.getStart_time(),exam.getEnd_time()));
        }
        return edto;
    }

    @Override
    public ArrayList<String> getAllExamIDS() throws Exception {
        ArrayList<Exam>allIDS=examDao.getAll();
        ArrayList<String>eid=new ArrayList<>();
        for (Exam exam : allIDS) {
            eid.add(exam.getEid());
        }
        return eid;
    }

    
}
