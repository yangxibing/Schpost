package com.schpost.Controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.schpost.Service.OrderService;
import com.schpost.Service.UserService;
import com.schpost.entity.User;

@Controller
public class UserController {
	@Autowired
	UserService us;
	@Autowired
	OrderService osr;
	
	
	@RequestMapping("AdminUserServlet")
	@ResponseBody
	public ModelAndView getAllUsers(HttpServletRequest req){
		
		ArrayList<User> users  = us.DisplayAllUsers();
		ModelMap modelmap = new ModelMap();
		modelmap.put("users", users);
		return new ModelAndView("user", modelmap);
		//return new ModelAndView("user");
		
	}
	@RequestMapping("user-delete")
	@ResponseBody
	public String deleteUser(HttpServletRequest req){
		String id = req.getParameter("userID");
		System.out.println(id);
		int result = us.deleteUser(id);
		String deleteInfor ="";
		if(result ==1){
			deleteInfor = "delete sucessful";
		}
		
	    return deleteInfor;
	}
	
	@RequestMapping("UserUpdateServlet")
	@ResponseBody
	public String modifyPoster(HttpServletRequest req){
		String id = "";
		String username ="";
		String password="";
		String newpassword ="";
		String phone ="";
		
		String infor = req.getParameter("sendInfor");
		JSONObject json;
		try {
			json = new JSONObject(infor);
			id =  json.getString("iduser");
			username = json.getString("name");
			password = json.getString("password");
			newpassword = json.getString("new_password");
			phone = json.getString("cellphone_num");
			
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		System.out.println(id+username+password+newpassword+phone);
		Map<String, Object> result = us.modifyUser(id,username,password,newpassword,phone);
		if(result!=null && !result.toString().equals("[]")){
	    	 JSONObject jsonres = new JSONObject(result);
	    	 System.out.println("modify sucess");
	    	 return jsonres.toString();
	     }else{
	    	 return "Failed to mofify!";
	     }
	}
	@RequestMapping("UserDeleteOrderServlet")
	@ResponseBody
	public String deleteOrder(HttpServletRequest req){
		String infor = req.getParameter("sendInfor");
		String id="";
		JSONObject json;
		try {
			json = new JSONObject(infor);
			id =  json.getString("id");
			
			
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(id ==null){
			return "failed";
		}
		System.out.println(id);
		int result = osr.UserDeleteOrder(id);
		String deleteInfor ="";
		if(result ==1){
			deleteInfor = "delete sucessful";
		}
		
	    return deleteInfor;
	}
	@RequestMapping("UserVerifyOrderServlet")
	@ResponseBody
	public String assertOrder(HttpServletRequest req){
		String infor = req.getParameter("sendInfor");
		String id="";
		JSONObject json;
		try {
			json = new JSONObject(infor);
			id =  json.getString("id");
			
			
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(id ==null){
			return "failed";
		}
		System.out.println(id);
		int result = osr.UserAssertOrder(id);
		String deleteInfor ="";
		if(result ==1){
			deleteInfor = "assert sucessful";
		}
		
	    return deleteInfor;
	}

}
