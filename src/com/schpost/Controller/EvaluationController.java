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

import com.schpost.Service.EvaluationService;

@Controller
public class EvaluationController  {
	

	
	@Autowired
	EvaluationService es;
	@ResponseBody
	@RequestMapping(value ="UserAddEvaluationServlet",produces = "application/json;charset=UTF-8")
	public String addEvaluation(HttpServletRequest req) throws NoSuchAlgorithmException, JSONException, UnsupportedEncodingException{
        String idUser = "";
		String idOrder  ="";
		String content = "";
		String level = "";
		String infor = req.getParameter("sendInfor");	
		JSONObject json;
		try {
			json = new JSONObject(infor);
			idUser = json.getString("iduser");
			idOrder = json.getString("idorder");
			level = json.getString("level");
			content = json.getString(content);
		}catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String resresult ="";
		System.out.println(idUser+idOrder+level+content);
		int result = es.addEvaluation(idOrder,level,content);
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