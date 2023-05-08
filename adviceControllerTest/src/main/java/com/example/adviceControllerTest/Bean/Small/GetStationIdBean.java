package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.StationDAO;
import com.example.adviceControllerTest.Repository.StationDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetStationIdBean {
    @Autowired
    StationDAORepository stationDAORepository;

    public Long exec(String stationName){
        StationDAO stationDAO = stationDAORepository.findByStationName(stationName);

        long stationId = stationDAO.getStationId();

        return stationId;
    }

}
