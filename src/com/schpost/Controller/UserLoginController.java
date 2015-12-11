package com.schpost.Controller;

import java.security.NoSuchAlgorithmException;


import javax.servlet.http.HttpServletRequest;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.schpost.Service.LoginService;

/*
 author yangxibing
 */
@Controller
public class UserLoginController {
	@Autowired
	LoginService loginservice;
	@RequestMapping("UserLoginServlet")
	@ResponseBody
	public String getRequest(HttpServletRequest req) throws NoSuchAlgorithmException{
		String username ="";
		String password="";
		
		String infor = req.getParameter("sendInfor");
		JSONObject json;
		try {
			json = new JSONObject(infor);
			username = json.getString("username");
			password = json.getString("password");
			
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(username+password);
	     Map<String, Object> result = loginservice.userLogin(username, password, req);
	     
	     if(result!=null && !result.toString().equals("[]")){
	    	 JSONObject jsonres = new JSONObject(result);
	    	 return jsonres.toString();
	     }else{
	    	 return "Failed to Login!";
	     }
	    }
	
	

}
