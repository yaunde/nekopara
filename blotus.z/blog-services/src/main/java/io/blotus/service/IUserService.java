package io.blotus.service;

import com.baomidou.mybatisplus.service.IService;

import io.blotus.model.entity.LtUsers;
import io.blotus.model.entity.User;

public interface IUserService extends IService<User> {
	
	User getUserByEmail(String email);
	
	boolean testTrasation(User user, LtUsers user2);
	
	boolean insertTestTrasation(User user, LtUsers user2);

}
