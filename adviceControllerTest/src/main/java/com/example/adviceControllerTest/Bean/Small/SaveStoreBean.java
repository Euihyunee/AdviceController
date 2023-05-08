package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.StoreDAO;
import com.example.adviceControllerTest.Repository.StoreDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveStoreBean {
    @Autowired
    StoreDAORepository storeDAORepository;
    public void exec(StoreDAO storeDAO){
        storeDAORepository.save(storeDAO);

    }
}
