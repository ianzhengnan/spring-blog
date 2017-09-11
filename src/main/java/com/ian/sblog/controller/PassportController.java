package com.ian.sblog.controller;

import javax.servlet.http.HttpSession;
import javax.xml.ws.http.HTTPBinding;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;
import com.ian.sblog.domain.Message;
import com.ian.sblog.util.SendSMS;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;

@Controller
@RequestMapping("/account")
public class PassportController extends BaseController{

	private Message msg = new Message();

	@RequestMapping(value = "/login", method = RequestMethod.POST) // 只有一个参数时候，可以简写省去value = ""
	public ModelAndView handleLogin(@RequestParam(value = "username", required = false) String username, 
							@RequestParam(value = "password", required = false) String password,
							HttpSession httpSession,
							ModelAndView mv) {
		
		log.debug("PassportController >> login");
		
		User user = us.logon(username, password);
		if (user != null) {
			httpSession.setAttribute(SBlogConstants.USER_SESSION, user);
			mv.setViewName("redirect:../main");
		}else {
			// 未来用message class替换
			mv.addObject("message", "登录名和密码错误，请重新登录！");
			mv.setViewName("login"); // 这里的loginPage是loginPage.jsp的名字
		}
		return mv;
	}

	@GetMapping("/smslogin")
	public String smsLogin(){
		return "signin";
	}

	@PostMapping("/smslogin")
	public ModelAndView handleSmsLogin(ModelAndView mv, String phone, String smscode, HttpSession httpSession){
		String smsOrigin = (String)httpSession.getAttribute("smscode");
		if (smscode.equals(smsOrigin)){
			User user = us.getUserByPhone(phone);
			httpSession.setAttribute(SBlogConstants.USER_SESSION, user);
			mv.setViewName("redirect:../main");
		}else{
			mv.addObject("message", "验证码错误，请重新登录！");
			mv.setViewName("signin");
		}
		return mv;
	}

	@PostMapping("/sendSMS")
	@ResponseBody
	public Message sendSms(String phone, HttpSession httpSession) throws ClientException, InterruptedException{

		int number = (int)((Math.random() * 9 + 1) * 100000);
		String smscode = String.valueOf(number);
		SendSmsResponse response = SendSMS.sendSms(phone, smscode);
		if (!response.getCode().equals("OK")){
			msg.setErr(response.getMessage());
			return msg;
		}
		httpSession.setAttribute("smscode", smscode);
		msg.setMsg(phone);
		return msg;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login() {
		return "login"; //jsp文件名
	}

	@RequestMapping("/logout")
	public String logout(HttpSession httpSession) {
		if(httpSession.getAttribute(SBlogConstants.USER_SESSION) != null) {
			httpSession.removeAttribute(SBlogConstants.USER_SESSION);			
		}
		return "redirect:" + SBlogConstants.LOGIN;
	}
	
	@RequestMapping(value = "/signup")
	public ModelAndView signup(String show, ModelAndView mv, @ModelAttribute User user, HttpSession httpSession) {
		
		if (show.equals("1")) {
			mv.setViewName("user/signup");
		}else {
			if (!us.checkUsername(user)) {
				us.register(user);
				httpSession.setAttribute(SBlogConstants.USER_SESSION, user);
				mv.setViewName("redirect:../main");
			}else {
				mv.addObject("message", "用户名已经存在");
				mv.setViewName("user/signup");
			}
		}
		return mv;
	}
	
}
