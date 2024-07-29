package kr.co.shop.vo;

public class ProductVO {
	 
    private String product_no; 
    private String category_no;
    private String item_no;
    private String store_no;
    private String courier_no;
    private String tax;
    private String brand_title;
    
	public String getProduct_no() {
		return product_no;
	}
	public void setProduct_no(String product_no) {
		this.product_no = product_no;
	}
	public String getCategory_no() {
		return category_no;
	}
	public void setCategory_no(String category_no) {
		this.category_no = category_no;
	}
	public String getItem_no() {
		return item_no;
	}
	public void setItem_no(String item_no) {
		this.item_no = item_no;
	}
	public String getStore_no() {
		return store_no;
	}
	public void setStore_no(String store_no) {
		this.store_no = store_no;
	}
	public String getCourier_no() {
		return courier_no;
	}
	public void setCourier_no(String courier_no) {
		this.courier_no = courier_no;
	}
	public String getTax() {
		return tax;
	}
	public void setTax(String tax) {
		this.tax = tax;
	}
	public String getBrand_title() {
		return brand_title;
	}
	public void setBrand_title(String brand_title) {
		this.brand_title = brand_title;
	}
}