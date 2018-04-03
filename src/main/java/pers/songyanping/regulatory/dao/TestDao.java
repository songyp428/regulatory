package pers.songyanping.regulatory.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import pers.songyanping.regulatory.model.Test;

import java.util.List;

public interface TestDao {

    static final String insert_column ="name";
    static final String table = "test";
    static final String select_column="id,name";

    @Select(" SELECT " + select_column + " from "+ table)
    List<Test> list();

    @Insert(" INSERT INTO " + table + " (" +
            "name" +
            ")" +
            " VALUES (" +
            "#{name}" +
            ")")
    Integer insert(Test test);

    @Update(" update " + table + " set " +
            "name=" +
            "#{name}" +
            " where id = #{id}")
    Integer update(Test test);

    @Delete(" delete from " + table +
            " where id = #{id}")
    Integer delete(String id);
}

