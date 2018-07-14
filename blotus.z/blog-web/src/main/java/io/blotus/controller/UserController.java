package io.blotus.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.blotus.common.result.JsonResult;
import io.blotus.model.entity.LtUsers;
import io.blotus.model.entity.User;
import io.blotus.model.enums.TypeEnum;
import io.blotus.service.ILtUsersService;
import io.blotus.service.IUserService;

@Controller
public class UserController {

	@Autowired
    private IUserService userService;
	@Autowired
    private ILtUsersService ltUuserService;

    @RequestMapping("/_user")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("index");
        //modelAndView.addObject("userList", userService.selectList());
        return modelAndView;
    }
  
    
    @RequestMapping(value="/_showUser")
    @ResponseBody
    public JsonResult<?> showUser() {

    	User userByEmail = userService.getUserByEmail("9537302134");
    	if (userByEmail != null) {
    		return JsonResult.success("查询成功！", userByEmail);
		}
    	return JsonResult.failure("查询失败！");
    }
    
    @RequestMapping(value="/_userList")
    @ResponseBody
    public JsonResult<?> showUsers() {
    	List<User> userList = userService.selectList(null);
    	if (userList != null && !userList.isEmpty()) {
    		return JsonResult.success("查询成功！", userList);
		}
    	return JsonResult.failure("查询失败！");
    }
    
    @RequestMapping(value="/adduser")
    @ResponseBody
    public JsonResult<?> adduser() {

    	User user = new User();
    	user.setAge(12);
    	user.setCtime(new Date());
    	user.setName("zhanzhiqiang03");
    	user.setType(TypeEnum.NORMAL);
    	
    	LtUsers ltUsers = new LtUsers();
    	ltUsers.setUserEmail("953720113@qq.com");
    	ltUsers.setUserLogin("zhanz01");
    	ltUsers.setUserNicename("占占");
    	ltUsers.setUserRegistered(new Date());
    	ltUsers.setUserPass("123456");
    	
    	boolean flag = userService.testTrasation(user,ltUsers);
    	if (flag) {
    		return JsonResult.success("查询成功！", user);
		}
    	return JsonResult.failure("查询失败！");
    }

}
