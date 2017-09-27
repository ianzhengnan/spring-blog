package com.ian.sblog.x4.chapter20;

import com.ian.sblog.domain.User;
import org.testng.annotations.Test;
import org.unitils.reflectionassert.ReflectionAssert;

public class AssertReflectEqualsTest {

    @Test
    public void testReflectEquels(){
        User user1 = new User("tom", "tom1234");
        User user2 = new User("tom", "tom1234");
        ReflectionAssert.assertReflectionEquals(user1, user2);
        ReflectionAssert.assertPropertyReflectionEquals("username", "tom", user1);
        ReflectionAssert.assertPropertyLenientEquals("qq", null, user1);
    }
}
