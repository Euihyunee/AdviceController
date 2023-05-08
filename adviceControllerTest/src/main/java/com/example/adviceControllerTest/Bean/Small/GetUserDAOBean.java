package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.UserDAO;
import com.example.adviceControllerTest.Model.DTO.RequestMakeOrderDTO;
import com.example.adviceControllerTest.Model.DTO.RequestStoreDTO;
import com.example.adviceControllerTest.Repository.UserDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetUserDAOBean {
    @Autowired
    UserDAORepository userDAORepository;
    public UserDAO exec(long userId) {
        Optional<UserDAO> userDAO = userDAORepository.findById(userId);

        return userDAO.orElse(null);
    }

    public UserDAO exec(RequestMakeOrderDTO requestMakeOrderDTO) {
        Optional<UserDAO> userDAO = userDAORepository.findById(requestMakeOrderDTO.getUserId());

        return userDAO.orElse(null);
    }

    public UserDAO exec(RequestStoreDTO requestStoreDTO) {
        Optional<UserDAO> userDAO = userDAORepository.findById(requestStoreDTO.getUserId());

        return userDAO.orElse(null);
    }
}
