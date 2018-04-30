package pers.songyanping.regulatory.dao;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;
import pers.songyanping.regulatory.model.GeofenceTypeData;
import java.util.List;
public interface GeofenceTypeDao {
    static final String table = "geofenceType";
    static final String select_column="fencingTypeId,fencingTypeName";

    @Select(" SELECT " + select_column + " from "+ table)
    List<GeofenceTypeData> list();

    @Select(" SELECT " + select_column + " from "+ table + " where fencingTypeId = #{fencingTypeId}")
    GeofenceTypeData getOne(Integer fencingTypeId);

    @Insert(" INSERT INTO " + table + " (" +
            select_column +
            ")" +
            " VALUES (" +
            "#{fencingTypeId},#{fencingTypeName}" +
            ")")
    Integer insert(GeofenceTypeData test);

    @Update(" update " + table + " set "
            + "fencingTypeName=" + "#{fencingTypeName}"
            + " where fencingTypeId = #{fencingTypeId}")
    Integer update(GeofenceTypeData test);

    @Delete(" delete from " + table +
            " where fencingTypeId = #{fencingTypeId}")
    Integer delete(Integer fencingTypeId);
}
