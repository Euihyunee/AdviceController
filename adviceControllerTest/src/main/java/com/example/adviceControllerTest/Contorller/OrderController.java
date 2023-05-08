package com.example.adviceControllerTest.Contorller;

import com.example.adviceControllerTest.Model.DAO.OrderDAO;
import com.example.adviceControllerTest.Model.DTO.*;
import com.example.adviceControllerTest.Service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/order")
@CrossOrigin("*")
public class OrderController {
    @Autowired
    OrderService orderService;


    // TODO Get방식
    // TODO 주문 1
    // TODO income (출발역)
    // TODO return 보관함 번호별 보관함 상태리스트
    @GetMapping("/storage/{start}")
    public List<StorageStatDTO> storageState(@PathVariable String start){
        return orderService.order1(start);
    }

    // TODO Get방식
    // TODO 주문 2
    // TODO income (출발역) (도착역) (사이즈)
    // TODO return 배달비용
    @GetMapping("/cost/{start}/{end}")
    public OrderCostDTO orderCost(@PathVariable String start, @PathVariable String end){
        return orderService.order2(start, end);
    }

    // TODO Get방식
    // TODO 주문 3
    // TODO income (사용자 아이디)
    // TODO return 보관함 정보 > 보관함 번호, 보관함 비밀번호
    // 사용자가 1개의 오더만 가질때 작동
    @GetMapping("/storage/info/{userId}")
    public StoragePasswordDTO orderInfo(@PathVariable long userId) {
        return orderService.order3(userId);
    }
    // 오더 아이디로 보관함 정보 가져오기


    // TODO 주문 4
    @GetMapping("/make/{userId}/{stationName}/{storageNum}")
    public void makeOrderGET(@PathVariable long userId, @PathVariable String stationName, @PathVariable int storageNum){
        orderService.makeOrderGET(userId, stationName, storageNum);
    }

    // TODO 주문 4
    @PostMapping("/make")
    public OrderDAO makeOrderPOST(@RequestBody RequestMakeOrderDTO requestMakeOrderDTO){
        return orderService.makeOrderPOST(requestMakeOrderDTO);
    }

    // 메인 - 빈 보관함 갯수
    @GetMapping("/empty/{stationName}")
    public EmptyOrderStorageCountDTO getEmptyStorageCount(@PathVariable String stationName){
        return orderService.getEmptyStorageCount(stationName);
    }

}
