package com.example.adviceControllerTest.Repository;

import com.example.adviceControllerTest.Model.DAO.StationDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationDAORepository extends JpaRepository<StationDAO, Long> {

    StationDAO findByStationName(String name);
}
