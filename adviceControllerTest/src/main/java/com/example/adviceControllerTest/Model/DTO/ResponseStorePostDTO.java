package com.example.adviceControllerTest.Model.DTO;

import com.example.adviceControllerTest.Model.DAO.StoreDAO;
import lombok.Data;

@Data
public class ResponseStorePostDTO {
    long storeId;

    public ResponseStorePostDTO(StoreDAO storeDAO) {
        this.storeId = storeDAO.getStoreId();
    }
}
