package com.DAO;
import com.Entity.User;

public interface UserDao {
    public User selbyUsername(User user);
    public int insertUser(User user);
	
    
}
