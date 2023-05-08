package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DAO.StoragePasswordDAO;
import com.example.adviceControllerTest.Repository.StoragePasswordDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetStoragePasswordDAOBean {
    @Autowired
    StoragePasswordDAORepository storagePasswordRepository;

    public StoragePasswordDAO exec(long storeId) {


        return null;
    }

    public StoragePasswordDAO exec(StorageDAO storageDAO) {
        return storagePasswordRepository.findById(storageDAO.getStoragePasswordId()).get();
    }
}
