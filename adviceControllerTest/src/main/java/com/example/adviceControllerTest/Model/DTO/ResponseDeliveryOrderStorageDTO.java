package com.example.adviceControllerTest.Model.DTO;

import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.Enum.StorageSize;
import lombok.Data;

@Data
public class ResponseDeliveryOrderStorageDTO {
    long orderId;
    StorageSize size;
    int price;
    int storageNum;

    public ResponseDeliveryOrderStorageDTO(OrderDAO orderDAO, StorageDAO storageDAO){
        this.orderId = orderDAO.getOrderId();
        this.size = storageDAO.getStorageSize();
        this.storageNum = storageDAO.getStorageNumber();
    }
}
