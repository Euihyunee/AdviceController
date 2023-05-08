package com.example.adviceControllerTest.Repository;

import com.example.adviceControllerTest.Model.DAO.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDAORepository extends JpaRepository<UserDAO, Long> {
}
