package com.itgod.action;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.itgod.entity.User;
import com.itgod.service.UserService;

@RestController
public class UserHandler {

	@Resource
	private UserService userService;

	   @RequestMapping("/helloHtml")  
	    public String helloHtml(Map<String,Object> map){  
	       map.put("hello","from TemplateController.helloHtml");  
	       return"/helloHtml"; 
	    } 

	@RequestMapping(value = "/show")
	public String show() {
		return userService.show();
	}

	@RequestMapping(value = "/getId", method = RequestMethod.GET)
	public User getId(String id) {
		return userService.showDao(id);
	}

	@RequestMapping(value = "/insert")
	public String insert() {
		User user = new User();
		user.setId("3");
		user.setUseEma("maasdasd");
		user.setUsePho("7411gdfg2");
		try {
			userService.insert(user);
			return "插入成功";
		} catch (Exception e) {
			e.printStackTrace();
			return "插入失败";
		}
	}

}
