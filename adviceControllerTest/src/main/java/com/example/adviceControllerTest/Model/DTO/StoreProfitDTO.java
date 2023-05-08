package com.example.adviceControllerTest.Model.DTO;

import com.example.adviceControllerTest.Model.Enum.StorageSize;
import lombok.Data;

@Data
public class StoreProfitDTO {

    // 보관함 사이즈
    StorageSize storageSize;

    // 기본 요금
    int profit;

    // 기본 시간
    int time;
}
