package com.example.adviceControllerTest.Model.DAO;

import com.example.adviceControllerTest.Model.Enum.StoreStat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;

@Entity
@Table(name="tbl_table")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoreDAO {

    @Id @GeneratedValue
    private long storeId;

    // 보관함 회원 아이디
    long userId;

    // 보관함 아이디(FK)
    long storageId;

    Timestamp createAt;

    StoreStat storeStat;

    public void makeStore(UserDAO user1, StorageDAO storageDAO) {
        this.userId = user1.getUserId();
        this.storageId = storageDAO.getStorageId();
        this.createAt = new Timestamp(System.currentTimeMillis());
        this.storeStat = StoreStat.ACTIVE;
    }
}
