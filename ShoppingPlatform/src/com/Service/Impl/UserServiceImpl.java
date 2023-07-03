package com.Service.Impl;
import com.DAO.Impl.UserDaoImpl;

import org.junit.Test;

import com.DAO.UserDao;
import com.Entity.User;
import com.Service.UserService;

public class UserServiceImpl implements UserService {
    private UserDao userDao;
    public boolean loginCheck(User user){
        boolean result =false;
        userDao = new UserDaoImpl();
        User returnUser = userDao.selbyUsername(user);
        if(returnUser==null)
            return false;
        if(returnUser.getPassword().equals(user.getPassword()))
            result = true;
        return result;

    }
    public boolean registUser(User user) {
    	boolean result =false;
    	
    	userDao = new UserDaoImpl();
    	User user2 = userDao.selbyUsername(user);
    	if(user2!=null)
    		return result;
    	int i =userDao.insertUser(user);
    	if(i>0) 
    		result=true;
    	return result;
    }

@Test
public void testRegisterUser() {
	User user =new User();
	user.setUsername("k");
	user.setPassword("123");
	user.setAge(22);
	user.setGender("female");
	user.setEmail("111@qq.com");
	boolean result = this.registUser(user);
	System.out.println(result);
}}
