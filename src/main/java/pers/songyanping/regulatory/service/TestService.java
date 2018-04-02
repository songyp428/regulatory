package pers.songyanping.regulatory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.songyanping.regulatory.dao.TestDao;
import pers.songyanping.regulatory.model.Test;

@Service
public class TestService {

    @Autowired
    TestDao testDao;

    public Integer addTest(Test test){
        testDao.insert(test);
        return 1;
    }
}
