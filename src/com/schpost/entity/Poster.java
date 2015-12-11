package com.schpost.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Poster entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "poster", catalog = "schpost")
public class Poster implements java.io.Serializable {

	// Fields

	private Integer id;
	private String name;
	private String password;
	private String cellphoneNum;
	private Integer level;
	private Boolean isWorking;
	private String wkplace;

	// Constructors

	/** default constructor */
	public Poster() {
	}

	/** full constructor */
	public Poster(String name, String password, String cellphoneNum,
			Integer level, Boolean isWorking, String wkplace) {
		this.name = name;
		this.password = password;
		this.cellphoneNum = cellphoneNum;
		this.level = level;
		this.isWorking = isWorking;
		this.wkplace = wkplace;
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

	@Column(name = "level")
	public Integer getLevel() {
		return this.level;
	}

	public void setLevel(Integer level) {
		this.level = level;
	}

	@Column(name = "is_working")
	public Boolean getIsWorking() {
		return this.isWorking;
	}

	public void setIsWorking(Boolean isWorking) {
		this.isWorking = isWorking;
	}

	@Column(name = "wkplace", length = 100)
	public String getWkplace() {
		return this.wkplace;
	}

	public void setWkplace(String wkplace) {
		this.wkplace = wkplace;
	}

}