package com.schpost.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Contact entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name="contact"
    ,catalog="schpost"
)

public class Contact  implements java.io.Serializable {


    // Fields    

     private Integer idcontact;
     private Integer userid;
     private String phone;
     private String name;
     private String address;
     private String ortherInfo;


    // Constructors

    /** default constructor */
    public Contact() {
    }

	/** minimal constructor */
    public Contact(Integer userid, String phone, String address,String name) {
        this.userid = userid;
        this.phone = phone;
        this.address = address;
        this.name = name;
    }
    
    /** full constructor */
    public Contact(Integer userid, String phone, String address, String ortherInfo,String name) {
        this.userid = userid;
        this.phone = phone;
        this.address = address;
        this.ortherInfo = ortherInfo;
        this.name = name;
    }

   
    // Property accessors
    @Id @GeneratedValue
    
    @Column(name="idcontact", unique=true, nullable=false)

    public Integer getIdcontact() {
        return this.idcontact;
    }
    
    public void setIdcontact(Integer idcontact) {
        this.idcontact = idcontact;
    }
    
    @Column(name="userid", nullable=false)

    public Integer getUserid() {
        return this.userid;
    }
    
    public void setUserid(Integer userid) {
        this.userid = userid;
    }
    
    @Column(name="phone", nullable=false, length=45)

    public String getPhone() {
        return this.phone;
    }
    
    public void setPhone(String phone) {
        this.phone = phone;
    }
    
    
    @Column(name="name", nullable=false, length=45)

    public String getName() {
        return this.name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    @Column(name="address", nullable=false, length=100)

    public String getAddress() {
        return this.address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    @Column(name="ortherInfo", length=45)

    public String getOrtherInfo() {
        return this.ortherInfo;
    }
    
    public void setOrtherInfo(String ortherInfo) {
        this.ortherInfo = ortherInfo;
    }
   








}