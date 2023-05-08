package com.example.adviceControllerTest.Model.DAO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tbl_storage_password")
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StoragePasswordDAO {

    @Id
    private long storagePasswordId;

    // 보관함 비밀번호(String)
    private String storagePassword;
}
