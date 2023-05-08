package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import org.springframework.stereotype.Component;

@Component
public class GetDeliveryCost {
    public int exec(StorageDAO storageDAO) {
        return 1800;
    }
}
