package com.example.adviceControllerTest.Bean;

import com.example.adviceControllerTest.Bean.Small.GetEmptyStorageCountDTOBean;
import com.example.adviceControllerTest.Bean.Small.GetStationDAOBean;
import com.example.adviceControllerTest.Bean.Small.GetStorageDAOsBean;
import com.example.adviceControllerTest.Bean.Small.GetStoreProfitBean;
import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DTO.EmptyStorageCountDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetEmptyStorageCount {
    @Autowired
    GetStationDAOBean getStationDAOBean;
    @Autowired
    GetStorageDAOsBean getStorageDAOsBean;
    @Autowired
    GetEmptyStorageCountDTOBean getEmptyStorageCountDTOBean;
    @Autowired
    GetStoreProfitBean getStoreProfitBean;

    public EmptyStorageCountDTO exec(String stationName) {
        StationDAO stationDAO = getStationDAOBean.exec(stationName);
        List<StorageDAO> storageDAOS = getStorageDAOsBean.exec(stationDAO);

        EmptyStorageCountDTO emptyStorageCountDTO = getEmptyStorageCountDTOBean.exec(storageDAOS);

        return emptyStorageCountDTO;
    }
}
