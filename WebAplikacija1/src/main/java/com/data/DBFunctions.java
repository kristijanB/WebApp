package com.data;

import com.pojo.TecajPOJO;

import java.sql.SQLException;
import java.util.List;

public interface DBFunctions {
    void insert(TecajPOJO[] obj) throws SQLException;

    boolean checkIfDataExists() throws SQLException;

    List<String> getCurrency() throws SQLException;

    void updateAllData(TecajPOJO[] obj) throws SQLException;

    String[] getKupovni(String srednjiTecaj) throws SQLException;

    String getProdajni(String srednjiTecaj) throws SQLException;

}
