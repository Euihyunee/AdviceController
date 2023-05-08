package com.example.adviceControllerTest.Bean;

import com.example.adviceControllerTest.Bean.Small.GetDeliveryCountDTO;
import com.example.adviceControllerTest.Bean.Small.GetOrderDAOsBean;
import com.example.adviceControllerTest.Bean.Small.GetStationDAOBean;
import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Model.DTO.DeliveryCountDTO;
import com.example.adviceControllerTest.Model.DTO.RequestStartEndDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetDeliveryOrderCount {
    @Autowired
    GetStationDAOBean getStationDAOBean;
    @Autowired
    GetOrderDAOsBean getOrderDAOsBean;
    @Autowired
    GetDeliveryCountDTO getDeliveryCountDTO;


    public DeliveryCountDTO exec(RequestStartEndDTO requestStartEndDTO) {
        StationDAO startStationDAO = getStationDAOBean.exec(requestStartEndDTO.getStart());
        StationDAO endStationDAO = getStationDAOBean.exec(requestStartEndDTO.getEnd());

        List<OrderDAO> orderDAOS = getOrderDAOsBean.exec(startStationDAO, endStationDAO);

        DeliveryCountDTO deliveryCountDTO = getDeliveryCountDTO.exec(orderDAOS);

        return deliveryCountDTO;
    }
}
