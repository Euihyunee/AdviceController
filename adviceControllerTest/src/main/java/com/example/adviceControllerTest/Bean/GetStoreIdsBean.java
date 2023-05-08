package com.example.adviceControllerTest.Bean;

import com.example.adviceControllerTest.Bean.Small.GetStoreDAOsBean;
import com.example.adviceControllerTest.Bean.Small.GetUserDAOBean;
import com.example.adviceControllerTest.Model.DAO.StoreDAO;
import com.example.adviceControllerTest.Model.DAO.UserDAO;
import com.example.adviceControllerTest.Model.DTO.ResponseStoreIdsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class GetStoreIdsBean {
    @Autowired
    GetUserDAOBean getUserDAOBean;
    @Autowired
    GetStoreDAOsBean getStoreDAOsBean;
    public ResponseStoreIdsDTO exec(long userId){
        UserDAO userDAO = getUserDAOBean.exec(userId);

        List<StoreDAO> storeDAOS = getStoreDAOsBean.exec(userId);

        List<Long> storeIds = new ArrayList<Long>();
        for(StoreDAO storeDAO : storeDAOS){
            storeIds.add(storeDAO.getStoreId());
        }


        // mapping
        ResponseStoreIdsDTO responseStoreIdsDTO = new ResponseStoreIdsDTO(storeIds);


        return responseStoreIdsDTO;
    }
}
