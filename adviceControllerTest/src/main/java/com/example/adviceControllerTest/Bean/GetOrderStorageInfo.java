package com.example.adviceControllerTest.Bean;

import com.example.adviceControllerTest.Bean.Small.GetDeliveryCost;
import com.example.adviceControllerTest.Bean.Small.GetOrderDAOBean;
import com.example.adviceControllerTest.Bean.Small.GetStorageDAOBean;
import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DTO.ResponseDeliveryOrderStorageDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetOrderStorageInfo {
    @Autowired
    GetOrderDAOBean getOrderDAOBean;
    @Autowired
    GetStorageDAOBean getStorageDAOBean;
    @Autowired
    GetDeliveryCost getDeliveryCost;
    public ResponseDeliveryOrderStorageDTO exec(long storageId) {
        OrderDAO orderDAO = getOrderDAOBean.exec(storageId);
        StorageDAO storageDAO = getStorageDAOBean.exec(storageId);
        int cost = getDeliveryCost.exec(storageDAO);

        ResponseDeliveryOrderStorageDTO responseDeliveryOrderStorageDTO = new ResponseDeliveryOrderStorageDTO(orderDAO, storageDAO);
        responseDeliveryOrderStorageDTO.setPrice(cost);

        return responseDeliveryOrderStorageDTO;

    }
}
