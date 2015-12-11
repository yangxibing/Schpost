package com.schpost.Controller;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.schpost.Service.OrderService;
import com.schpost.Service.PosterService;
import com.schpost.Util.EncodingTool;
import com.schpost.Util.OrderDetail;
import com.schpost.entity.Orders;
import com.schpost.entity.Poster;

@Controller
public class OrderController {
	
	@Autowired
	OrderService osr;
	
	@Autowired
	PosterService ps;
	EncodingTool  encodeUTF_8= new EncodingTool();
	@ResponseBody
	@RequestMapping("all-order")
	public ModelAndView AllOrder(HttpServletRequest req) {
		System.out.println("all_orders");
		// HttpSession session = req.getSession();
		ArrayList<OrderDetail> orderList = new ArrayList<OrderDetail>();
		orderList = osr.getAllOrders();
		System.out.println(orderList.size());
		ModelMap modelmap = new ModelMap();
		modelmap.put("allorderList", orderList);
		
		return new ModelAndView("order", modelmap);
	}

	@ResponseBody
	@RequestMapping("pending-order")
	public ModelAndView pending_Order(HttpServletRequest req) {
		System.out.println("pending_orders");
		// HttpSession session = req.getSession();
		ArrayList<OrderDetail> orderList = new ArrayList<OrderDetail>();
		ArrayList<Poster> serposterList = new ArrayList<Poster>();
		orderList = osr.getPendingOrders();
		serposterList = ps.ServicingPosters();
		System.out.println(orderList.size());
		ModelMap modelmap = new ModelMap();
		modelmap.put("allorderList", orderList);
		modelmap.put("serposterList", serposterList);
		return new ModelAndView("pendingOrder", modelmap);
	}

	@ResponseBody
	@RequestMapping("serving-order")
	public ModelAndView serviing_Order(HttpServletRequest req) {
		System.out.println("serving_orders");
		// HttpSession session = req.getSession();
		ArrayList<OrderDetail> orderList = new ArrayList<OrderDetail>();
		orderList = osr.getServingOrders();
		System.out.println(orderList.size());
		ModelMap modelmap = new ModelMap();
		modelmap.put("allorderList", orderList);
		return new ModelAndView("order", modelmap);
	}

	@ResponseBody
	@RequestMapping("completed-order")
	public ModelAndView completed_Order(HttpServletRequest req) {
		System.out.println("completed_orders");
		// HttpSession session = req.getSession();
		ArrayList<OrderDetail> orderList = new ArrayList<OrderDetail>();
		orderList = osr.getCompletedOrders();
		System.out.println(orderList.size());
		ModelMap modelmap = new ModelMap();
		modelmap.put("allorderList", orderList);
		return new ModelAndView("order", modelmap);
	}

	@ResponseBody
	@RequestMapping(value ="UserOrdersServlet",produces = "application/json;charset=UTF-8")
	public String UserOrders(HttpServletRequest request)
			throws org.json.JSONException {
		String infor = request.getParameter("sendInfor");
		JSONObject json;
		json = new JSONObject(infor);
		String userid = json.getString("iduser");
		System.out.println(userid);
		List<Map<String,Object>>  result = new ArrayList<Map<String,Object>>();
		result = osr.getUserOrders(userid);
		System.out.println(result.size());
		if (result != null && !result.toString().equals("[]")) {
			JSONArray jsonres = new JSONArray(result);
			//System.out.println(jsonres.toString());
			return encodeUTF_8.encodeStr(jsonres.toString());

		} else {
			return "Failed";
		}
	}

	@ResponseBody
	@RequestMapping(value ="PosterOrdersServlet" ,produces = "application/json;charset=UTF-8")
	public String PosterOrders(HttpServletRequest request)
			throws org.json.JSONException {
		String infor = request.getParameter("sendInfor");
		JSONObject json;
		json = new JSONObject(infor);
		String posterid = json.getString("idposter");
		List<Map<String,Object>>  result = osr.getPostOrders(posterid);
		if (result != null && !result.toString().equals("[]")) {
			JSONArray jsonres = new JSONArray(result);
			System.out.println(jsonres.toString());
			return encodeUTF_8.encodeStr(jsonres.toString());

		} else {
			return "Failed";
		}
	}

