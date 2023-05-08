package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Model.DAO.UserDAO;
import com.example.adviceControllerTest.Repository.OrderDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetOrderDAOsBean {
    @Autowired
    OrderDAORepository orderDAORepository;
    public List<OrderDAO> exec(UserDAO userDAO){
        return orderDAORepository.findOrderDAOsByUserId(userDAO.getUserId());

    }

    public List<OrderDAO> exec(StationDAO startStationDAO, StationDAO endStationDAO) {
        return orderDAORepository.findOrderDAOSByStartStationIdAndEndStationId(startStationDAO.getStationId(), endStationDAO.getStationId());
    }
}
