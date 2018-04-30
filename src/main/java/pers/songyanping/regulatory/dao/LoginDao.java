package pers.songyanping.regulatory.dao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import pers.songyanping.regulatory.model.UserData;

import java.util.List;
public interface LoginDao {
    static final String table = "user";
    static final String select_column="uid,userName,password,email,roleId";

    @Select(" SELECT " + select_column + " from "+ table)
    List<UserData> list();
}
