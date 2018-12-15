    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom.impl;

import java.sql.Connection;
import java.util.ArrayList;
import lk.ijse.StudentManagement.business.custom.CourseBO;
import lk.ijse.StudentManagement.dao.custom.Co_SubDAO;
import lk.ijse.StudentManagement.dao.custom.CourseDAO;
import lk.ijse.StudentManagement.dao.custom.impl.Co_SubDAOImpl;
import lk.ijse.StudentManagement.dao.custom.impl.CourseDAOImpl;
import lk.ijse.StudentManagement.db.DBConnection;
import lk.ijse.StudentManagement.entity.Co_Sub;
import lk.ijse.StudentManagement.entity.Course;
import lk.ijse.StudentManagement.model.CourseDTO;

/**
 *
 * @author USER
 */
public class CourseBOImpl implements CourseBO{
    CourseDAO courseDAO=new CourseDAOImpl();
    Co_SubDAO cosDao=new Co_SubDAOImpl();
    @Override
    public boolean saveCourse(CourseDTO course) throws Exception {
        Connection connection=DBConnection.getInstacne().getConnection();
        connection.setAutoCommit(false);
        try{
            boolean result=courseDAO.save(new Course(course.getCid(),course.getName(),course.getDuration(),course.getFee()));
            if(!result){
                return false;
            }
            result=cosDao.save(new Co_Sub(course.getCoSub().getCo_sub_ID(),course.getCoSub().getCid(),course.getCoSub().getSub_id()));
            if(!result){
                connection.rollback();
                return false;
            }
            connection.commit();
            return true;
        }finally{
            connection.setAutoCommit(true);
        }

    }

    @Override
    public boolean updateCourse(CourseDTO course) throws Exception {
        return courseDAO.update(new Course(course.getCid(),course.getName(),course.getDuration(),course.getFee()));
//        Connection connection=DBConnection.getInstacne().getConnection();
//        connection.setAutoCommit(false);
//        try{
//            boolean result=courseDAO.update(new Course(course.getCid(),course.getName(),course.getDuration(),course.getFee()));
//            if(!result){
//                return false;
//            }
//            result=cosDao.update(new Co_Sub(course.getCoSub().getCo_sub_ID(),course.getCoSub().getCid(),course.getCoSub().getSub_id()));
//            if(!result){
//                connection.rollback();
//                return false;
//            }
//            connection.commit();
//            return true;
//        }finally{
//            connection.setAutoCommit(true);
//        }
    }

    @Override
    public boolean deleteCourse(String cid) throws Exception {
       return courseDAO.delete(cid);
    }

    @Override
    public CourseDTO searchCourse(String id) throws Exception {
        Course course=courseDAO.search(id);
        return new CourseDTO(course.getCid(),course.getName(),course.getDuration(),course.getFee(),null);
    }

    @Override
    public ArrayList<CourseDTO> getAllCourses() throws Exception {
        ArrayList<Course>courses=courseDAO.getAll();
        ArrayList<CourseDTO>cdto=new ArrayList<>();
        for (Course course : courses){
            cdto.add(new CourseDTO(course.getCid(),course.getName(),course.getDuration(),course.getFee(),null));
        }
        return cdto;
    }

    @Override
    public ArrayList<String> getAllCourseIDS() throws Exception {
        ArrayList<Course>courseIDs=courseDAO.getAll();
        ArrayList<String>id=new ArrayList<>();
        for (Course course : courseIDs) {
            id.add(course.getCid());
        }
        return id;
    }
    
}
