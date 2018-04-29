package pers.songyanping.regulatory.service;

import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.songyanping.regulatory.dao.UserDao;
import pers.songyanping.regulatory.model.UserData;

import javax.management.relation.Role;
import java.util.List;
@Service
public class UserService {

    @Autowired

    UserDao userDao;
    public Integer addUser(UserData test){
        return userDao.insert(test);
    }

    public List<UserData> queryUserList(){
        return userDao.list();
    }

    public Integer deleteUser(Integer id){
        return userDao.delete(id);
    }

    public Integer updateUser(UserData test){
        return userDao.update(test);
    }

    public UserData queryUserById(Integer id){
        return userDao.getOne(id);
    }
}
