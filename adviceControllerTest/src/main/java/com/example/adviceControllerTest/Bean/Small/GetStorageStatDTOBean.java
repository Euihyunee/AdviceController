package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DTO.StorageStatDTO;
import org.springframework.stereotype.Component;

@Component
public class GetStorageStatDTOBean {
    public StorageStatDTO exec(StorageDAO storageDAO) {
        StorageStatDTO storageStatDTO = new StorageStatDTO();
        storageStatDTO.setStorageId(storageDAO.getStorageId());
        storageStatDTO.setStorageNumber(storageDAO.getStorageNumber());
        storageStatDTO.setStorageStat(storageDAO.getStorageStat());
        storageStatDTO.setStorageSize(storageDAO.getStorageSize());
        return storageStatDTO;
    }
}
