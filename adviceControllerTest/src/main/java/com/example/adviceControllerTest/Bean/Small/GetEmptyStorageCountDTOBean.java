package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DTO.EmptyStorageCountDTO;
import com.example.adviceControllerTest.Model.Enum.StorageSize;
import com.example.adviceControllerTest.Model.Enum.StorageStat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class GetEmptyStorageCountDTOBean {
    public EmptyStorageCountDTO exec(List<StorageDAO> storageDAOS) {
        EmptyStorageCountDTO emptyStorageCountDTO = new EmptyStorageCountDTO();
        int smallCount = 0;
        int midCount = 0;
        int bigCount = 0;

        for(StorageDAO storageDAO: storageDAOS){
            if(storageDAO.getStorageStat() == StorageStat.EMPTY){
                if(storageDAO.getStorageSize() == StorageSize.MID){
                    midCount++;
                }
                else if(storageDAO.getStorageSize() == StorageSize.SMALL){
                    smallCount++;
                }
                else if(storageDAO.getStorageSize() == StorageSize.BIG){
                    bigCount++;
                }
            }
        }
        emptyStorageCountDTO.setSmallCount(smallCount);
        emptyStorageCountDTO.setMidCount(midCount);
        emptyStorageCountDTO.setBigCount(bigCount);

        return emptyStorageCountDTO;
    }
}
