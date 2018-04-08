package pers.songyanping.regulatory.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import pers.songyanping.regulatory.model.VehicleData;

import java.util.List;

public interface VehicleManagementDao {

    static final String insert_column ="name";
    static final String table = "vehicleBase";
    static final String select_column="bikeId,enterprise,cardType,deliveryTime";

    @Select(" SELECT " + select_column + " from "+ table)
    List<Test> list();

    @Insert(" INSERT INTO " + table + " (" +
            "bikeId,enterprise,cardType,deliveryTime" +
            ")" +
            " VALUES (" +
            "#{bikeId},#{enterprise},#{cardType},#{deliveryTime}" +
            ")")
    Integer insert(VehicleData test);

    @Update(" update " + table + " set "
            + "enterprise=" + "#{enterprise},"
            + "cardType=" + "#{cardType},"
            + "deliveryTime=" + "#{deliveryTime}"
            " where bikeId = #{bikeId}")
    Integer update(VehicleData test);

    @Delete(" delete from " + table +
            " where bikeId = #{bikeId}")
    Integer delete(String bikeId);
}

