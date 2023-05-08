package com.example.adviceControllerTest.Repository;

import com.example.adviceControllerTest.Model.DAO.StoreDAO;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StoreDAORepository extends JpaRepository<StoreDAO, Long> {
    StoreDAO findStoreDAOByUserId(long userId);
    StoreDAO findTopByUserId(long userId);

    StoreDAO findStoreDAOByStorageId(long storageId);

    List<StoreDAO> findAllByUserId(long userId);
}
