package pers.songyanping.regulatory.dao;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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
}

