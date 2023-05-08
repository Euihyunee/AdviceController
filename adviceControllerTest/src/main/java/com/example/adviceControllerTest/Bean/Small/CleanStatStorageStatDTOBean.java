package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DTO.StorageStatDTO;
import com.example.adviceControllerTest.Model.Enum.StorageStat;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class CleanStatStorageStatDTOBean {
    public List<StorageStatDTO> exec(List<StorageStatDTO> storageStatDTOS){
        for (StorageStatDTO dto:storageStatDTOS) {
            dto.setStorageStat(StorageStat.EMPTY);
        }
        return storageStatDTOS;
    }
}
