package com.example.adviceControllerTest.Repository;

import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface OrderDAORepository extends JpaRepository<OrderDAO, Long> {
    Optional<OrderDAO> findTop1OrderDAOByUserId(long userId);
    List<OrderDAO> findOrderDAOsByUserId(long userId);
    OrderDAO findFirstByStartStationIdAndEndStationIdOrderByCreateAtDesc(long startStationId, long endStationId);
    List<OrderDAO> findOrderDAOSByStartStationIdAndEndStationId(long startStationId, long endStationId);
    OrderDAO findOrderDAOByStorageId(long storageId);
}
