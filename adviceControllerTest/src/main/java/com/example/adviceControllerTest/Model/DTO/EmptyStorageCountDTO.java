package com.example.adviceControllerTest.Model.DTO;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class EmptyStorageCountDTO {
    int smallCount;
    int midCount;
    int bigCount;
}
