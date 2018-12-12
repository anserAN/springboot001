package com.alm.entity;

import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author anluming
 * @since 2018-12-01
 */
public class Admins implements Serializable {

    private static final long serialVersionUID = 1L;

	private String adminid;
	private String adminName;
	private String adminStatus;


	public String getAdminid() {
		return adminid;
	}

	public void setAdminid(String adminid) {
		this.adminid = adminid;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getAdminStatus() {
		return adminStatus;
	}

	public void setAdminStatus(String adminStatus) {
		this.adminStatus = adminStatus;
	}

}
