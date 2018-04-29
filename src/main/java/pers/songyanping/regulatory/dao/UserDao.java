package pers.songyanping.regulatory.dao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import pers.songyanping.regulatory.model.UserData;

import java.util.List;
public interface UserDao {
    static final String insert_column ="userName,password,email,roleId";
    static final String table = "user";
    static final String select_column="uid,userName,password,email,roleId";

    @Select(" SELECT " + select_column + " from "+ table)
    List<UserData> list();

    @Select(" SELECT " + select_column + " from "+ table + " where uid = #{id}")
    UserData getOne(Integer id);

    @Insert(" INSERT INTO " + table + " (" +
            insert_column +
            ")" +
            " VALUES (" +
            "#{userName},#{password},#{email},#{roleId}" +
            ")")
    Integer insert(UserData test);

    @Update(" update " + table + " set "
            + "userName=" + "#{userName},"
            + "password=" + "#{password},"
            + "email=" + "#{email},"
            + "roleId=" + "#{roleId}"
            + " where uid = #{uid}")
    Integer update(UserData test);

    @Delete(" delete from " + table +
            " where uid = #{uid}")
    Integer delete(Integer uid);
}
