package com.ian.sblog.x4.chapter15.cachegroup;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service(value = "cacheGroupUserService")
public class UserService {
    private Map<Integer, User> users = new HashMap<>();

    {
        users.put(1, new Member("1", "w1", 36));
        users.put(2, new Visitor("2", "w2", 23));
    }

    @Caching(cacheable = {
            @Cacheable(cacheNames = "members", condition = "#user instanceof T(com.ian.sblog.x4.chapter15.cachegroup.Member)"),
            @Cacheable(cacheNames = "visitors", condition = "#user.age > 35")
    })
    public User getUser(User user){
        System.out.println("real retrieving data from DB...." + user.toString());
        return users.get(Integer.valueOf(user.getId()));
    }
}
