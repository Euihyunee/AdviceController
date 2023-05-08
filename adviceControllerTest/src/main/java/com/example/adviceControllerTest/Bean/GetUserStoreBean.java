package com.example.adviceControllerTest.Bean;

import com.example.adviceControllerTest.Bean.Small.*;
import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DAO.StoreDAO;
import com.example.adviceControllerTest.Model.DAO.UserDAO;
import com.example.adviceControllerTest.Model.DTO.History.StoreDTO;
import com.example.adviceControllerTest.Model.DTO.StoreProfitDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetUserStoreBean {
    @Autowired
    GetUserDAOBean getUserDAOBean;
    @Autowired
    GetStoreDAOBean getStoreDAOBean;
    @Autowired
    GetStorageDAOBean getStorageDAOBean;
    @Autowired
    GetStationDAOBean getStationDAOBean;
    @Autowired
    GetStoreProfitBean getStoreProfitBean;

    public StoreDTO exec(long userId){
        // 현재 Store(보관) 정보 가져옴
        UserDAO userDAO = getUserDAOBean.exec(userId);
        StoreDAO storeDAO = getStoreDAOBean.exec(userDAO);

        // Storage 가져옴
        StorageDAO storageDAO = getStorageDAOBean.exec(storeDAO);

        // Station 가져옴
        StationDAO stationDAO = getStationDAOBean.exec(storageDAO);

        // Station, Storage로 브랜드, 사이즈별 비용 계산
        StoreProfitDTO storeProfitDTO = getStoreProfitBean.exec(stationDAO, storageDAO);

        // 리턴
        StoreDTO storeDTO = new StoreDTO(stationDAO, storeDAO, storeProfitDTO);
        return storeDTO;
    }
}
