/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom.impl;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.custom.BatchBO;
import lk.ijse.StudentManagement.dao.custom.BatchDAO;
import lk.ijse.StudentManagement.dao.custom.impl.BatchDAOImpl;
import lk.ijse.StudentManagement.entity.Batch;
import lk.ijse.StudentManagement.model.BatchDTO;

/**
 *
 * @author USER
 */
public class BatchBOImpl implements BatchBO{
    BatchDAO batchDAO=new BatchDAOImpl();

    @Override
    public boolean saveBatch(BatchDTO batch) throws Exception {
        return batchDAO.save(new Batch(batch.getBid(),batch.getCid(),batch.getNum(),batch.getDate(),batch.getTime()));
    }

    @Override
    public boolean updateBatch(BatchDTO batch) throws Exception {
        return batchDAO.update(new Batch(batch.getBid(),batch.getCid(),batch.getNum(),batch.getDate(),batch.getTime()));
    }

    @Override
    public boolean deleteBatch(String bid) throws Exception {
        return batchDAO.delete(bid);
    }

    @Override
    public BatchDTO searchBatch(String bid) throws Exception {
        Batch batch=batchDAO.search(bid);
        return new BatchDTO(batch.getBid(),batch.getCid(),batch.getB_no(),batch.getB_date(),batch.getB_Time());
    }

    @Override
    public ArrayList<BatchDTO> getAllBatch() throws Exception {
        ArrayList<Batch>batches=batchDAO.getAll();
        ArrayList<BatchDTO>bdto=new ArrayList<>();
        for (Batch batch : batches) {
            bdto.add(new BatchDTO(batch.getBid(),batch.getCid(),batch.getB_no(),batch.getB_date(),batch.getB_Time()));
        }
        return bdto;
    }

    @Override
    public ArrayList<String> getAllBatchIds() throws Exception {
        ArrayList<Batch>batchIDs=batchDAO.getAll();
        ArrayList<String>id=new ArrayList<>();
        for (Batch batch : batchIDs) {
            id.add(batch.getBid());
        }
        return id;
    }
    
}
