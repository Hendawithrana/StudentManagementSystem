/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.custom.ExamDetailBO;
import lk.ijse.StudentManagement.dao.custom.ExamDetailDAO;
import lk.ijse.StudentManagement.dao.custom.impl.ExamDetailDAOImpl;
import lk.ijse.StudentManagement.entity.Exam;
import lk.ijse.StudentManagement.entity.ExamDetail;
import lk.ijse.StudentManagement.model.ExamDetailDTO;

/**
 *
 * @author USER
 */
public class ExamDetailBOImpl implements ExamDetailBO{
    ExamDetailDAO detailDao=new ExamDetailDAOImpl();

    @Override
    public boolean saveExamDetail(ExamDetailDTO exam) throws Exception {
        return detailDao.save(new ExamDetail(exam.getEd_id(),exam.getEid(),exam.getCo_sub_id(),exam.getRid(),exam.getMarks()));
        
    }

    @Override
    public boolean updateExamDetail(ExamDetailDTO exam) throws Exception {
        return detailDao.update(new ExamDetail(exam.getEd_id(),exam.getEid(),exam.getCo_sub_id(),exam.getRid(),exam.getMarks()));
    }

    @Override
    public boolean deleteExamDetail(String eid) throws Exception {
        return detailDao.delete(eid);
    }

    @Override
    public ExamDetailDTO searchExamDetail(String id) throws Exception {
        ExamDetail eDetail=detailDao.search(id);
        return new ExamDetailDTO(eDetail.getEd_id(),eDetail.getEid(),eDetail.getCo_sub_id(),eDetail.getRid(),eDetail.getMarks());
    }

    @Override
    public ArrayList<ExamDetailDTO> getAllExamDetails() throws Exception {
        ArrayList<ExamDetail>exams=detailDao.getAll();
        ArrayList<ExamDetailDTO>edto=new ArrayList<>();
        for (ExamDetail exam : exams){
            edto.add(new ExamDetailDTO(exam.getEd_id(),exam.getEid(),exam.getCo_sub_id(),exam.getRid(),exam.getMarks()));
        }
        return edto;
    }

    @Override
    public ArrayList<String> getAllExamDetailIDS(String eid) throws Exception {
        ArrayList<ExamDetail>searchIDS=detailDao.getSearchExamIDS(eid);
        ArrayList<String>ids=new ArrayList<>();
        for (ExamDetail exam : searchIDS) {
            ids.add(exam.getEid());
        }
        return ids;
    }

    @Override
    public ArrayList<String> searchCO_SuIDS(String ID) throws Exception {
        ArrayList<ExamDetail>searchIDS=detailDao.getSearchIDS(ID);
        ArrayList<String>ids=new ArrayList<>();
        for (ExamDetail exam : searchIDS) {
            ids.add(exam.getCo_sub_id());
        }
        return ids;
    }


    

    @Override
    public ArrayList<String> getAllExamIDS(String text) throws Exception {
        ArrayList<ExamDetail>searchIDS=detailDao.getSearchExamIDS(text);
        ArrayList<String>ids=new ArrayList<>();
        for (ExamDetail exam : searchIDS) {
            ids.add(exam.getEid());
        }
        return ids;
    }

    @Override
    public ArrayList<ExamDetailDTO> getAllExamDetailsFromRID(String rid) throws Exception {
        ArrayList<ExamDetail>searchIDS=detailDao.getAllRegistration(rid);
        ArrayList<ExamDetailDTO>ids=new ArrayList<>();
        for (ExamDetail exam : searchIDS) {
            ids.add(new ExamDetailDTO(exam.getEd_id(),exam.getEid(),exam.getCo_sub_id(),exam.getRid(),exam.getMarks()));
        }
        return ids;
    }

}
