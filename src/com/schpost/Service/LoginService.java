package com.schpost.Service;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schpost.Dao.UserDAO;
import com.schpost.entity.User;

@Service
public class LoginService implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 8556726902610465351L;
	@Autowired
	UserDAO userDao;
	/**
	 * @param userName
	 * @param password
	 * @throws NoSuchAlgorithmException 
	 */
	public Map<String, Object>  userLogin(String userName, String password, HttpServletRequest req) throws NoSuchAlgorithmException {
		// TODO Auto-generated method stub

		//����û���ȡ���õ��ĵ�һ��ʵ��
		Map<String, Object> userinfo = new HashMap<String,Object>();
		
		List<User> users = userDao.findAll();
		if(users == null){
			return null;
		}
		for(User u: users){
			if(u.getName().equals(userName) && u.getPassword().equals(password)){
				userinfo.put("id", u.getId());
				userinfo.put("name", u.getName());
				userinfo.put("password", u.getPassword());
				userinfo.put("cellphone_num", u.getCellphoneNum());
				return userinfo;
			}
			
		}
		return null;
	}

}
