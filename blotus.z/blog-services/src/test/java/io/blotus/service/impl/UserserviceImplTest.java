package io.blotus.service.impl;

import io.blotus.model.entity.User;
import io.blotus.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath*:spring/spring-*.xml")
public class UserserviceImplTest {
    @Autowired
    private IUserService userService;

    @Test
    public void testFindByEmail(){
        User user = userService.getUserByEmail("981090649945714690");
        System.out.println(user.getName());
    }
}
