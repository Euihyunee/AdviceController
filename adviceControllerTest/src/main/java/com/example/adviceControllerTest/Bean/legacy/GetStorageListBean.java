package com.example.adviceControllerTest.Bean.legacy;

import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Repository.StorageDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetStorageListBean {
    @Autowired
    StorageDAORepository storageDAORepository;

    public List<StorageDAO> exec(StationDAO stationDAO){
        List<StorageDAO> storageDAOList = storageDAORepository.findStorageDAOByStationId(stationDAO.getStationId());

        return storageDAOList;
    }
}
