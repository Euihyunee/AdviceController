package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DTO.History.DeliveryDTO;
import com.example.adviceControllerTest.Model.DTO.History.HistoryDTO;
import com.example.adviceControllerTest.Model.DTO.History.OrderDTO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class MergeHistoryDTOsBean {
    public List<HistoryDTO> exec(List<OrderDTO> orderDTOS, List<DeliveryDTO> deliveryDTOS) {
        // order랑 delivery 시간 순서로 정렬해서 하나의 리스트에 넣어서 리턴
        int orderIndex = 0;
        int deliveryIndex = 0;
        int length = orderDTOS.size()+ deliveryDTOS.size();
        List<HistoryDTO> historyDTOS = new ArrayList<>();

        for(int i = 0; i < length; i++){
            if(orderIndex >= orderDTOS.size()) orderIndex = orderDTOS.size()-1;
            if(deliveryIndex >= deliveryDTOS.size()) deliveryIndex = deliveryDTOS.size()-1;

            // createAt 비교해서 시간이 작은 순서로 정렬
            if(orderDTOS.get(orderIndex).getCreateAt().before(deliveryDTOS.get(deliveryIndex).getCreateAt())){
                historyDTOS.add(orderDTOS.get(orderIndex));
                orderIndex++;

            } else {
                historyDTOS.add(deliveryDTOS.get(deliveryIndex));
                deliveryIndex++;
            }

        }

        return historyDTOS;
    }
}
