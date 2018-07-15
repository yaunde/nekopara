package io.blotus.mapper;

import io.blotus.common.utils.SpringContextHelper;
import io.blotus.model.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath*:spring/spring-mybatis.xml"})
public class UserDaoTest {

  @Autowired
  private IUserDao userDao;

  @Test
  public void testFindById() {

    ApplicationContext applicationContext = SpringContextHelper.getApplicationContext();
    System.out.println(applicationContext+"  -134455");

    User user = userDao.selectById("784972358981328903");
    System.out.println(user+" =======");


  }
}
