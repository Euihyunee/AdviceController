package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.DeliveryDAO;
import com.example.adviceControllerTest.Model.DAO.UserDAO;
import com.example.adviceControllerTest.Repository.DeliveryDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetDeliveryDAOsBean {
    @Autowired
    DeliveryDAORepository deliveryDAORepository;

    public List<DeliveryDAO> exec(UserDAO userDAO) {
        List<DeliveryDAO> deliveryDAOS = deliveryDAORepository.findAllByUserId(userDAO.getUserId());

        return deliveryDAOS;
    }
}
