package com.schpost.Service;

import com.schpost.Util.EncodingTool;
import com.schpost.Util.OrderDetail;
import com.schpost.entity.Orders;
import java.io.Serializable;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schpost.Dao.OrdersDAO;
import com.schpost.Dao.PosterDAO;
import com.schpost.Dao.UserDAO;

@Service
public class OrderService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7206336717150276472L;
	EncodingTool  encodeUTF_8= new EncodingTool();
	@Autowired
	OrdersDAO orderDao;
	@Autowired
	UserDAO userDao;
	@Autowired
	PosterDAO posterDao;
    
	public List<Map<String,Object>> getUserOrders(String uesrid){
		List<Map<String,Object>> userOrderList = new ArrayList<Map<String,Object>>();
		ArrayList<Orders> List = new ArrayList<Orders>();
		List = (ArrayList<Orders>)orderDao.findByIduser(Integer.parseInt(uesrid));
		//Date date = new Date();
		 DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		if(List.size()>0){
			for(Orders o:List){
				@SuppressWarnings("unchecked")
				Map<String,Object> map = new HashMap();
		        map.put("id", o.getId());
		        map.put("idposter", o.getIdposter());
		        int posterid = o.getIdposter();
		        if(posterid !=-1){
		        map.put("postername", posterDao.findById(posterid).getName());
		        map.put("posterphone", posterDao.findById(posterid).getCellphoneNum());
		        map.put("posterlevel", posterDao.findById(posterid).getLevel());
		        }
		        else{
		        	 map.put("postername", "未分配");
				     map.put("posterphone", "");
				     map.put("posterlevel", "");
		        	
		        }
		        map.put("type", getType(o.getType()));
		        if(o.getType() ==0){
				map.put("ex_company", o.getExCompany());
				map.put("ex_name", o.getExName());
				map.put("ex_cellnum",o.getExCellnum());
				map.put("ex_time",sdf.format(o.getExTime()));
				map.put("ex_address",o.getExAddress());
		        }
		        else{
		        	
		  				map.put("ex_company", "");
		  				map.put("ex_name", "");
		  				map.put("ex_cellnum","");
		  				map.put("ex_time","");
		  				map.put("ex_address",o.getDeAddress());
		  		        
		        }
		        
				map.put("de_name", o.getDeName());
				map.put("de_cellnum", o.getDeCellnum());
				map.put("de_time",sdf.format(o.getDeTime()));
				map.put("de_address",o.getDeAddress());
				map.put("status",getstaus(o.getStatus()));
				map.put("pay_type",getPyType(o.getPayType()));
				map.put("od_time",sdf.format(o.getOdTime()));
				map.put("is_urgent",o.getIsUrgent());
				map.put("price",o.getPrice());
				userOrderList.add(map);
			}
			
			
		}
         return userOrderList;
	}
	public int UserAssertOrder(String id){
		
		@SuppressWarnings("unchecked")
		ArrayList<Orders> orderlist = (ArrayList<Orders>) orderDao.findAll();
		
		for(Orders o:orderlist){
			if(o.getId() == Integer.parseInt(id)){
				o.setStatus(2);
				orderDao.update(o);
			}
			
		}
		return 1;
	}
	public int UserDeleteOrder(String id){
		
		@SuppressWarnings("unchecked")
		ArrayList<Orders> orderlist = (ArrayList<Orders>) orderDao.findAll();
		
		for(Orders o:orderlist){
			if(o.getId() == Integer.parseInt(id)){
				orderDao.delete(o);
				orderDao.attachClean(o);
			}
			
		}
		return 1;
	} 
	
	public int dispatchPoster(String posterids,String temp){
		String[] strarray=temp.split(",");
		String[] posterarray=posterids.split(",");
	      for (int i = 0; i < strarray.length; i++){
	    	  Orders o = orderDao.findById(Integer.parseInt(strarray[i]));
	    	  o.setIdposter(Integer.parseInt(posterarray[0]));
	    	  o.setStatus(1);
	    	  orderDao.update(o);   
	     }
		return 1;
	}
	public List<Map<String,Object>> getPostOrders(String posterid1){
		List<Map<String,Object>> posterOrderList = new ArrayList<Map<String,Object>>();
		ArrayList<Orders> List = (ArrayList<Orders>)orderDao.findByIdposter(Integer.parseInt(posterid1));
		//Date date = new Date();
		 DateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
		if(List.size()>0){
			for(Orders o:List){
				@SuppressWarnings("unchecked")
				Map<String,Object> map = new HashMap();
		        map.put("id", o.getId());
		        map.put("type", getType(o.getType()));
		        if(o.getType() ==0){
				map.put("ex_company", o.getExCompany());
				map.put("ex_name", o.getExName());
				map.put("ex_cellnum",o.getExCellnum());
				map.put("ex_time",sdf.format(o.getExTime()));
				map.put("ex_address",o.getExAddress());
		        }
		        else{
		        	
		  				map.put("ex_company", "");
		  				map.put("ex_name", "");
		  				map.put("ex_cellnum","");
		  				map.put("ex_time","");
		  				map.put("ex_address","");
		  		        
		        }
		        
				map.put("de_name", o.getDeName());
				map.put("de_cellnum", o.getDeCellnum());
				map.put("de_time",sdf.format(o.getDeTime()));
				map.put("de_address",o.getDeAddress());
				map.put("status",getstaus(o.getStatus()));
				map.put("pay_type",getPyType(o.getPayType()));
				map.put("od_time",sdf.format(o.getOdTime()));
				map.put("is_urgent",o.getIsUrgent());
				map.put("price",o.getPrice());
				posterOrderList.add(map);
			}
			
			
		}
         return posterOrderList;
	}
	@SuppressWarnings({ "unused", "unchecked" })
	public ArrayList<OrderDetail> getAllOrders() {
		ArrayList<OrderDetail> orderList = new ArrayList<OrderDetail>();
		ArrayList<Orders> order = (ArrayList<Orders>) orderDao.findAll();
		for (Orders o : order) {

			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setIdposter(o.getIdposter());
			if (o.getIdposter() != -1) { 
				if(posterDao.findById(o.getIdposter()) !=null){
				orderDetail.setPosterName(posterDao.findById(o.getIdposter())
						.getName());
				}

			} else {
				orderDetail.setPosterName("未分配");
			}
			if(userDao.findById(o.getIduser()) !=null){
			orderDetail.setUerName(userDao.findById(o.getIduser()).getName());
			}
			orderDetail.setIduser(o.getIduser());
			orderDetail.setOdTime(o.getOdTime());
			orderDetail.setPayType(getPyType(o.getPayType()));
			orderDetail.setStatus(getstaus(o.getStatus()));
			orderDetail.setType(getType(o.getType()));
			if(o.getType() ==0){
			orderDetail.setAddr(o.getExAddress());
			}
			else{
				orderDetail.setAddr(o.getDeAddress());
				
			}
			orderDetail.setPrice(o.getPrice());
			orderDetail.setId(o.getId());
			orderList.add(orderDetail);
		}
		return orderList;
	}
	
	public ArrayList<OrderDetail> getPendingOrders() {
		ArrayList<OrderDetail> orderList = new ArrayList<OrderDetail>();
		ArrayList<Orders> order = (ArrayList<Orders>) orderDao.findByStatus(0);
		for (Orders o : order) {

			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setIdposter(o.getIdposter());
			if (o.getIdposter() != -1) {
				orderDetail.setPosterName(posterDao.findById(o.getIdposter())
						.getName());

			} else {
				orderDetail.setPosterName("未分配");
			}
			orderDetail.setUerName(userDao.findById(o.getIduser()).getName());
			orderDetail.setIduser(o.getIduser());
			orderDetail.setOdTime(o.getOdTime());
			orderDetail.setPayType(getPyType(o.getPayType()));
			orderDetail.setStatus(getstaus(o.getStatus()));
			orderDetail.setType(getType(o.getType()));
			if(o.getType() ==0){
				orderDetail.setAddr(o.getExAddress());
				}
				else{
					orderDetail.setAddr(o.getDeAddress());
				}
			orderDetail.setPrice(o.getPrice());
			orderDetail.setId(o.getId());
			orderList.add(orderDetail);
		}
		return orderList;
	}

	public ArrayList<OrderDetail> getServingOrders() {
		ArrayList<OrderDetail> orderList = new ArrayList<OrderDetail>();
		ArrayList<Orders> order = (ArrayList<Orders>) orderDao.findByStatus(1);
		for (Orders o : order) {

			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setIdposter(o.getIdposter());
			if (o.getIdposter() != -1) {
				orderDetail.setPosterName(posterDao.findById(o.getIdposter())
						.getName());

			} else {
				orderDetail.setPosterName("未分配");
			}
			orderDetail.setUerName(userDao.findById(o.getIduser()).getName());
			orderDetail.setIduser(o.getIduser());
			orderDetail.setOdTime(o.getOdTime());
			orderDetail.setPayType(getPyType(o.getPayType()));
			orderDetail.setStatus(getstaus(o.getStatus()));
			orderDetail.setType(getType(o.getType()));
			if(o.getType() ==0){
				orderDetail.setAddr(o.getExAddress());
				}
				else{
					orderDetail.setAddr(o.getDeAddress());
				}
			orderDetail.setPrice(o.getPrice());
			orderDetail.setId(o.getId());
			orderList.add(orderDetail);
		}
		return orderList;
	}
	
	public ArrayList<OrderDetail> getCompletedOrders() {
		ArrayList<OrderDetail> orderList = new ArrayList<OrderDetail>();
		ArrayList<Orders> order = (ArrayList<Orders>) orderDao.findByStatus(2);
		for (Orders o : order) {

			OrderDetail orderDetail = new OrderDetail();
			orderDetail.setIdposter(o.getIdposter());
			if (o.getIdposter() != -1) {
				orderDetail.setPosterName(posterDao.findById(o.getIdposter())
						.getName());

			} else {
				orderDetail.setPosterName("未分配");
			}
			orderDetail.setUerName(userDao.findById(o.getIduser()).getName());
			orderDetail.setIduser(o.getIduser());
			orderDetail.setOdTime(o.getOdTime());
			orderDetail.setPayType(getPyType(o.getPayType()));
			orderDetail.setStatus(getstaus(o.getStatus()));
			orderDetail.setType(getType(o.getType()));
			if(o.getType() ==0){
				orderDetail.setAddr(o.getExAddress());
				}
				else{
					orderDetail.setAddr(o.getDeAddress());
				}
			orderDetail.setPrice(o.getPrice());
			orderDetail.setId(o.getId());
			orderList.add(orderDetail);
		}
		return orderList;
	}
	public int adddeOrder(int iduser, int type, String deName,String deCellnum, Timestamp deTime, String deAddress, int status,
			int payType, Timestamp odTime, int isUrgent, float price) {

		Orders order = new Orders(iduser, -1, type, null, null, null, null,
				null, deName, deCellnum, deTime, deAddress, status, payType,
				odTime, isUrgent, price);
		orderDao.save(order);
		return 1;
	}
	
	public int adddeExpOrder(int iduser, int type, String deName,String deCellnum, Timestamp deTime, String deAddress, int status,int payType, Timestamp odTime, int isUrgent, float price,String exCompany,
			String exName,String exCellnum,Timestamp exTime ,
			String exAddress) {

		Orders order = new Orders(iduser, -1, type, exCompany, exName, exCellnum, exTime,
				exAddress, deName, deCellnum, deTime, deAddress, status, payType,
				odTime, isUrgent, price);
		orderDao.save(order);
		return 1;
	}

	public String getstaus(int staus) {
		String temp = "";
		if (staus == 0) {
			temp = "未处理";
		} else if (staus == 1) {
			temp = "服务中";
		} else if (staus == 2) {
			temp = "已完成";
		}
		return  encodeUTF_8.encodeStr(temp);
	}
	
	public String getType(int type) {
		String temp = "";
		if (type == 0) {
			temp = "代取";
		} else if (type == 1) {
			temp = "代邮";
		}
		return  encodeUTF_8.encodeStr(temp);
	}
	public String getPyType(int type) {
		String temp = "";
		if (type == 0) {
			temp = "货到付款";
		} else if (type == 1) {
			temp = "支付宝支付";
		}
		return  encodeUTF_8.encodeStr(temp);
	}
	
	
}
