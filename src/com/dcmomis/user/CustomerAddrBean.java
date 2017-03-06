package com.dcmomis.user;

public class CustomerAddrBean {
	private String userId;
	private String addrType;
	private String address;
	private String rowIdInner;
	
	/**
	 * @return
	 */
	public String getRowIdInner() {
		return rowIdInner;
	}

	public void setRowIdInner(String rowIdInner) {
		this.rowIdInner = rowIdInner;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
	
	public String getAddrType() {
		return addrType;
	}

	public void setAddrType(String addrType) {
		this.addrType = addrType;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

}
