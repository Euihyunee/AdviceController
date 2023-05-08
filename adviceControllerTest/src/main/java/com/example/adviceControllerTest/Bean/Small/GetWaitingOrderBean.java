package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Repository.OrderDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetWaitingOrderBean {
    @Autowired
    OrderDAORepository orderDAORepository;

    public OrderDAO exec(StationDAO start, StationDAO end){

        return orderDAORepository.findFirstByStartStationIdAndEndStationIdOrderByCreateAtDesc(start.getStationId(), end.getStationId());
    }
}
