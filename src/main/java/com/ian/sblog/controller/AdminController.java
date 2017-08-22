package com.ian.sblog.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import com.ian.sblog.domain.Article;
import com.ian.sblog.domain.Category;
import com.ian.sblog.domain.User;
import com.ian.sblog.util.SBlogConstants;

@Controller
public class AdminController extends BaseController{

	@GetMapping("/postedit")
	public String showPostEdit(Model model, HttpSession httpSession) {
		User user = (User)httpSession.getAttribute(SBlogConstants.USER_SESSION);
		List<Category> categories = cats.getCategoriesByUser(user.getId());
		model.addAttribute("categories", categories);
		return "admin/posteditadd";
	}
	
	@PostMapping("/postedit")
	public ModelAndView postArticle(String isPub, Integer category_id, @ModelAttribute Article article, 
			ModelAndView mv, HttpSession httpSession) {
		
		User user = (User)httpSession.getAttribute(SBlogConstants.USER_SESSION);
		
		if (article.getId() == null) {
			article.setCreateBy(user);
			Category category = new Category();
			category.setId(category_id);
			article.setCategory(category);
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
