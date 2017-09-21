package com.ian.sblog.x4.chapter15.guava;

import com.ian.sblog.x4.chapter15.cachegroup.User;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service(value = "guavaUserService")
public class UserService {

    private Map<Integer, User> users = new HashMap<>();

    {
        users.put(1, new User("1", "Ian Zheng", 36));
        users.put(2, new User("2", "Kaka", 23));
    }

    @Cacheable(cacheNames = "users", condition = "#user.age > 35")
    public User getUser(User user){
        System.out.println("User with id  " + user.getId() + " required.");
        return users.get(Integer.valueOf(user.getId()));
    }
}
