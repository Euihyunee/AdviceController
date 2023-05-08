package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.DeliveryDAO;
import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Repository.DeliveryDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateDeliveryBean {
    @Autowired
    DeliveryDAORepository deliveryRepository;

    public void exec(OrderDAO orderDAO, long userId){
        DeliveryDAO deliveryDAO = new DeliveryDAO();
        deliveryDAO.makeDelivery(orderDAO, userId);

        // TODO 잘 저장됐는지 확인하는 코드 추가해야함
        deliveryRepository.save(deliveryDAO);
    }
}
