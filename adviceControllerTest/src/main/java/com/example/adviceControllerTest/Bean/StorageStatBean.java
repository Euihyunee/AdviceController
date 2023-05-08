package com.example.adviceControllerTest.Bean;

import com.example.adviceControllerTest.Bean.Small.GetStationDAOBean;
import com.example.adviceControllerTest.Bean.Small.GetStorageDAOsBean;
import com.example.adviceControllerTest.Bean.Small.GetStorageStatDTOsBean;
import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Model.DTO.StorageStatDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class StorageStatBean {

    @Autowired
    GetStationDAOBean getStationDAOBean;
    @Autowired
    GetStorageDAOsBean getStorageDAOsBean;
    @Autowired
    GetStorageStatDTOsBean getStorageStatDTOsBean;

    // 역이름 받아서 해당 역 보관함 정보 리턴
    public List<StorageStatDTO> exec(String start){
        // TODO 역 id 가져오기
        StationDAO stationDAO = getStationDAOBean.exec(start);

        // TODO 역 id로 보관함 전체가져오기
        List<StorageDAO> StorageDAOS = getStorageDAOsBean.exec(stationDAO);

        // TODO 보관함 전체를 상태값만 가진 DTO로 변경
        List<StorageStatDTO> storageStatDTOS = getStorageStatDTOsBean.exec(StorageDAOS);

        // TODO 결과리턴
        return storageStatDTOS;
    }
}













