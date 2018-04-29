package pers.songyanping.regulatory.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.songyanping.regulatory.dao.RoleDao;
import pers.songyanping.regulatory.model.RoleData;

import javax.management.relation.Role;
import java.util.List;
@Service

public class RoleService {
    @Autowired

    RoleDao roleDao;
    public Integer addRole(RoleData test){
        return roleDao.insert(test);
    }

    public List<RoleData> queryRoleList(){
        return roleDao.list();
    }

    public Integer deleteRole(Integer id){
        return roleDao.delete(id);
    }

    public Integer updateRole(RoleData test){
        return roleDao.update(test);
    }

    public RoleData queryRoleById(Integer id){
        return roleDao.getOne(id);
    }

}
