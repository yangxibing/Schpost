package com.schpost.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schpost.Dao.UserDAO;
import com.schpost.entity.Poster;
import com.schpost.entity.User;
@Service
public class UserService implements Serializable{

	private static final long serialVersionUID = 5484632556487889178L;
	@Autowired
	UserDAO userDao;
	@SuppressWarnings("unchecked")
	public ArrayList<User> DisplayAllUsers(){
		
		ArrayList<User> userList =  new ArrayList<User>();
		userList = (ArrayList<User>)userDao.findAll();
		//if()
		return userList;
	}
   public int deleteUser(String id){
		
	   User p = userDao.findById(Integer.parseInt(id));
		userDao.delete(p);
		
		return 1;
	}
   public Map<String, Object>  modifyUser(String id,String name,String password,String newpassword,String phone){
	   
	   User p = userDao.findById(Integer.parseInt(id));
	   if(p !=null){
	   Map<String, Object> userinfo = new HashMap<String,Object>();
	   if(p.getName().equals(name)&&p.getPassword().equals(newpassword)&&p.getCellphoneNum().equals(phone)){
		    userinfo.put("id", p.getId());
			userinfo.put("name", p.getName());
			userinfo.put("password", p.getPassword());
			userinfo.put("cellphone_num", p.getCellphoneNum());
			return userinfo;
	   }else{
		   p.setName(name);
		   p.setPassword(newpassword);
		   p.setCellphoneNum(phone);
		   userDao.update(p);
		   userinfo.put("id", p.getId());
		   userinfo.put("name", p.getName());
		   userinfo.put("password", p.getPassword());
		   userinfo.put("cellphone_num", p.getCellphoneNum());
			return userinfo;
	   }
	   }
		//userDao.delete(p);
		return null;
	}
   
	}


