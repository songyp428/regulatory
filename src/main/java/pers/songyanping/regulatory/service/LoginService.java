package pers.songyanping.regulatory.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.songyanping.regulatory.dao.LoginDao;
import pers.songyanping.regulatory.model.UserData;

import javax.management.relation.Role;
import java.util.List;
@Service
public class LoginService {
    @Autowired

    LoginDao loginDao;
    public  List<UserData> getAllUser(){
        return loginDao.list();
    }
}
