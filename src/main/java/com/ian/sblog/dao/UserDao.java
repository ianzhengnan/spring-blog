package com.ian.sblog.dao;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectProvider;
import org.apache.ibatis.annotations.UpdateProvider;

import com.ian.sblog.dao.provider.UserDynaSqlProvider;
import com.ian.sblog.domain.User;
import static com.ian.sblog.util.SBlogConstants.USERTABLE;

import java.util.List;
import java.util.Map;

public interface UserDao {

	/**
	 * Get user by username and password
	 * @param username
	 * @param password
	 * @return
	 */
	@Select("select * from " + USERTABLE + " where username = #{username} and password = #{password}")
	User selectByUsernameAndPassword(@Param("username") String username, @Param("password") String password);
	
	/**
	 * Get user by id
	 * @param id
	 * @return
	 */
	@Select("select * from " + USERTABLE + " where id = #{id}")
	User selectById(Integer id);
	
	/**
	 * Delete user by id
	 * @param id
	 */
	@Delete("delete from " + USERTABLE + " where id = #{id}")
	void deleteById(Integer id);
	
	// Dynamic operations
	/**
	 * Dynamic update user
	 * @param user
	 */
	@UpdateProvider(type = UserDynaSqlProvider.class, method = "updateUser")
//	@Update("update ")
	void updateUser(User user);
	
	/**
	 * Dynamic query users
	 * @param params
	 * @return
	 */
	@SelectProvider(type = UserDynaSqlProvider.class, method = "selectWithParam")
	List<User> selectByPage(Map<String, Object> params);
	
	/**
	 * Dynamic get user count
	 * @param params
	 * @return
	 */
	@SelectProvider(type = UserDynaSqlProvider.class, method = "count")
	Integer count(Map<String, Object> params);
	
	/**
	 * Dynamic insert user
	 * @param user
	 */
	@SelectProvider(type = UserDynaSqlProvider.class, method = "insertUser")
	void save(User user);
}
