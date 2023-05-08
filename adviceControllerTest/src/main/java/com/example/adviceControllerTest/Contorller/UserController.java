package com.example.adviceControllerTest.Contorller;

import com.example.adviceControllerTest.Model.DTO.History.HistoryDTO;
import com.example.adviceControllerTest.Model.DTO.History.HistoryDetailDTO;
import com.example.adviceControllerTest.Model.DTO.History.StoreDTO;
import com.example.adviceControllerTest.Model.DTO.RequestHistoryDetailDTO;
import com.example.adviceControllerTest.Model.DTO.StorageDetailDTO;
import com.example.adviceControllerTest.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {
    @Autowired
    UserService userService;

    // 유저가 이용중인 보관하기 정보
    @GetMapping("/store/{userId}")
    public StoreDTO getUserStoreInfo(@PathVariable long userId){
        return userService.getUserStoreInfo(userId);
    }

    // 보관하기 - 보관정보 디테일
    @GetMapping("/store/storage/{storageId}")
    public StorageDetailDTO getUserStoreStorageDetail(@PathVariable long storageId){
        return userService.getUserStoreStorageDetail(storageId);
    }

    // 히스토리(이용내역) List + 페이징 기능까지
    @GetMapping("/history/{userId}")
    public List<HistoryDTO> getUserHistory(@PathVariable long userId){
        return userService.getUserHistory(userId);
    }

    // 히스토리(이용내역) - 디테일
    @PostMapping("/history/detail")
    public HistoryDetailDTO getUserHistoryDetail(@RequestBody RequestHistoryDetailDTO requestHistoryDetailDTO){
        return userService.getUserHistoryDetail(requestHistoryDetailDTO);
    }


}
