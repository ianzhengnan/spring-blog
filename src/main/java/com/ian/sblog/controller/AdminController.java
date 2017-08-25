package com.ian.sblog.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ian.sblog.domain.Article;
import com.ian.sblog.domain.Category;
import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;
import com.ian.sblog.validator.ArticleValidator;

@Controller
public class AdminController extends BaseController{

	@Autowired
	@Qualifier("articleValidator") // what is useful?
	private ArticleValidator articleValidator;
	
	@GetMapping("/postedit")
	public String showPostEdit(Model model, HttpSession httpSession, @ModelAttribute Article article) {
		User user = (User)httpSession.getAttribute(SBlogConstants.USER_SESSION);
		List<Category> categories = cats.getCategoriesByUser(user.getId());
		model.addAttribute("categories", categories);
		return "admin/posteditadd";
	}
	
	@PostMapping("/postedit")
	public ModelAndView postArticle(String isPub, @ModelAttribute Article article, 
			 HttpSession httpSession, Errors errors) {
		
		User user = (User)httpSession.getAttribute(SBlogConstants.USER_SESSION);		
		ModelAndView mv = new ModelAndView();
		List<Category> categories = cats.getCategoriesByUser(user.getId());
		mv.addObject("categories", categories);
		
		articleValidator.validate(article, errors);
		
		if (errors.hasErrors()) {
			mv.setViewName("admin/posteditadd");
			return mv;
		}
		
		if (article.getId() == null) {
			article.setCreateBy(user);
			arts.createArticle(article);
		}
		
		if (isPub != null && isPub.equals("1")) {
			article.setStatus("publish");
			article.setCreateAt(new Date());
			mv.setViewName("redirect:/" + user.getUsername() + "/article/" + article.getId());
		}else {
			article.setStatus("draft");
			mv.setViewName("admin/posteditadd");
		}
		
		arts.updateArticle(article);
		return mv;
	}
	

	
}
