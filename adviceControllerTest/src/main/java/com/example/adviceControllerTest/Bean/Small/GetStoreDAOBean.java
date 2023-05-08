package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.StoreDAO;
import com.example.adviceControllerTest.Model.DAO.UserDAO;
import com.example.adviceControllerTest.Repository.StoreDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetStoreDAOBean {
    @Autowired
    StoreDAORepository storeDAORepository;

    public StoreDAO exec(String userId) {
        return storeDAORepository.findStoreDAOByUserId(Long.parseLong(userId));
    }

    public StoreDAO exec(long storeId) {
        return storeDAORepository.findById(storeId).orElse(null);
    }

    public StoreDAO exec(UserDAO userDAO) {
        return storeDAORepository.findTopByUserId(userDAO.getUserId());
    }

}
