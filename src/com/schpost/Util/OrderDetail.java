package com.schpost.Util;

import java.sql.Timestamp;

public class OrderDetail {
	
	// Fields
	   
		
		private Integer id;
		private Integer iduser;
		private String uerName;
		private Integer idposter;
		private String posterName;
		private String type;
		private String status;
		private String payType;
		private Timestamp odTime;
		private String isUrgent;
		private String addr;
		private Float price;
		public OrderDetail(){
			
		}
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getIduser() {
			return iduser;
		}
		public void setIduser(Integer iduser) {
			this.iduser = iduser;
		}
		public String getUerName() {
			return uerName;
		}
		public void setUerName(String uerName) {
			this.uerName = uerName;
		}
		public Integer getIdposter() {
			return idposter;
		}
		public void setIdposter(Integer idposter) {
			this.idposter = idposter;
		}
		public String getPosterName() {
			return posterName;
		}
		public void setPosterName(String posterName) {
			this.posterName = posterName;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		public String getPayType() {
			return payType;
		}
		public void setPayType(String payType) {
			this.payType = payType;
		}
		public Timestamp getOdTime() {
			return odTime;
		}
		public void setOdTime(Timestamp odTime) {
			this.odTime = odTime;
		}
		public String getIsUrgent() {
			return isUrgent;
		}
		public void setIsUrgent(String isUrgent) {
			this.isUrgent = isUrgent;
		}
		public String getAddr() {
			return addr;
		}
		public void setAddr(String addr) {
			this.addr = addr;
		}
		public Float getPrice() {
			return price;
		}
		public void setPrice(Float price) {
			this.price = price;
		}
	

}
