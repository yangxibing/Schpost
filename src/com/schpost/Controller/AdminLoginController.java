package com.schpost.Controller;


import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import net.sf.json.JSONException;
import net.sf.json.JSONObject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.schpost.Service.AdminLoginService;
import com.schpost.entity.Admin;
/**
 * @author yangxibing
 *
 */
@Controller
public class AdminLoginController {
	@Autowired
	AdminLoginService adLS;
	Admin ad;
	@ResponseBody
	@RequestMapping("admin-login")
	public String getReq(HttpServletRequest req, HttpServletResponse res) throws NoSuchElementException, NoSuchAlgorithmException, JSONException{
		String adName = req.getParameter("adminName");
		String password = req.getParameter("adminPassword");
		System.out.println(adName);
		System.out.println(password);
		int result = adLS.verifyAdmin(req, adName, password);
		JSONObject json = new JSONObject();
		if (result == -1)
		{
			json.put("info", "username does not exist!");
		}
		else if (result == 0)
		{
			json.put("info", "password is wrong!");
		}
		else 
		{
			json.put("info", "OK");
		}
		return json.toString();
	}
	
}

