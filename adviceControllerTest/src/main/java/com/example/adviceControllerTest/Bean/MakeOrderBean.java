package com.example.adviceControllerTest.Bean;

import com.example.adviceControllerTest.Bean.Small.GetStationDAOBean;
import com.example.adviceControllerTest.Bean.Small.GetStorageDAOBean;
import com.example.adviceControllerTest.Bean.Small.GetUserDAOBean;
import com.example.adviceControllerTest.Bean.Small.SaveOrderBean;
import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DAO.UserDAO;
import com.example.adviceControllerTest.Model.DTO.RequestMakeOrderDTO;
import com.example.adviceControllerTest.Model.Enum.StorageStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeOrderBean {
    @Autowired
    GetUserDAOBean getUserDAOBean;
    @Autowired
    GetStorageDAOBean getStorageDAOBean;
    @Autowired
    GetStationDAOBean getStationDAOBean;
    @Autowired
    SaveOrderBean saveOrderBean;
    public OrderDAO exec(RequestMakeOrderDTO requestMakeOrderDTO){
        UserDAO userDAO = getUserDAOBean.exec(requestMakeOrderDTO);
        StorageDAO storageDAO = getStorageDAOBean.exec(requestMakeOrderDTO);
        // 도착역 DAO
        StationDAO stationDAO = getStationDAOBean.exec(requestMakeOrderDTO);

        OrderDAO orderDAO = new OrderDAO();
        orderDAO.makeOrder(userDAO, storageDAO, stationDAO);
        storageDAO.updateStat(StorageStat.WAIT); // 아마 더티체킹으로 저장되지 않을까?

        saveOrderBean.exec(orderDAO);
        return orderDAO;
    }
}
