package com.example.adviceControllerTest.Bean;

import com.example.adviceControllerTest.Bean.Small.GetDeliveryDAOBean;
import com.example.adviceControllerTest.Bean.Small.GetOrderDAOBean;
import com.example.adviceControllerTest.Bean.Small.GetStoreDAOBean;
import com.example.adviceControllerTest.Model.DAO.DeliveryDAO;
import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.DAO.StoreDAO;
import com.example.adviceControllerTest.Model.DTO.History.DeliveryDetailDTO;
import com.example.adviceControllerTest.Model.DTO.History.HistoryDetailDTO;
import com.example.adviceControllerTest.Model.DTO.History.OrderDetailDTO;
import com.example.adviceControllerTest.Model.DTO.History.StoreDetailDTO;
import com.example.adviceControllerTest.Model.DTO.RequestHistoryDetailDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class GetUserHistoryDetailBean {
    @Autowired
    GetStoreDAOBean getStoreDAOBean;
    @Autowired
    GetOrderDAOBean getOrderDAOBean;
    @Autowired
    GetDeliveryDAOBean getDeliveryDAOBean;

    public HistoryDetailDTO exec(RequestHistoryDetailDTO requestHistoryDetailDTO) {
        int type = 0;
        DeliveryDAO deliveryDAO = null;
        OrderDAO orderDAO = null;
        StoreDAO storeDAO = null;

        // requestHistoryDetailDTO 중에 어떤 아이디 가지고 있는지 확인
        if(requestHistoryDetailDTO.getDeliveryId() != 0){
            deliveryDAO = getDeliveryDAOBean.exec(requestHistoryDetailDTO);
        }

        else if(requestHistoryDetailDTO.getOrderId() != 0) {
            orderDAO = getOrderDAOBean.exec(requestHistoryDetailDTO);
        }
        else if(requestHistoryDetailDTO.getStoreId() != 0) {
            storeDAO = getStoreDAOBean.exec(requestHistoryDetailDTO.getStoreId());
        }

        // 가져온 엔티티로 HistoryDetailDTO 생성
        HistoryDetailDTO historyDetailDTO = null;

        // 확인 후 확인된 엔티티 가져오기
        if(deliveryDAO != null){
            DeliveryDetailDTO deliveryDetailDTO = new DeliveryDetailDTO();
            deliveryDetailDTO.makeDeliveryDetailDTO(deliveryDAO);
            historyDetailDTO = deliveryDetailDTO;
        }
        else if(orderDAO != null){
            OrderDetailDTO orderDetailDTO = new OrderDetailDTO();
            orderDetailDTO.makeOrderDetailDTO(orderDAO);
            historyDetailDTO = orderDetailDTO;
        }
        else if(storeDAO != null){
            StoreDetailDTO storeDetailDTO = new StoreDetailDTO();
            storeDetailDTO.makeStoreDetailDTO(storeDAO);
            historyDetailDTO = storeDetailDTO;
        }
        else {
            log.error("이건 좀 논란이 있겠는걸...");
        }


        return historyDetailDTO;
    }
}
