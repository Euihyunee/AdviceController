package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.DeliveryDAO;
import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DTO.History.DeliveryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetDeliveryDTOBean {
    @Autowired
    GetStationDAOBean getStationDAOBean;
    @Autowired
    GetOrderDAOBean getOrderDAOBean;
    @Autowired
    GetStorageDAOBean getStorageDAOBean;

    public DeliveryDTO exec(DeliveryDAO deliveryDAO) {
        OrderDAO orderDAO = getOrderDAOBean.exec(deliveryDAO);

        StationDAO startStationDAO = getStationDAOBean.exec(orderDAO.getStartStationId());
        StationDAO endStationDAO = getStationDAOBean.exec(orderDAO.getEndStationId());
        StorageDAO storageDAO = getStorageDAOBean.exec(orderDAO);

        DeliveryDTO deliveryDTO = new DeliveryDTO();
        deliveryDTO.setDeliveryId(deliveryDAO.getDeliveryId());
        deliveryDTO.setStartStationName(startStationDAO.getStationName());
        deliveryDTO.setEndStationName(endStationDAO.getStationName());
        deliveryDTO.setSize(storageDAO.getStorageSize());
        if(deliveryDAO.getPrice() == 0){
            deliveryDTO.setPrice(2000);
        }else {
            deliveryDTO.setPrice(deliveryDAO.getPrice());
        }
        deliveryDTO.setCreateAt(deliveryDAO.getCreateAt());
        if(deliveryDAO.getFinishedAt()!= null){
            deliveryDTO.setFinishedAt(deliveryDAO.getFinishedAt());
        }
        deliveryDTO.setOrderStat(orderDAO.getOrderStat());

        return deliveryDTO;

    }
}
