 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.StudentManagement.business.custom;

import java.util.ArrayList;
import lk.ijse.StudentManagement.business.SuperBO;
import lk.ijse.StudentManagement.model.BatchDTO;

/**
 *
 * @author USER
 */
public interface BatchBO extends SuperBO{
    public boolean saveBatch(BatchDTO batch)throws Exception;
    public boolean updateBatch(BatchDTO batch)throws Exception;
    public boolean deleteBatch(String bid)throws Exception;
    public BatchDTO searchBatch(String bid)throws Exception;
    public ArrayList<BatchDTO> getAllBatch()throws Exception;
    public ArrayList<String> getAllBatchIds()throws Exception;
}
