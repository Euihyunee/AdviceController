package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.StoreDAO;
import com.example.adviceControllerTest.Model.DAO.UserDAO;
import com.example.adviceControllerTest.Repository.StoreDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetStoreDAOsBean {
    @Autowired
    StoreDAORepository storeDAORepository;

    public List<StoreDAO> exec(UserDAO userDAO){
        return storeDAORepository.findAllByUserId(userDAO.getUserId());
    }
    public List<StoreDAO> exec(long userId){
        return storeDAORepository.findAllByUserId(userId);
    }

}
