package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Repository.StationDAORepository;
import com.example.adviceControllerTest.Repository.StorageDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetStorageIdBean {
    @Autowired
    StationDAORepository stationDAORepository;
    @Autowired
    StorageDAORepository storageDAORepository;

    public StorageDAO exec(String stationName, int storageNum) {
        StationDAO stationDAO = stationDAORepository.findByStationName(stationName);

        StorageDAO storageDAO = storageDAORepository.findStorageDAOByStationIdAndStorageNumber(stationDAO.getStationId(), storageNum);

        return storageDAO;
    }
}
