package com.example.adviceControllerTest.Model.DAO;

import com.example.adviceControllerTest.Model.Enum.StorageBrand;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Table(name="tbl_station")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StationDAO {

    @Id
    private long stationId;

    // 역 이름
    @Column
    private String  stationName;

    // 역 보관함 브랜드
    @Enumerated(EnumType.STRING)
    StorageBrand storageBrand;
}
