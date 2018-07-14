package io.blotus.mapper;

import io.blotus.common.SuperMapper;
import io.blotus.model.entity.LtUsers;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author zzq123
 * @since 2018-03-06
 */
public interface ILtUsersDao extends SuperMapper<LtUsers> {
	
	LtUsers selectByEmail(String eMail);
}
