package com.example.adviceControllerTest.Model.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class ResponseStoreIdsDTO {
    List<Long> storeIds;
}
