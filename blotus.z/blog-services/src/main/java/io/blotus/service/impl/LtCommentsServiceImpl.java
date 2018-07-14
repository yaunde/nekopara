package io.blotus.service.impl;

import io.blotus.mapper.ILtCommentsDao;
import io.blotus.model.entity.LtComments;
import io.blotus.service.ILtCommentsService;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 文章评论信息表 服务实现类
 * </p>
 *
 * @author zzq123
 * @since 2018-03-06
 */
@Service
public class LtCommentsServiceImpl extends ServiceImpl<ILtCommentsDao, LtComments> implements ILtCommentsService {

}
