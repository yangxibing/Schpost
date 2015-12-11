package com.schpost.Controller;

import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.schpost.Service.ContactService;
import com.schpost.Util.EncodingTool;


@Controller
public class ContactController {
	@Autowired
	ContactService contactService;
	EncodingTool  encodeUTF_8= new EncodingTool();
	@ResponseBody
	@RequestMapping(value ="UserReceiversServlet",produces = "application/json;charset=UTF-8")
	public String getRequest(HttpServletRequest req)
			throws NoSuchAlgorithmException {
		Integer userid = 0;
		String infor = req.getParameter("sendInfor");
		JSONObject json;
		try {
			json = new JSONObject(infor);
			userid = json.getInt("iduser");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		List<Map<String, Object>> contactList = contactService
				.getUserContacts(userid);
		System.out.println(contactList.size());
		System.out.println(contactList.toString());
		if (contactList != null && !contactList.toString().equals("[]")) {
			JSONArray jsonres = new JSONArray(contactList);
			// System.out.println(jsonres.toString());
			return encodeUTF_8.encodeStr(jsonres.toString());

		} else {
			return "列表为空";
		}

	}


	@ResponseBody
	@RequestMapping("UserDeleteReceiverServlet")
	public String deleteContact(HttpServletRequest request) {
		Integer id = 0;
		String infor = request.getParameter("sendInfor");
		JSONObject json;
		try {
			json = new JSONObject(infor);
			id = json.getInt("id");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(id);
		int result = contactService.deleteContact(id);
		if (result == 1) {
			System.out.println("delete OK!");
			return "delete OK!";
			
		} else {
			return "failed";
		}

	}

	@RequestMapping("UserAddReceiverServlet")
	@ResponseBody
	public String addContact(HttpServletRequest request) {
		Integer userid = 0;
		String name = "";
		String phone = "";
		String address = "";
		String infor = request.getParameter("sendInfor");
		JSONObject json;
		try {
			json = new JSONObject(infor);
			userid = json.getInt("iduser");
			name = json.getString("name");
			phone = json.getString("cellphone_num");
			address = json.getString("address");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result = contactService.addContact(userid, name, phone, address);
		if (result == 1) {
			return "delete OK!";
		} else {
			return "failed";
		}

	}
	
	@RequestMapping("UserModifyReceiverServlet")
	@ResponseBody
	public String modifyContact(HttpServletRequest request) {
		Integer idcontact = 0;
		String name = "";
		String phone = "";
		String address = "";
		String infor = request.getParameter("sendInfor");
		JSONObject json;
		try {
			json = new JSONObject(infor);
			idcontact = json.getInt("idcontact");
			name = json.getString("name");
			phone = json.getString("cellphone_num");
			address = json.getString("address");
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result = contactService.modifyContact(idcontact, name, phone, address);
		if (result == 1) {
			return "modify OK!";
		} else {
			return "failed";
		}

	}

}
