package com.schpost.Service;

import java.io.Serializable;
import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schpost.Dao.UserDAO;
import com.schpost.entity.User;
import com.schpost.Util.EncodingTool;

@Service
public class UserResgisterService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2202882579943901272L;
	@Autowired
	UserDAO userDao;
	//EncodingTool  encodeUTF_8= new EncodingTool();
	
	public int ResgisterUser(String username,String password,String phone){
		
		//User user =  new User(encodeUTF_8.encodeStr(username),encodeUTF_8.encodeStr(password),encodeUTF_8.encodeStr(phone));
		User user =  new User(username,password,phone);
		ArrayList<User> list = new ArrayList<User>();
		list = (ArrayList<User>)userDao.findByCellphoneNum(phone);
		if(list.size() ==0){
		userDao.save(user);
		return 1;
		}
		else{
			return -1;
			
		}
		
		
	}
	
	
	

}
