package com.example.adviceControllerTest.Model.DTO.History;

import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.Enum.OrderStat;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class OrderDetailDTO implements HistoryDetailDTO {
    // 서비스 종류
    String service;
    // 요청 시간
    Timestamp createAt;
    // 배달 승낙 시간
//    Timestamp finishedAt;

    // 비용
    int price;

    // 배송상태
    OrderStat stat;

    // 이거 삭제하고 빈으로 돌려야할듯
    public void makeOrderDetailDTO(OrderDAO orderDAO) {
        this.service = "order";
        this.createAt = orderDAO.getCreateAt();
        this.price = orderDAO.getPrice();
        this.stat = orderDAO.getOrderStat();
    }

}
