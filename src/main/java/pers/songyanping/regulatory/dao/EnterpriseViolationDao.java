package pers.songyanping.regulatory.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import pers.songyanping.regulatory.model.EnterpriseViolationData;

import java.util.List;

public interface EnterpriseViolationDao {
    static final String insert_column ="name";
    static final String table = "vehicleViolation";
    static final String table1 = "vehicleBase";
    static final String select_column="id,name,grade,description,violateTime";

    @Select(" SELECT " + select_column + " from "+ table)
    List<EnterpriseViolationData> list();

    @Select(" SELECT " + select_column + " from "+ table + " where id = #{id}")
    EnterpriseViolationData getOne(String id);

    @Insert(" INSERT INTO " + table + " (" +
            "name,grade,description,violateTime" +
            ")" +
            " VALUES (" +
            "#{name},#{grade},#{description},#{violateTime}" +
            ")")
    Integer insert(EnterpriseViolationData test);

    @Update(" update " + table + " set "
            + "name=" + "#{name},"
            + "grade=" + "#{grade},"
            + "description=" + "#{description},"
            + "violateTime=" + "#{violateTime}"
            + " where id = #{id}")
    Integer update(EnterpriseViolationData test);

    @Delete(" delete from " + table +
            " where id = #{id}")
    Integer delete(String id);
}
