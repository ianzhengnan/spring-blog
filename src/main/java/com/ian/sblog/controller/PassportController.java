package com.ian.sblog.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;

@Controller
@RequestMapping("/account")
public class PassportController extends BaseController{

	@RequestMapping("/login") // 只有一个参数时候，可以简写省去value = ""
	public ModelAndView login(@RequestParam(value = "username", required = false) String username, 
							@RequestParam(value = "password", required = false) String password,
							HttpSession httpSession,
							ModelAndView mv) {
		
		User user = us.logon(username, password);
		if (user != null) {
			httpSession.setAttribute(SBlogConstants.USER_SESSION, user);
			mv.setViewName("redirect:/account/main");
		}else {
			// 未来用message class替换
			mv.addObject("message", "登录名和密码错误，请重新登录！");
			mv.setViewName("login");
		}
		return mv;
	}
	
	@RequestMapping(value = "/{formName}", method = RequestMethod.GET)
	public String toForm(@PathVariable String formName){
		if (formName == null || formName.equals("")) {
			formName = "login";
		}
		
		return formName;
	}
	
}
