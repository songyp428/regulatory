package pers.songyanping.regulatory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.songyanping.regulatory.dao.TestDao;
import pers.songyanping.regulatory.model.Test;

import java.util.List;

@Service
public class TestService {

    @Autowired
    TestDao testDao;

    public Integer addTest(Test test){
        return testDao.insert(test);
    }

    public List<Test> listTest(){
       return testDao.list();
    }

    public Integer deleteTest(String id){
        return testDao.delete(id);
    }

    public Integer updateTest(Test test){
        return testDao.update(test);
    }
}
