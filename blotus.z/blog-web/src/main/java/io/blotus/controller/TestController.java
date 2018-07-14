package io.blotus.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/test")
public class TestController {
	
	@RequestMapping("/testfm")
	public String testfm(Model model) {
		
		return "freemarker-test/test";
	}
}
