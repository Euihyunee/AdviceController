package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.DeliveryDAO;
import com.example.adviceControllerTest.Model.DTO.History.DeliveryDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetDeliveryDTOsBean {

    @Autowired
    GetDeliveryDTOBean getDeliveryDTOBean;


    public List<DeliveryDTO> exec(List<DeliveryDAO> deliveryDAOS) {
        List<DeliveryDTO> deliveryDTOS = new ArrayList<>();
        for (DeliveryDAO deliveryDAO:deliveryDAOS) {
            deliveryDTOS.add(getDeliveryDTOBean.exec(deliveryDAO));
        }

        return deliveryDTOS;
    }
}
