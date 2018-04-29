package pers.songyanping.regulatory.dao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import pers.songyanping.regulatory.model.RoleData;

import java.util.List;
public interface RoleDao {
    static final String insert_column ="name,description";
    static final String table = "role";
    static final String select_column="id,name,description";

    @Select(" SELECT " + select_column + " from "+ table)
    List<RoleData> list();

    @Select(" SELECT " + select_column + " from "+ table + " where id = #{id}")
    RoleData getOne(Integer id);

    @Insert(" INSERT INTO " + table + " (" +
            "name,description" +
            ")" +
            " VALUES (" +
            "#{name},#{description}" +
            ")")
    Integer insert(RoleData test);

    @Update(" update " + table + " set "
            + "name=" + "#{name},"
            + "description=" + "#{description}"
            + " where id = #{id}")
    Integer update(RoleData test);

    @Delete(" delete from " + table +
            " where id = #{id}")
    Integer delete(Integer id);
}
