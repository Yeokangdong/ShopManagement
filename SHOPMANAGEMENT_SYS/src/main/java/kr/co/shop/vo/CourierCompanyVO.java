package kr.co.shop.vo;

public class CourierCompanyVO {
	 
    private String courier_no;
    private String courier_nm;  
    private String fare;
    private String modify_dt;
    private String create_dt;
    
	public String getCourier_no() {
		return courier_no;
	}
	public void setCourier_no(String courier_no) {
		this.courier_no = courier_no;
	}
	public String getCourier_nm() {
		return courier_nm;
	}
	public void setCourier_nm(String courier_nm) {
		this.courier_nm = courier_nm;
	}
	public String getFare() {
		return fare;
	}
	public void setFare(String fare) {
		this.fare = fare;
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