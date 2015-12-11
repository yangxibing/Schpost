package com.schpost.Service;

import java.io.Serializable;
import java.security.NoSuchAlgorithmException;
import java.util.NoSuchElementException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schpost.Dao.AdminDAO;


@Service
public class AdminLoginService implements Serializable {
	private static final long serialVersionUID = 1786823456L;
	@Autowired
	AdminDAO adDao;
	
	/**
	 * @param adminName 
	 * @param password
	 * @return return -1用户不存在 0密码不对 1正确
	 * @throws NoSuchAlgorithmException
	 */
	public int verifyAdmin(HttpServletRequest req, String adminName, String password) 
			throws NoSuchElementException, NoSuchAlgorithmException{
		
		if (!adDao.findByName(adminName).isEmpty()){
			if(adDao.findByName(adminName).get(0).getPassword().equals(password)){	
				HttpSession session = req.getSession();
				session.setAttribute("admin", adDao.findByName(adminName).get(0));
				//getData(req);
				return 1;
			}
			else {
				return 0;
			}
		}
		else {
			return -1;
		}
	}
	
}
