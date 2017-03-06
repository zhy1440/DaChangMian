package com.dcmomis.user;

public class CustomerInfoBean {
	private String userId;
	private String memberLevel;
	private String exchangRate;
	private String commonAddr;
	private String userName;
	private String mobile;
	private String email;
	
	
	/**
	 * @return
	 */
	public String getUserId() {
		return userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getMemberLevel() {
		return memberLevel;
	}
	public void setMemberLevel(String memberLevel) {
		this.memberLevel = memberLevel;
	}
	public String getExchangRate() {
		return exchangRate;
	}
	public void setExchangRate(String exchangRate) {
		this.exchangRate = exchangRate;
	}
	public String getCommonAddr() {
		return commonAddr;
	}
	public void setCommonAddr(String commonAddr) {
		this.commonAddr = commonAddr;
	}
}
