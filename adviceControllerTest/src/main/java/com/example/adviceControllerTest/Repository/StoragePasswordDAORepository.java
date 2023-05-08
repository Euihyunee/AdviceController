package com.example.adviceControllerTest.Repository;

import com.example.adviceControllerTest.Model.DAO.StoragePasswordDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StoragePasswordDAORepository extends JpaRepository<StoragePasswordDAO, Long> {
    // Optional<StoragePasswordDAO> findByStorageId(long storageId);
}
