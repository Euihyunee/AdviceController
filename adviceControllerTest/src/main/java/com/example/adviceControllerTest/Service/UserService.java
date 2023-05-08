package com.example.adviceControllerTest.Service;

import com.example.adviceControllerTest.Bean.GetUserHistoryBean;
import com.example.adviceControllerTest.Bean.GetUserHistoryDetailBean;
import com.example.adviceControllerTest.Bean.GetUserStoreBean;
import com.example.adviceControllerTest.Bean.GetUserStoreDetailBean;
import com.example.adviceControllerTest.Model.DTO.History.HistoryDTO;
import com.example.adviceControllerTest.Model.DTO.History.HistoryDetailDTO;
import com.example.adviceControllerTest.Model.DTO.History.StoreDTO;
import com.example.adviceControllerTest.Model.DTO.RequestHistoryDetailDTO;
import com.example.adviceControllerTest.Model.DTO.StorageDetailDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    GetUserStoreBean getUserStoreBean;

    @Autowired
    GetUserStoreDetailBean getUserStoreDetailBean;

    @Autowired
    GetUserHistoryBean getUserHistoryBean;

    @Autowired
    GetUserHistoryDetailBean getUserHistoryDetailBean;

    public StoreDTO getUserStoreInfo(long userId){
        return getUserStoreBean.exec(userId);
    }

    public StorageDetailDTO getUserStoreStorageDetail(long storageId){
        return getUserStoreDetailBean.exec(storageId);
    }

    public List<HistoryDTO> getUserHistory(long userId){
        return getUserHistoryBean.exec(userId);
    }

    public HistoryDetailDTO getUserHistoryDetail(RequestHistoryDetailDTO requestHistoryDetailDTO) {
        return getUserHistoryDetailBean.exec(requestHistoryDetailDTO);
    }
}
