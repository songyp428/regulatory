package pers.songyanping.regulatory.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import pers.songyanping.regulatory.model.VehicleDamageData;

import java.util.List;

public interface VehicleDamageDao {
    static final String insert_column ="name";
    static final String table = "vehicleDamage";
    static final String select_column="bikeId,description,credit,isUsing";

    @Select(" SELECT " + select_column + " from "+ table)
    List<VehicleData> list();

    @Select(" SELECT " + select_column + " from "+ table + " where bikeId = #{bikeId}")
    VehicleData getOne(String bikeId);

    @Insert(" INSERT INTO " + table + " (" +
            "bikeId,enterprise,cardType,deliveryTime" +
            ")" +
            " VALUES (" +
            "#{bikeId},#{description},#{credit},#{isUsing}" +
            ")")
    Integer insert(VehicleData test);

    @Update(" update " + table + " set "
            + "description=" + "#{description},"
            + "credit=" + "#{credit},"
            + "isUsing=" + "#{isUsing}"
            + " where bikeId = #{bikeId}")
    Integer update(VehicleData test);

    @Delete(" delete from " + table +
            " where bikeId = #{bikeId}")
    Integer delete(String bikeId);
}
