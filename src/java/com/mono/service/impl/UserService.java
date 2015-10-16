package com.mono.service.impl;

import com.mono.dao.impl.UserDaoImpl;
import com.mono.entity.Users;
import com.mono.service.BaseInterface;
import com.mono.service.UserInterface;
import java.util.List;
import java.util.Map;

/**
 *
 * @author prongbang
 */
public class UserService implements BaseInterface<Users, Integer>, UserInterface {

    private UserDaoImpl userDaoImpl = null;

    public UserService() throws Exception {
        userDaoImpl = new UserDaoImpl();
    }

    @Override
    public List<Users> findAll() throws Exception {
        return userDaoImpl.findAll();
    }

    @Override
    public Users findByPK(Integer pk) throws Exception {
        return userDaoImpl.findByPK(pk);
    }

    @Override
    public Integer findLastPK() throws Exception {
        return userDaoImpl.findLastPK();
    }

    @Override
    public int insert(Users o) throws Exception {
        return userDaoImpl.insert(o);
    }

    @Override
    public int update(Users o) throws Exception {
        return userDaoImpl.update(o);
    }

    @Override
    public int delete(Users o) throws Exception {
        return userDaoImpl.delete(o);
    }

    @Override
    public List<Map<String, Object>> findUserAccount() throws Exception {
        
        return userDaoImpl.findUserAccount();
    }

    @Override
    public List<Users> findUsersAccount() throws Exception {
        
        return userDaoImpl.findUsersAccount();
    }

}
