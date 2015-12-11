package com.schpost.Controller;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.schpost.Dao.UserDAO;
import com.schpost.Service.UserResgisterService;
import com.schpost.Util.EncodingTool;

@Controller
public class UerResgisterController {
	@Autowired
	UserDAO userDao;
	@Autowired
	UserResgisterService urs;
	EncodingTool  encodeUTF_8= new EncodingTool();
	@ResponseBody
	@RequestMapping(value ="UserRegisterServlet",produces = "application/json;charset=UTF-8")
	public String ResgisterUser(HttpServletRequest req) throws NoSuchAlgorithmException, JSONException, UnsupportedEncodingException{
		String username ="";
		String password="";
		String cellphonenum ="";
		String resresult ="";
	
		String infor = req.getParameter("sendInfor");	
		JSONObject json;
		try {
			json = new JSONObject(infor);
			username = json.getString("username");
			//username = new String(json.getString("username").getBytes("UTF-8"), "UTF-8");

			//username = "杨喜兵";
			//username = encodeUTF_8.encodeStr(username);
			password = json.getString("password");
			cellphonenum = json.getString("cellphone_num");
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(username+password+cellphonenum);
		
		int result = urs.ResgisterUser(username,password,cellphonenum);
		if(result ==1){
			resresult = "OK";
		}
		else if(result ==-1){
			resresult = "Failed";
		}	
		JSONObject resjson= new JSONObject();
		resjson.put("resultinfo",resresult);
		return resjson.toString(); 
	 
	}
}
	
