package com.Service;
import com.Entity.User;

public interface UserService {
    public boolean loginCheck(User user);
    public boolean registUser(User user);
   
}