	@ResponseBody
	@RequestMapping("UserDeliveryServlet")
	public String addOrder(HttpServletRequest request)
			throws org.json.JSONException {
		String infor = request.getParameter("sendInfor");
		int iduser = 0;
		int type = 0;
		String de_name = "";
		String de_cellnum = "";
		Date de_time = null;
		String de_address = "";
		int status = 0;
		int pay_type = 0;
		Date od_time = null;
		int is_urgent = 0;
		float price = 0;

		// System.out.println(infor);
		JSONObject json;

		json = new JSONObject(infor);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		iduser = json.getInt("iduser");
		type = json.getInt("type");
		de_name = json.getString("de_name");
		de_cellnum = json.getString("de_cellnum");

		try {
			de_time = (Date) sdf.parse(json.getString("de_time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		de_address = json.getString("de_address");
		status = json.getInt("status");
		pay_type = json.getInt("pay_type");

		try {
			od_time = (Date) sdf.parse(json.getString("od_time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		is_urgent = json.getInt("is_urgent");
		price = (float) json.getDouble("price");

		Timestamp detime = new Timestamp(de_time.getTime());
		Timestamp oltime = new Timestamp(od_time.getTime());
		System.out.println("orderData" + iduser + type + de_name + de_cellnum
				+ detime + de_address + status + pay_type + oltime + is_urgent
				+ price);
		int result = osr.adddeOrder(iduser, type, de_name, de_cellnum, detime,
				de_address, status, pay_type, oltime, is_urgent, price);

		return "添加代邮订单成功";
	}

	@ResponseBody
	@RequestMapping("UserExpressServlet")
	public String addExpressOrder(HttpServletRequest request)
			throws org.json.JSONException {
		String infor = request.getParameter("sendInfor");
		int iduser = 0;
		int type = 0;
		String exCompany = "";
		String exName = "";
		String exCellnum = "";
		Date exTime = null;
		String exAddress = "";
		String de_name = "";
		String de_cellnum = "";
		Date de_time = null;
		String de_address = "";
		int status = 0;
		int pay_type = 0;
		Date od_time = null;
		int is_urgent = 0;
		float price = 0;

		// System.out.println(infor);
		JSONObject json;

		json = new JSONObject(infor);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		iduser = json.getInt("iduser");
		type = json.getInt("type");
		de_name = json.getString("de_name");
		de_cellnum = json.getString("de_cellnum");

		try {
			de_time = (Date) sdf.parse(json.getString("de_time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		de_address = json.getString("de_address");
		status = json.getInt("status");
		pay_type = json.getInt("pay_type");

		try {
			od_time = (Date) sdf.parse(json.getString("od_time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		is_urgent = json.getInt("is_urgent");
		price = (float) json.getDouble("price");
		exCompany = json.getString("ex_company");
		exName = json.getString("ex_name");
		exCellnum = json.getString("ex_cellnum");
		try {
			exTime = (Date) sdf.parse(json.getString("ex_time"));
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		exAddress = json.getString("ex_address");

		Timestamp detime = new Timestamp(de_time.getTime());
		Timestamp oltime = new Timestamp(od_time.getTime());
		Timestamp extime = new Timestamp(exTime.getTime());
		System.out.println("添加代取订单成功" + "orderData" + iduser + type + de_name
				+ de_cellnum + detime + de_address + status + pay_type + oltime
				+ is_urgent + price);
		int result = osr.adddeExpOrder(iduser, type, de_name, de_cellnum,
				detime, de_address, status, pay_type, oltime, is_urgent, price,
				exCompany, exName, exCellnum, extime, exAddress);

		return "添加代取订单成功";
	}
	
	

}
