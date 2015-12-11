package com.schpost.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.schpost.Dao.PosterDAO;
import com.schpost.entity.Poster;

@Service
public class PosterService implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6545555738980525567L;

	@Autowired
	PosterDAO posterDao;

	@SuppressWarnings("unchecked")
	public ArrayList<Poster> DisplayAllUsers() {

		ArrayList<Poster> userList = new ArrayList<Poster>();
		userList = (ArrayList<Poster>) posterDao.findAll();
		// if()
		return userList;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Poster> ServicingPosters() {

		ArrayList<Poster> posterList = new ArrayList<Poster>();
		posterList = (ArrayList<Poster>) posterDao.findAll();
		ArrayList<Poster> serposterList = new ArrayList<Poster>();
	    for(Poster p:posterList){
	    	if(p.getIsWorking()==true){
	    		serposterList.add(p);
	    	}
	    	
	    }
		// if()
		return serposterList;
	}
	public int addPoster(String name,String password,String phone,String level,String place) {

		ArrayList<Poster> posterList = new ArrayList<Poster>();
		posterList = (ArrayList<Poster>) posterDao.findByCellphoneNum(phone);
		if(posterList.size() !=0){
			return 0;
		}
		else{
			Poster p  = new Poster(name,password,phone,Integer.parseInt(level),false,place);
			
			posterDao.save(p);
		}
		// if()
		return 1;
	}
	public int deletePoster(String id) {

		Poster p = posterDao.findById(Integer.parseInt(id));
		posterDao.delete(p);
		// if()
		return 1;
	}
	

	@SuppressWarnings("unchecked")
	public Map<String, Object> PosterLogin(String name, String password) {

		ArrayList<Poster> PosterList = new ArrayList<Poster>();
		Map<String, Object> posterinfo = new HashMap<String, Object>();
		PosterList = (ArrayList<Poster>) posterDao.findAll();
		System.out.println(PosterList.size());
		if (PosterList.size()>0) {
			for (Poster p : PosterList) {
				System.out.println(p.getName()+p.getPassword());
				if (p.getName().equals(name)&& p.getPassword().equals(password)) {
					p.setIsWorking(true);
					System.out.println(name+password);
					posterinfo.put("id", p.getId());
					posterinfo.put("name", p.getName());
					posterinfo.put("password", p.getPassword());
					posterinfo.put("cellphone_num", p.getCellphoneNum());
					posterinfo.put("level", p.getLevel());
					posterinfo.put("is_working", p.getIsWorking());
					posterinfo.put("wkplace", p.getWkplace());
					return posterinfo;
				} else {
					continue;

				}

			}

		}
		return null;
	}

}
