package com.schpost.entity;

import java.sql.Timestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Orders entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "orders", catalog = "schpost")
public class Orders implements java.io.Serializable {

	// Fields

	private Integer id;
	private Integer iduser;
	private Integer idposter;
	private Integer type;
	private String exCompany;
	private String exName;
	private String exCellnum;
	private Timestamp exTime;
	private String exAddress;
	private String deName;
	private String deCellnum;
	private Timestamp deTime;
	private String deAddress;
	private Integer status;
	private Integer payType;
	private Timestamp odTime;
	private Integer isUrgent;
	private Float price;

	// Constructors

	/** default constructor */
	public Orders() {
		id = -1;
	}

	/** full constructor */
	public Orders(Integer iduser, Integer idposter, Integer type,
			String exCompany, String exName, String exCellnum,
			Timestamp exTime, String exAddress, String deName,
			String deCellnum, Timestamp deTime, String deAddress,
			Integer status, Integer payType, Timestamp odTime,
			Integer isUrgent, Float price) {
		this.iduser = iduser;
		this.idposter = idposter;
		this.type = type;
		this.exCompany = exCompany;
		this.exName = exName;
		this.exCellnum = exCellnum;
		this.exTime = exTime;
		this.exAddress = exAddress;
		this.deName = deName;
		this.deCellnum = deCellnum;
		this.deTime = deTime;
		this.deAddress = deAddress;
		this.status = status;
		this.payType = payType;
		this.odTime = odTime;
		this.isUrgent = isUrgent;
		this.price = price;
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

	@Column(name = "iduser")
	public Integer getIduser() {
		return this.iduser;
	}

	public void setIduser(Integer iduser) {
		this.iduser = iduser;
	}

	@Column(name = "idposter")
	public Integer getIdposter() {
		return this.idposter;
	}

	public void setIdposter(Integer idposter) {
		this.idposter = idposter;
	}

	@Column(name = "type")
	public Integer getType() {
		return this.type;
	}

	public void setType(Integer type) {
		this.type = type;
	}

	@Column(name = "ex_company", length = 45)
	public String getExCompany() {
		return this.exCompany;
	}

	public void setExCompany(String exCompany) {
		this.exCompany = exCompany;
	}

	@Column(name = "ex_name", length = 45)
	public String getExName() {
		return this.exName;
	}

	public void setExName(String exName) {
		this.exName = exName;
	}

	@Column(name = "ex_cellnum", length = 11)
	public String getExCellnum() {
		return this.exCellnum;
	}

	public void setExCellnum(String exCellnum) {
		this.exCellnum = exCellnum;
	}

	@Column(name = "ex_time", length = 19)
	public Timestamp getExTime() {
		return this.exTime;
	}

	public void setExTime(Timestamp exTime) {
		this.exTime = exTime;
	}

	@Column(name = "ex_address", length = 45)
	public String getExAddress() {
		return this.exAddress;
	}

	public void setExAddress(String exAddress) {
		this.exAddress = exAddress;
	}

	@Column(name = "de_name", length = 45)
	public String getDeName() {
		return this.deName;
	}

	public void setDeName(String deName) {
		this.deName = deName;
	}

	@Column(name = "de_cellnum", length = 11)
	public String getDeCellnum() {
		return this.deCellnum;
	}

	public void setDeCellnum(String deCellnum) {
		this.deCellnum = deCellnum;
	}

	@Column(name = "de_time", length = 19)
	public Timestamp getDeTime() {
		return this.deTime;
	}

	public void setDeTime(Timestamp deTime) {
		this.deTime = deTime;
	}

	@Column(name = "de_address", length = 45)
	public String getDeAddress() {
		return this.deAddress;
	}

	public void setDeAddress(String deAddress) {
		this.deAddress = deAddress;
	}

	@Column(name = "status")
	public Integer getStatus() {
		return this.status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Column(name = "pay_type")
	public Integer getPayType() {
		return this.payType;
	}

	public void setPayType(Integer payType) {
		this.payType = payType;
	}

	@Column(name = "od_time", length = 19)
	public Timestamp getOdTime() {
		return this.odTime;
	}

	public void setOdTime(Timestamp odTime) {
		this.odTime = odTime;
	}

	@Column(name = "is_urgent")
	public Integer getIsUrgent() {
		return this.isUrgent;
	}

	public void setIsUrgent(Integer isUrgent) {
		this.isUrgent = isUrgent;
	}

	@Column(name = "price", precision = 12, scale = 0)
	public Float getPrice() {
		return this.price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}