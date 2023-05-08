package com.example.adviceControllerTest.Bean;

import com.example.adviceControllerTest.Bean.Small.*;
import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DAO.UserDAO;
import com.example.adviceControllerTest.Model.DTO.StoragePasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Order3Bean {
    @Autowired
    GetUserDAOBean getUserDAOBean;
    @Autowired
    GetOrderDAOBean getOrderDAOBean;
    @Autowired
    GetStationIdBean getStationIdBean;
    @Autowired
    GetStoragePasswordBean getStoragePasswordBean;
    @Autowired
    GetStorageDAOBean getStorageDAOBean;

    public StoragePasswordDTO exec(long userId){
        // 사용자 아이디 받아다가 주문 확인해서 보관함 비밀번호 가져오는거
        // TODO userId로 UserDAO가져오기
        UserDAO userDAO = getUserDAOBean.exec(userId);

        // TODO 주문확인
        OrderDAO order = getOrderDAOBean.exec(userDAO);
        
        // TODO orderDAO에서 출발 보관함 id 가져오기
        StorageDAO storageDAO = getStorageDAOBean.exec(order);

        // TODO 보관함 id로 보관함 비번 조회
        StoragePasswordDTO storagePassword = getStoragePasswordBean.exec(storageDAO);

        // TODO 결과리턴
        return storagePassword;
    }
}
