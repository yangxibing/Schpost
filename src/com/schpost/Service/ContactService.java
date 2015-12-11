package com.schpost.Service;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.schpost.Dao.ContactDAO;
import com.schpost.entity.Contact;
import com.schpost.entity.Orders;
/**
 * 
 * @author yangxibing
 * @
 *
 */
@Service
public class ContactService implements Serializable {

	private static final long serialVersionUID = 442790430841563494L;
	@Autowired
	ContactDAO cd;
	
	
	public List<Map<String,Object>> getUserContacts(Integer userid){
		@SuppressWarnings("unchecked")
		List<Map<String,Object>> contactList = new ArrayList<Map<String,Object>>();
		ArrayList<Contact> contacts = (ArrayList<Contact>) cd.findByProperty("userid", userid);
		if(contacts.size()>0){
			for(Contact c:contacts){
				@SuppressWarnings("unchecked")
				Map<String,Object> map = new HashMap();
		        map.put("id", c.getIdcontact());
		        map.put("userid", c.getUserid());
		        map.put("name", c.getName());
		        map.put("phone", c.getPhone());
		        map.put("address", c.getAddress());
		        contactList.add(map);
		        }
		}
		
		return contactList;
	
	}
	
	public ArrayList<Contact> wgetUserContacts(Integer userid){
		@SuppressWarnings("unchecked")
		
		ArrayList<Contact> contacts = (ArrayList<Contact>) cd.findByProperty("userid", userid);
		return contacts;

}
	public int deleteContact(Integer id){
		@SuppressWarnings("unchecked")
		ArrayList<Contact> contacts = (ArrayList<Contact>) cd.findAll();
		for(Contact c:contacts){
			int cid = c.getIdcontact();
			if(cid ==id){
				cd.delete(c);
				cd.attachClean(c);
			}
		}
		return 1;
		
	}
	public int addContact(Integer id,String name,String phone,String address){
		ArrayList<Contact> contacts = (ArrayList<Contact>) cd.findByProperty("userid", id);
		for(Contact c:contacts){
			if(c.getName().equals(name)&&c.getPhone().equals(phone)&&c.getAddress().equals(address)){
				return -1;
			}
		}
		Contact c = new Contact(id,phone,address,name);
		cd.save(c);
		return 1;
	}
	public int modifyContact(Integer idcontact,String name,String phone,String address){
		@SuppressWarnings("unchecked")
		Contact contact = cd.findById(idcontact);
		contact.setAddress(address);
		contact.setName(name);
		contact.setPhone(phone);
		cd.update(contact);
		return 1;
	}
	
}
