package com.example.adviceControllerTest.Bean.Small;

import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.DAO.StorageDAO;
import com.example.adviceControllerTest.Repository.OrderDAORepository;
import com.example.adviceControllerTest.Repository.StorageDAORepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SaveOrderBean {
    @Autowired
    OrderDAORepository orderDAORepository;
    @Autowired
    StorageDAORepository storageDAORepository;

    public void exec(OrderDAO order, StorageDAO storageDAO) {
        orderDAORepository.save(order);
        storageDAORepository.save(storageDAO);
    }

    public void exec(OrderDAO orderDAO) {
        orderDAORepository.save(orderDAO);
    }
}
