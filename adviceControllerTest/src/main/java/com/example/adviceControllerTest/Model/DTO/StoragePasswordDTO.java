package com.example.adviceControllerTest.Model.DTO;

import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DAO.StoragePasswordDAO;
import lombok.Data;

@Data
public class StoragePasswordDTO {
    String stationName;
    int storageNum;
    String password;

    public void setStoragePasswordDTO(StationDAO stationDAO, StorageDAO storageDAO, StoragePasswordDAO storagePasswordDAO) {
        this.stationName = stationDAO.getStationName();
        this.storageNum = storageDAO.getStorageNumber();
        this.password = storagePasswordDAO.getStoragePassword();
    }
}
