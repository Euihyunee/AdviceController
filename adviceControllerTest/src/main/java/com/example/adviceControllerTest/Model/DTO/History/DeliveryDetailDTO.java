package com.example.adviceControllerTest.Model.DTO.History;

import com.example.adviceControllerTest.Model.DAO.DeliveryDAO;
import com.example.adviceControllerTest.Model.Enum.OrderStat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class DeliveryDetailDTO implements HistoryDetailDTO {
    // 서비스 종류
    String service;
    // 요청 시간
    Timestamp createAt;
    // 배달 승낙 시간
    Timestamp finishedAt;
    // 비용
    int price;

    // 배송상태
    OrderStat stat;

    // 이거 삭제하고 빈으로 돌려야할듯
    public void makeDeliveryDetailDTO(DeliveryDAO deliveryDAO) {
        this.price = deliveryDAO.getPrice();
        this.createAt = deliveryDAO.getCreateAt();
        this.finishedAt = deliveryDAO.getFinishedAt();
        this.service = "delivery";

    }
}
