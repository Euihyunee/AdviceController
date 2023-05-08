package com.example.adviceControllerTest.Bean;

import com.example.adviceControllerTest.Bean.Small.GetStorageDAOBean;
import com.example.adviceControllerTest.Bean.Small.GetUserDAOBean;
import com.example.adviceControllerTest.Bean.Small.SaveStoreBean;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DAO.StoreDAO;
import com.example.adviceControllerTest.Model.DAO.UserDAO;
import com.example.adviceControllerTest.Model.DTO.RequestStoreDTO;
import com.example.adviceControllerTest.Model.DTO.ResponseStorePostDTO;
import com.example.adviceControllerTest.Model.Enum.StorageStat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MakeStoreBean {
    @Autowired
    GetUserDAOBean getUserDAOBean;
    @Autowired
    GetStorageDAOBean getStorageDAOBean;
    @Autowired
    SaveStoreBean saveStoreBean;
    public ResponseStorePostDTO exec(RequestStoreDTO requestStoreDTO){
        UserDAO userDAO = getUserDAOBean.exec(requestStoreDTO);
        StorageDAO storageDAO = getStorageDAOBean.exec(requestStoreDTO);


        StoreDAO storeDAO = new StoreDAO();
        storeDAO.makeStore(userDAO, storageDAO);
        storageDAO.updateStat(StorageStat.STORE); // 아마 더티체킹으로 저장되지 않을까?

        saveStoreBean.exec(storeDAO);

        // mapping
        ResponseStorePostDTO responseStorePostDTO = new ResponseStorePostDTO(storeDAO);

        return responseStorePostDTO;
    }
}
