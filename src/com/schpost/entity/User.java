package com.schpost.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * User entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "user", catalog = "schpost")
public class User implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private String cellphoneNum;

	// Constructors

	/** default constructor */
	public User() {
	}

	/** full constructor */
	public User(String name, String password, String cellphoneNum) {
		this.name = name;
		this.password = password;
		this.cellphoneNum = cellphoneNum;
	}

	// Property accessors
	@Id
	@GeneratedValue
	@Column(name = "id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "name", length = 45)
	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "password", length = 45)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Column(name = "cellphone_num", length = 11)
	public String getCellphoneNum() {
		return this.cellphoneNum;
	}

	public void setCellphoneNum(String cellphoneNum) {
		this.cellphoneNum = cellphoneNum;
	}

}