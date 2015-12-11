package com.schpost.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.schpost.Service.OrderService;
import com.schpost.Service.PosterService;
import com.schpost.Service.UserService;
import com.schpost.Util.EncodingTool;
import com.schpost.entity.Poster;
import com.schpost.entity.User;

@Controller
public class PosterController {
	
	@Autowired
	PosterService us;
	@Autowired
	OrderService osr;
	EncodingTool  encodeUTF_8= new EncodingTool();
	@ResponseBody
	@RequestMapping("AdminPosterServlet")
	
	
	public ModelAndView getAllUsers(HttpServletRequest req){
		ArrayList<Poster> posters  = us.DisplayAllUsers();
		ModelMap modelmap = new ModelMap();
		modelmap.put("posters", posters);
		HttpSession session = req.getSession();
		session.setAttribute("poster", posters.get(0));
		//getData(req);
		return new ModelAndView("poster", modelmap);
		//return new ModelAndView("user");
	}
	
	
	@RequestMapping("poster-delete")
	@ResponseBody
	public String deletePoster(HttpServletRequest req){
		String id = req.getParameter("posterID");
		System.out.println(id);
		int result = us.deletePoster(id);
		String deleteInfor ="";
		if(result ==1){
			deleteInfor = "delete sucessful";
		}
		
	    return deleteInfor;
	}
	
	@RequestMapping("dispatch-order")
	@ResponseBody
	public String dispatchPoster(HttpServletRequest req) throws JSONException{
		String temp = req.getParameter("orderIds");
		String posterid = req.getParameter("posterids");
		System.out.println(temp+posterid);
		int result = osr.dispatchPoster(posterid,temp);
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
	
	@RequestMapping("add-poster")
	@ResponseBody
	public String addPoster(HttpServletRequest req) throws JSONException{
		String postername = req.getParameter("name");
		String posterpassword = req.getParameter("password");
		String posterphone = req.getParameter("phone");
		String posterlevel = req.getParameter("level");
		String posterPlace = req.getParameter("place");
		System.out.println(postername+posterpassword+posterphone+posterlevel);
		int result = us.addPoster(postername, posterpassword, posterphone, posterlevel,posterPlace);
		System.out.println(result);
		JSONObject json = new JSONObject();
		//String addInfor ="";
		if(result ==1){
			
			json.put("addInfor", "OK");
		}
		else if(result == 0){
			json.put("addInfor", "此手机号已被使用"); ;
		}
	    return json.toString();
	}
	
	
	@RequestMapping(value ="PosterLoginServlet",produces = "application/json;charset=UTF-8")
	@ResponseBody
	public String PosterLogin(HttpServletRequest req){
		String infor = req.getParameter("sendInfor");
		String postername ="";
		String password = "";
		System.out.println(infor);
		JSONObject json;
		try {
			json = new JSONObject(infor);
			postername = json.getString("postername");
			password = json.getString("password");
		}catch (JSONException e){
			// TODO Auto-generated catch block
						e.printStackTrace();
		}
		Map<String, Object> posterinfo = new HashMap<String,Object>();
		posterinfo = us.PosterLogin(postername, password);
		 if(posterinfo!=null && !posterinfo.toString().equals("[]")){
	    	 JSONObject jsonres = new JSONObject(posterinfo);
	    	 System.out.println(jsonres.toString());
	    	 return encodeUTF_8.encodeStr(jsonres.toString());
	     }else{
	    	 return "Failed to Login!";
	     }
		
	}
	
	
	

}
