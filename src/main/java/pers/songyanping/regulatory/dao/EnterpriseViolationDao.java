package pers.songyanping.regulatory.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import pers.songyanping.regulatory.model.EnterpriseViolationData;

import java.util.List;

public interface EnterpriseViolationDao {
    static final String insert_column ="name";
    static final String table = "vehicleViolation";
    static final String table1 = "vehicleBase";
    static final String select_column="id,name,grade,description,violateTtime";

    @Select(" SELECT " + select_column + " from "+ table)
    List<EnterpriseViolationData> list();

    @Select(" SELECT " + select_column + " from "+ table + " where id = #{id}")
    EnterpriseViolationData getOne(String id);

    @Insert(" INSERT INTO " + table + " (" +
            "name,grade,description,violateTtime" +
            ")" +
            " VALUES (" +
            "#{name},#{grade},#{description},#{violateTtime}" +
            ")")
    Integer insert(EnterpriseViolationData test);

    @Update(" update " + table + " set "
            + "name=" + "#{name},"
            + "grade=" + "#{grade},"
            + "description=" + "#{description}"
            + "violateTtime=" + "#{violateTtime}"
            + " where id = #{id}")
    Integer update(EnterpriseViolationData test);

    @Delete(" delete from " + table +
            " where id = #{id}")
    Integer delete(String id);
}
