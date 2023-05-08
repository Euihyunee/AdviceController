package com.example.adviceControllerTest.Bean;

import com.example.adviceControllerTest.Bean.Small.GetDeliveryDAOBean;
import com.example.adviceControllerTest.Bean.Small.GetStationDAOBean;
import com.example.adviceControllerTest.Bean.Small.GetStorageDAOBean;
import com.example.adviceControllerTest.Bean.Small.GetStoragePasswordDAOBean;
import com.example.adviceControllerTest.Model.DAO.DeliveryDAO;
import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DAO.StoragePasswordDAO;
import com.example.adviceControllerTest.Model.DTO.RequestDeliveryStoragePasswordDTO;
import com.example.adviceControllerTest.Model.DTO.RequestStartStoragePasswordDTO;
import com.example.adviceControllerTest.Model.DTO.StoragePasswordDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetStartStoragePassword {
    @Autowired
    GetDeliveryDAOBean getDeliveryDAOBean;
    @Autowired
    GetStationDAOBean getStationDAOBean;
    @Autowired
    GetStorageDAOBean getStorageDAOBean;
    @Autowired
    GetStoragePasswordDAOBean getStoragePasswordDAOBean;

    public StoragePasswordDTO exec(RequestStartStoragePasswordDTO requestStartStoragePasswordDTO) {
        StationDAO stationDAO = getStationDAOBean.exec(requestStartStoragePasswordDTO);
        StorageDAO storageDAO = getStorageDAOBean.exec(stationDAO, requestStartStoragePasswordDTO);
        StoragePasswordDAO storagePasswordDAO = getStoragePasswordDAOBean.exec(storageDAO);

        StoragePasswordDTO storagePasswordDTO = new StoragePasswordDTO();
        storagePasswordDTO.setStoragePasswordDTO(stationDAO, storageDAO, storagePasswordDAO);

        return storagePasswordDTO;
    }

    public StoragePasswordDTO exec(RequestDeliveryStoragePasswordDTO requestStartStoragePasswordDTO) {
        DeliveryDAO deliveryDAO = getDeliveryDAOBean.exec(requestStartStoragePasswordDTO);
        StorageDAO storageDAO = getStorageDAOBean.exec(deliveryDAO);
        StationDAO stationDAO = getStationDAOBean.exec(storageDAO);
        StoragePasswordDAO storagePasswordDAO = getStoragePasswordDAOBean.exec(storageDAO);

        StoragePasswordDTO storagePasswordDTO = new StoragePasswordDTO();
        storagePasswordDTO.setStoragePasswordDTO(stationDAO, storageDAO, storagePasswordDAO);

        return storagePasswordDTO;
    }
}
