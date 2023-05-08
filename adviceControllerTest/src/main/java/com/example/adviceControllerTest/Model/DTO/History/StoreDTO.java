package com.example.adviceControllerTest.Model.DTO.History;

import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Model.DAO.StoreDAO;
import com.example.adviceControllerTest.Model.DTO.StoreProfitDTO;
import com.example.adviceControllerTest.Model.Enum.StorageSize;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

@Data
@NoArgsConstructor
public class StoreDTO implements HistoryDTO {
    String stationName;
    long storeId;
    long storageId;
    int price;
    StorageSize storageSize;
    Timestamp timestamp;

    public StoreDTO (StationDAO stationDAO, StoreDAO storeDAO, StoreProfitDTO storeProfitDTO){
        this.stationName = stationDAO.getStationName();
        this.storeId = storeDAO.getStoreId();
        this.storageId = storeDAO.getStorageId();
        this.price = storeProfitDTO.getProfit();
        this.storageSize = storeProfitDTO.getStorageSize();
        this.timestamp = storeDAO.getCreateAt();
    }
}
