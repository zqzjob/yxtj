package com.yxtj.user.controller;

import java.util.Date;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yxtj.base.controller.BaseController;
import com.yxtj.user.service.IUserService;
import com.yxtj.user.vo.User;
@Controller
public class UserController extends BaseController<User>{
	@Autowired
	private IUserService userService;
	
	@RequestMapping("/register")
	public String addUserView(){
		return "/WEB-INF/view/jsp/user/userEdit.jsp";
	}
	@RequestMapping("/addUser")
	@ResponseBody
	public String addUser(User user){
		user.setId(UUID.randomUUID().toString());
		user.setCreatetime(new Date());
		userService.add(user);
		return "success";
	}
	@RequestMapping("/login")
	public String login(ModelMap model,String username,String password){
		User login = userService.login(username, password);
		if(login != null){
			model.put("login", login);
			return "/WEB-INF/view/jsp/common/main.jsp";
		}
		model.put("eMsg", "用户名或密码错误");
		return "/index.jsp";
	}
}
