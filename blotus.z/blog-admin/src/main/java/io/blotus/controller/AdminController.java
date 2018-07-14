package io.blotus.controller;

import java.text.MessageFormat;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

//@RequestMapping("/admin")
@Controller
public class AdminController {
	
	/**
	 * 首页
	 * @param modelMap
	 * @return 首页
	 */
	@GetMapping(value={"","/","/index","/login","/admin"})
	public String index(ModelMap modelMap) {
		modelMap.addAttribute("test", "测试");
		return "sign-in";
	}
	
	/**
	 * 博客
	 * @param modelMap
	 * @return
	 */
	@GetMapping(value="/blog")
	public String blog(ModelMap modelMap) {
		return "blog";
	}
	
	/**
	 * 登录页
	 * @param modelAndView
	 * @return
	 */
	@GetMapping(value="/login")
	public ModelAndView login(ModelAndView modelAndView) {
        modelAndView.setViewName("login");
        modelAndView.addObject("test", "测试");
        return modelAndView;
    }
	
	/**
	 * 文章
	 * @param model
	 * @return
	 */
	@GetMapping(value="/article")
	public String article(Model model) {
		
		//MessageFormat
		
		return "article";
	}
	
	/**
	 * 链接
	 * @param model
	 * @return
	 */
	@GetMapping(value="/link")
	public String link(Model model) {
		return "link";
	}
	
	/**
	 * 归档
	 * @param model
	 * @return
	 */
	@GetMapping(value="/archives")
	public String archive(Model model) {
		return "archive";
		
	}
	
	/**
	 * 留言
	 * @param model
	 * @return
	 */
	@GetMapping(value="/message")
	public String message(Model model) {
		return "gustbook";
	}
	
	/**
	 * 更新
	 * @param model
	 * @return
	 */
	@GetMapping(value="/update")
	public String update(Model model) {
		return "update";
	}
	
	/**
	 * 评论
	 * @param model
	 * @return
	 */
	@GetMapping(value="/comments")
	public String comments(Model model) {
		return "comment";
	}
	
	/**
	 * 文章详情
	 * @param model
	 * @return
	 */
	@GetMapping(value="/articleDetail")
	public String articleDetail(Model model) {
		//return "article_detail";
		return "detail";
	}
	
	/**
	 * 关于
	 * @param model
	 * @return
	 */
	@GetMapping(value="/about")
	public String about(Model model) {
		return "about";
	}
}
