package io.blotus.mapper;

import io.blotus.common.SuperMapper;
import io.blotus.model.entity.User;

public interface IUserDao extends SuperMapper<User>{
	
	User selectByEmail(String eMail);
}
