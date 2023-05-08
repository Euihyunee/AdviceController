package com.example.adviceControllerTest.Model.DAO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="tbl_delivery")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class DeliveryDAO {

    @Id @GeneratedValue
    private long deliveryId;

    // 배달 유저 아이디
    long userId;
    long orderId;
    // 도착보관함 아이디
    long storageId;
    // 배달 승낙 시간
    Timestamp createAt;
    // 배달 승낙 시간
    Timestamp finishedAt;
    // 배달 수익 비용
    int price;

    public void makeDelivery(UserDAO userDAO, OrderDAO orderDAO, StorageDAO storageDAO){
        this.userId = userDAO.getUserId();
        this.orderId = orderDAO.getOrderId();
        this.storageId = storageDAO.getStorageId();
        this.createAt = new Timestamp(System.currentTimeMillis());
        orderDAO.addDelivery(this);
    }

    public void makeDelivery(OrderDAO orderDAO, long userId){
        this.userId = orderDAO.getUserId();
        this.orderId = orderDAO.getOrderId();
        this.storageId = orderDAO.getStorageId();
        this.createAt = new Timestamp(System.currentTimeMillis());
        orderDAO.addDelivery(this);
    }
}
