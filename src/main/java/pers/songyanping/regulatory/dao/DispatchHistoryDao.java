package pers.songyanping.regulatory.dao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import pers.songyanping.regulatory.model.DispatchHistoryData;

import java.util.List;
public interface DispatchHistoryDao {
    static final String insert_column ="enterprise,inputPoint,inputLngLat,outputPoint,outputLngLat,deliveryTime";
    static final String table = "dispatchHistory";
    static final String select_column="id,enterprise,inputPoint,inputLngLat,outputPoint,outputLngLat,deliveryTime";

    @Select(" SELECT " + select_column + " from "+ table)
    List<DispatchHistoryData> list();

    @Select(" SELECT " + select_column + " from "+ table + " where id = #{id}")
    DispatchHistoryData getOne(Integer id);

    @Insert(" INSERT INTO " + table + " (" +
            "enterprise,inputPoint,inputLngLat,outputPoint,outputLngLat,deliveryTime" +
            ")" +
            " VALUES (" +
            "#{enterprise},#{inputPoint},#{inputLngLat},#{outputPoint},#{outputLngLat},#{deliveryTime}" +
            ")")
    Integer insert(DispatchHistoryData test);

    @Update(" update " + table + " set "
            + "enterprise=" + "#{enterprise},"
            + "inputPoint=" + "#{inputPoint},"
            + "inputLngLat=" + "#{inputLngLat},"
            + "outputPoint=" + "#{outputPoint},"
            + "outputLngLat=" + "#{outputLngLat},"
            + "deliveryTime=" + "#{deliveryTime}"
            + " where id = #{id}")
    Integer update(DispatchHistoryData test);

    @Delete(" delete from " + table +
            " where id = #{id}")
    Integer delete(Integer id);
}
