package io.blotus.controller;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import io.blotus.common.result.JsonResult;
import io.blotus.model.entity.LtUsers;
import io.blotus.service.ILtUsersService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author zzq123
 * @since 2018-03-06
 */
@Controller
@RequestMapping("/users")
public class LtUsersController {

	@Autowired
	private ILtUsersService userService;
	
	@RequestMapping("/login")
    public ModelAndView index(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        //modelAndView.addObject("userList", userService.selectList());
        return modelAndView;
    }
	
	@RequestMapping("/getUsers")
	@ResponseBody
	public JsonResult<?> getUsers(){
		List<LtUsers> userlist = userService.selectList(null);
		if (null != userlist && !userlist.isEmpty()) {
			return JsonResult.success("查询成功", userlist);
		}
		return JsonResult.failure("chaxunshibai");
	}
}

