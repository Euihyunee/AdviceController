package com.example.adviceControllerTest.Bean;

import com.example.adviceControllerTest.Bean.Small.*;
import com.example.adviceControllerTest.Model.DAO.DeliveryDAO;
import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.DAO.UserDAO;
import com.example.adviceControllerTest.Model.DTO.History.DeliveryDTO;
import com.example.adviceControllerTest.Model.DTO.History.HistoryDTO;
import com.example.adviceControllerTest.Model.DTO.History.OrderDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetUserHistoryBean {
    @Autowired
    GetUserDAOBean getUserDAOBean;
    @Autowired
    GetOrderDAOsBean getOrderDAOsBean;
    @Autowired
    GetDeliveryDAOsBean getDeliveryDAOsBean;
    @Autowired
    MergeHistoryDTOsBean mergeHistoryDTOsBean;
    @Autowired
    GetOrderDTOsBean getOrderDTOsBean;
    @Autowired
    GetDeliveryDTOsBean getDeliveryDTOsBean;


    public List<HistoryDTO> exec(long userId){
        // 유저 아이디로 order, delivery 전체 조회
        UserDAO userDAO = getUserDAOBean.exec(userId);

        List<OrderDAO> orderDAOS = getOrderDAOsBean.exec(userDAO);
        List<DeliveryDAO> deliveryDAOS = getDeliveryDAOsBean.exec(userDAO);

        // DAO to DTO
        List<OrderDTO> orderDTOS = getOrderDTOsBean.exec(orderDAOS);
        List<DeliveryDTO> deliveryDTOS = getDeliveryDTOsBean.exec(deliveryDAOS);

        // 패키징
        List<HistoryDTO> historyDTOS = mergeHistoryDTOsBean.exec(orderDTOS, deliveryDTOS);

        return historyDTOS;
    }
}
