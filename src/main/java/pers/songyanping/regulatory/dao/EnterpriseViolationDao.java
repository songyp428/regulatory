package pers.songyanping.regulatory.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import pers.songyanping.regulatory.model.EnterpriseBaseInfoData;
import pers.songyanping.regulatory.model.EnterpriseViolationData;

import java.util.List;

public interface EnterpriseViolationDao {
    static final String insert_column ="name";
    static final String table = "vehicleViolation";
    static final String table1 = "enterpriseBaseInfo";
    static final String select_column="id,enterPriseId,grade,description,violateTime";
    static final String select_column1="id,name,description,createTime,credit";

    @Select(" SELECT " + select_column + " from "+ table)
    List<EnterpriseViolationData> list();

    @Select(" SELECT " + select_column + " from "+ table + " where id = #{id}")
    EnterpriseViolationData getOne(Integer id);

    @Select(" SELECT " + select_column1 + " from "+ table1 + " where id = #{id}")
    EnterpriseBaseInfoData getBaseOne(Integer id);

    @Update(" update " + table1 + " set "
            + "name=" + "#{name},"
            + "description=" + "#{description},"
            + "createTime=" + "#{createTime},"
            + "credit=" + "#{credit}"
            + " where id = #{id}")
    Integer updateBaseInfo(EnterpriseBaseInfoData infoOne);


    @Insert(" INSERT INTO " + table + " (" +
            "enterPriseId,grade,description,violateTime" +
            ")" +
            " VALUES (" +
            "#{enterPriseId},#{grade},#{description},#{violateTime}" +
            ")")
    Integer insert(EnterpriseViolationData test);

    @Update(" update " + table + " set "
            + "enterPriseId=" + "#{enterPriseId},"
            + "grade=" + "#{grade},"
            + "description=" + "#{description},"
            + "violateTime=" + "#{violateTime}"
            + " where id = #{id}")
    Integer update(EnterpriseViolationData test);

    @Delete(" delete from " + table +
            " where id = #{id}")
    Integer delete(Integer id);
}
