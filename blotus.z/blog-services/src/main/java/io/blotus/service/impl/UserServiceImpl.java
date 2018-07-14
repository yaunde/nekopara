package io.blotus.service.impl;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.baomidou.mybatisplus.service.impl.ServiceImpl;

import io.blotus.mapper.ILtUsersDao;
import io.blotus.mapper.IUserDao;
import io.blotus.model.entity.LtUsers;
import io.blotus.model.entity.User;
import io.blotus.service.IUserService;

@Service
public class UserServiceImpl extends ServiceImpl<IUserDao, User> implements IUserService{

	@Autowired
	private IUserDao userDao;
	@Autowired
	private ILtUsersDao ltUserDao;
	
	@Override
	public User getUserByEmail(String email) {
		User user = new User();
		user.setName(email);
		user.setAge(24);
		user.setCtime(new Date());
		return user;
	}

//	@Transactional(rollbackFor=Exception.class)
	@Override
	@Transactional()
	public boolean insertTestTrasation(User user, LtUsers user2) {
		Integer states = 0;
		states = userDao.insert(user);
		
		states = ltUserDao.insert(user2);
	
		if (states > 0) {
			return true;
		}
		return false;
	}

	@Override
	//@Transactional(rollbackFor=Exception.class)
	@Transactional()
	public boolean testTrasation(User user, LtUsers user2) {

		boolean b = insertTestTrasation(user, user2);
		/*try {
			b = insertTestTrasation(user, user2);
		} catch (Exception e) {
			e.printStackTrace();
		}*/
		return b;
	}

}
