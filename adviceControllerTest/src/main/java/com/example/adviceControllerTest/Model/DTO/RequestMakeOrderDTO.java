package com.example.adviceControllerTest.Model.DTO;

import lombok.Data;

@Data
public class RequestMakeOrderDTO {
    long userId;
    long storageId;
    String endStationName;
}
