package com.schpost.Controller;

import java.security.NoSuchAlgorithmException;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.schpost.Service.LoginService;
import com.schpost.entity.User;
/*
 author yangxibing
 */
@Controller
public class LoginController {
	@Autowired
	LoginService loginservice;
	@RequestMapping("user-login")
	@ResponseBody
	public ModelAndView getRequest(HttpServletRequest req) throws NoSuchAlgorithmException{
	   	 String userName = req.getParameter("userName");
	   	 String password = req.getParameter("password");
	   	 System.out.println(userName);
	   	 System.out.println(password);
	   //	 int result = loginservice.userLogin(userName, password, req);
	   	 /*
	   	 if (result == 1)
	   	 {
	     	JSONObject json= new JSONObject();
			json.put("info", "OK");
			return json.toString(); 
	   	 }
	   	 else if (result == -1){
	   		JSONObject json= new JSONObject();
			json.put("info", "username does not exist!");
			return json.toString();
	   	 }
	   	 else {
	   		JSONObject json= new JSONObject();
			json.put("info", "password is wrong!");
			return json.toString();
	   	 }
	   	 */
	   	return new ModelAndView("login");
	    }

}
