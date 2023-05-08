package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.DeliveryDAO;
import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.DAO.UserDAO;
import com.example.adviceControllerTest.Model.DTO.RequestHistoryDetailDTO;
import com.example.adviceControllerTest.Model.DTO.RequestTakeOrderDTO;
import com.example.adviceControllerTest.Repository.OrderDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class GetOrderDAOBean {
    @Autowired
    OrderDAORepository orderDAORepository;

    //TODO 시작역, 도착역, 유저아이디 가지고 OrderDAO (주문표?) 가져오기
    public OrderDAO exec(String start, String end, String userId) {
        return null;
    }

    public OrderDAO exec(long storageId) {
        return orderDAORepository.findOrderDAOByStorageId(storageId);
    }

    //TODO UserDAO 가지고 OrderDAO 가져오기 (의뢰한 유저가 필요)
    public OrderDAO exec(UserDAO userDAO){
        Optional<OrderDAO> orderDAO = orderDAORepository.findTop1OrderDAOByUserId(userDAO.getUserId());

        return orderDAO.orElse(null);

    }

    public OrderDAO exec(RequestTakeOrderDTO requestTakeOrderDTO) {
        return orderDAORepository.findById(requestTakeOrderDTO.getOrderId()).orElse(null);
    }

    // TODO DeliveryDAO 가지고 OrderDAO 가져오기 (배달원이 필요)
    public OrderDAO exec(DeliveryDAO deliveryDAO) {
        return orderDAORepository.findById(deliveryDAO.getOrderId()).orElse(null);
    }

    public OrderDAO exec(RequestHistoryDetailDTO requestHistoryDetailDTO) {
        return orderDAORepository.findById(requestHistoryDetailDTO.getOrderId()).orElse(null);
    }
}