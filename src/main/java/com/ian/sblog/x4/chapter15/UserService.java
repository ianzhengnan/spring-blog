package com.ian.sblog.x4.chapter15;

import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;


@Service(value = "userService")
public class UserService {

//    @Cacheable(cacheNames = "users", key = "#user.id") // 先判断有没有缓存，再执行方法，有缓存就读取缓存不执行方法
//    @Cacheable(cacheNames = "users", unless = "#user.age > 35")
//    @CachePut(value = "users" /*,key = "", condition = ""*/) // 先执行方法，然后把方法执行的结果放入缓存
    @Cacheable(cacheNames = "users", condition = "#user.age > 35 && #user.userName.length() > 5")
    public User getUserById(User user){

        System.out.println("Query data from DB..." + user.getId());
        return getFromDB(user.getId());
    }

    // 从缓存中删除符合条件或者key的数据
    @CacheEvict(cacheNames = "users" /*,key = "", condition = "", allEntries = true *, beforeInvocation = true */)
    public void removeUser(User user){

    }

    private User getFromDB(String id){
        System.out.println("real retrieving from DB..." + id);
        return new User(id);
    }
}
