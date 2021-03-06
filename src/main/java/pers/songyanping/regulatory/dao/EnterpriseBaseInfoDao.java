package pers.songyanping.regulatory.dao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import pers.songyanping.regulatory.model.EnterpriseBaseInfoData;

import java.util.List;

public interface EnterpriseBaseInfoDao {
    static final String insert_column ="name";
    static final String table = "enterpriseBaseInfo";
    static final String select_column="id,name,description,createTime,credit";

    @Select(" SELECT " + select_column + " from "+ table)
    List<EnterpriseBaseInfoData> list();

    @Select(" SELECT " + select_column + " from "+ table + " where id = #{id}")
    EnterpriseBaseInfoData getOne(Integer id);

    @Select(" SELECT " + select_column + " from "+ table + " where name = #{name}")
    EnterpriseBaseInfoData queryByName(String name);

    @Insert(" INSERT INTO " + table + " (" +
            "name,description,createTime,credit" +
            ")" +
            " VALUES (" +
            "#{name},#{description},#{createTime},#{credit}" +
            ")")
    Integer insert(EnterpriseBaseInfoData test);

    @Update(" update " + table + " set "
            + "name=" + "#{name},"
            + "description=" + "#{description},"
            + "createTime=" + "#{createTime}"
            + " where id = #{id}")
    Integer update(EnterpriseBaseInfoData test);

    @Delete(" delete from " + table +
            " where id = #{id}")
    Integer delete(Integer id);

}
