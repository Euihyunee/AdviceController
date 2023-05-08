package com.example.adviceControllerTest.Model.DTO;

import com.example.adviceControllerTest.Model.Enum.StorageSize;
import com.example.adviceControllerTest.Model.Enum.StorageStat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class StorageStatDTO {
    long storageId;
    // 보관함 번호(int)
    int storageNumber;
    // 보관함 상태(enum)
    StorageStat storageStat;
    StorageSize storageSize;
}
