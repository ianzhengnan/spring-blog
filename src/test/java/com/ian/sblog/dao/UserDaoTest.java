package com.ian.sblog.dao;

import org.testng.annotations.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.spring.annotation.SpringBean;

import static org.junit.Assert.*;

import com.ian.sblog.domain.User;

public class UserDaoTest extends BaseDaoTest{

	@SpringBean("userDao")
	private UserDao userDao;
	
	@Test
	@DataSet("test.Users.xlsx")
	public void findUserByUsernameAndPassword() {
		User user = userDao.selectByUsernameAndPassword("tony", "tony1234");
		assertNull("不存在用户tony", user);
		user = userDao.selectByUsernameAndPassword("jan", "jan1234");
		assertNotNull("Jan用户存在", user);
	}
	
	
	
}
