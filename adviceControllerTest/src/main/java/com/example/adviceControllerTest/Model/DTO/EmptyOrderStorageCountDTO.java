package com.example.adviceControllerTest.Model.DTO;

import lombok.Data;

@Data
public class EmptyOrderStorageCountDTO {
    int smallCount;
    int midCount;

    public EmptyOrderStorageCountDTO(EmptyStorageCountDTO emptyStorageCountDTO) {
        this.smallCount = emptyStorageCountDTO.getSmallCount();
        this.midCount = emptyStorageCountDTO.getMidCount();
    }
}
