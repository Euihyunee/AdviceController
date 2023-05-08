package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DTO.StoreProfitDTO;
import com.example.adviceControllerTest.Model.Enum.StorageBrand;
import com.example.adviceControllerTest.Model.Enum.StorageSize;
import org.springframework.stereotype.Component;

import static com.example.adviceControllerTest.Model.Enum.StorageBrand.*;


@Component
public class GetStoreProfitBean {

    public StoreProfitDTO exec(StorageBrand brand, StorageSize size) {

        StoreProfitDTO storeProfitDTO = new StoreProfitDTO();

        switch (brand) {
            case SAENU:
                storeProfitDTO.setStorageSize(size);
                storeProfitDTO.setTime(4);
                switch (size){
                    case SMALL : storeProfitDTO.setProfit(2000);
                        break;
                    case MID : storeProfitDTO.setProfit(3000);
                        break;
                    case BIG : storeProfitDTO.setProfit(5000);
                        break;
                    default: break;
                }
            case UBI:
                storeProfitDTO.setStorageSize(size);
                storeProfitDTO.setTime(4);
                switch (size){
                    case SMALL : storeProfitDTO.setProfit(2000);
                        break;
                    case MID : storeProfitDTO.setProfit(3000);
                        break;
                    case BIG : storeProfitDTO.setProfit(5000);
                        break;
                    default: break;
                }
            case HAPPY:
                storeProfitDTO.setStorageSize(size);
                storeProfitDTO.setTime(4);
                switch (size){
                    case SMALL : storeProfitDTO.setProfit(2000);
                        break;
                    case MID : storeProfitDTO.setProfit(3000);
                        break;
                    case BIG : storeProfitDTO.setProfit(5000);
                        break;
                    default: break;
                }
        }
        return storeProfitDTO;
    }

    public StoreProfitDTO exec(StationDAO stationDAO, StorageDAO storageDAO) {

        StoreProfitDTO storeProfitDTO = new StoreProfitDTO();
        StorageSize size = storageDAO.getStorageSize();

        switch (stationDAO.getStorageBrand()) {
            case SAENU:
                storeProfitDTO.setStorageSize(size);
                storeProfitDTO.setTime(4);
                switch (size){
                    case SMALL : storeProfitDTO.setProfit(2000);
                        break;
                    case MID : storeProfitDTO.setProfit(3000);
                        break;
                    case BIG : storeProfitDTO.setProfit(5000);
                        break;
                    default: break;
                }
            case UBI:
                storeProfitDTO.setStorageSize(size);
                storeProfitDTO.setTime(4);
                switch (size){
                    case SMALL : storeProfitDTO.setProfit(2000);
                        break;
                    case MID : storeProfitDTO.setProfit(3000);
                        break;
                    case BIG : storeProfitDTO.setProfit(5000);
                        break;
                    default: break;
                }
            case HAPPY:
                storeProfitDTO.setStorageSize(size);
                storeProfitDTO.setTime(4);
                switch (size){
                    case SMALL : storeProfitDTO.setProfit(2000);
                        break;
                    case MID : storeProfitDTO.setProfit(3000);
                        break;
                    case BIG : storeProfitDTO.setProfit(5000);
                        break;
                    default: break;
                }
        }
        return storeProfitDTO;
    }
}
