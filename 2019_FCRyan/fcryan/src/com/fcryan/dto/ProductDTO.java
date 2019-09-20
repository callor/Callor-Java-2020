package com.fcryan.dto;

import java.sql.Date;

public class ProductDTO {
    private String p_code;
    private String p_name;
    private String p_club;
    private String p_nation;
    private String p_local;
    private String p_statidum;
    private String p_coach;
    private int p_price;
    private int p_good; 
    private String p_img;
    private Date p_indate;
    
    public ProductDTO() {}

	public ProductDTO(String p_code, String p_name, String p_club, String p_nation, String p_local, String p_statidum,
			String p_coach, int p_price, int p_good, String p_img, Date p_indate) {
		super();
		this.p_code = p_code;
		this.p_name = p_name;
		this.p_club = p_club;
		this.p_nation = p_nation;
		this.p_local = p_local;
		this.p_statidum = p_statidum;
		this.p_coach = p_coach;
		this.p_price = p_price;
		this.p_good = p_good;
		this.p_img = p_img;
		this.p_indate = p_indate;
	}

	public String getP_code() {
		return p_code;
	}

	public void setP_code(String p_code) {
		this.p_code = p_code;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_club() {
		return p_club;
	}

	public void setP_club(String p_club) {
		this.p_club = p_club;
	}

	public String getP_nation() {
		return p_nation;
	}

	public void setP_nation(String p_nation) {
		this.p_nation = p_nation;
	}

	public String getP_local() {
		return p_local;
	}

	public void setP_local(String p_local) {
		this.p_local = p_local;
	}

	public String getP_statidum() {
		return p_statidum;
	}

	public void setP_statidum(String p_statidum) {
		this.p_statidum = p_statidum;
	}

	public String getP_coach() {
		return p_coach;
	}

	public void setP_coach(String p_coach) {
		this.p_coach = p_coach;
	}

	public int getP_price() {
		return p_price;
	}

	public void setP_price(int p_price) {
		this.p_price = p_price;
	}

	public int getP_good() {
		return p_good;
	}

	public void setP_good(int p_good) {
		this.p_good = p_good;
	}

	public String getP_img() {
		return p_img;
	}

	public void setP_img(String p_img) {
		this.p_img = p_img;
	}

	public Date getP_indate() {
		return p_indate;
	}

	public void setP_indate(Date p_indate) {
		this.p_indate = p_indate;
	}

	@Override
	public String toString() {
		return "ProductDTO [p_code=" + p_code + ", p_name=" + p_name + ", p_club=" + p_club + ", p_nation=" + p_nation
				+ ", p_local=" + p_local + ", p_statidum=" + p_statidum + ", p_coach=" + p_coach + ", p_price="
				+ p_price + ", p_good=" + p_good + ", p_img=" + p_img + ", p_indate=" + p_indate + "]";
	}
    
}
