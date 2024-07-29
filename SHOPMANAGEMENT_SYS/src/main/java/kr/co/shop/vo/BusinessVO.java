package kr.co.shop.vo;

public class BusinessVO {
	 
    private String business_no; 
    private String tele_sell;  
    private String address;
    private String customer_center;
    private String modify_dt;
    private String create_dt; 
    
	public String getBusiness_no() {
		return business_no;
	}
	public void setBusiness_no(String business_no) {
		this.business_no = business_no;
	}
	public String getTele_sell() {
		return tele_sell;
	}
	public void setTele_sell(String tele_sell) {
		this.tele_sell = tele_sell;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getCustomer_center() {
		return customer_center;
	}
	public void setCustomer_center(String customer_center) {
		this.customer_center = customer_center;
	}
	public String getModify_dt() {
		return modify_dt;
	}
	public void setModify_dt(String modify_dt) {
		this.modify_dt = modify_dt;
	}
	public String getCreate_dt() {
		return create_dt;
	}
	public void setCreate_dt(String create_dt) {
		this.create_dt = create_dt;
	}
}