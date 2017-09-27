package com.ian.sblog.dao;

import com.ian.sblog.test.dataset.util.XlsDataSetBeanFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.unitils.dbunit.annotation.DataSet;
import org.unitils.dbunit.annotation.ExpectedDataSet;
import org.unitils.spring.annotation.SpringBean;
import com.ian.sblog.domain.User;

import java.util.List;

public class UserDaoTest extends BaseDaoTest{

	@SpringBean("userDao")
	private UserDao userDao;
	
	@Test
	@DataSet(value = "UserDao.Users.xls") // 准备数据
	public void findUserByUsernameAndPassword() {

		User user = userDao.selectByUsername("John");
		Assert.assertNull(user, "不存在用户名为John的用户！");

		user = userDao.selectByUsername("wawa");
		Assert.assertNotNull(user, "wawa用户存在！");
		Assert.assertEquals(user.getUsername(), "wawa");
		Assert.assertEquals(user.getPassword(), "wawa12345");

//		User user = userDao.selectByUsernameAndPassword("tony", "tony1234");
//		assertNull("不存在用户tony", user);
//
//		// 创建测试数据
//		user = new User();
//		user.setUsername("tester");
//		user.setPassword("tester1234");
//		userDao.save(user);
//
//		// 测试用户是否存在
//		user = userDao.selectByUsernameAndPassword("tester", "tester1234");
//		assertNotNull("Jan用户存在", user);
//
//		// 测试新增
//		User tester = new User();
//		tester.setUsername("kaka");
//		tester.setPassword("kaka123");
//		tester.setDisplayName("flks");
//		tester.setRealName("Ian zheng");
//		userDao.save(tester);
//		tester = userDao.selectByUsernameAndPassword("kaka", "kaka123");
//		assertNotNull("kaka用户存在", tester);
//
//		//测试更改
//		tester.setDisplayName("zheng nan");
//		userDao.updateUser(tester);
//		tester = userDao.selectById(tester.getId());
//		assertNotEquals("flks", tester.getDisplayName());
//
//		//测试删除
//		userDao.deleteById(tester.getId());
//		tester = userDao.selectByUsernameAndPassword("kaka", "kaka123");
//		assertNull("kaka用户不存在", tester);
//
//		//删除测试数据
//		userDao.deleteById(user.getId());
	}

	// 验证数据库保存的正确性
	@Test
	@ExpectedDataSet(value = "UserDao.ExpectedSaveUser.xls")
	public void testSaveUser() throws Exception{
		//通过XlsDataSetBeanFactory数据集绑定工厂创建测试实体
		userDao.clean();
		User u = XlsDataSetBeanFactory.createBean(UserDaoTest.class, "UserDao.SaveUser.xls", "bg_user",
				User.class);
		userDao.save(u);
	}

	// 验证数据库保存的正确性
	@Test
	@ExpectedDataSet("UserDao.ExpectedSaveUsers.xls")
	public void saveUsers() throws Exception {
		userDao.clean();
		List<User> users = XlsDataSetBeanFactory.createBeans(UserDaoTest.class, "UserDao.SaveUsers.xls",
				"bg_user", User.class);
		for (User user :
				users) {
			userDao.save(user);
		}
	}
}
