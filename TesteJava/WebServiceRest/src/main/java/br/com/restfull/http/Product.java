package br.com.restfull.http;


import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Product {

	private int cd_product;
	private String nm_product;
	private String ds_product;
	private int status;
	
	public Product(){
		
	}
	
	public Product(int cd_product, String nm_product, String ds_product, int status) {
		super();
		this.cd_product = cd_product;
		this.nm_product = nm_product;
		this.ds_product = ds_product;
		this.status = status;
	}

	public int getCd_product() {
		return cd_product;
	}

	public void setCd_product(int cd_product) {
		this.cd_product = cd_product;
	}

	public String getNm_product() {
		return nm_product;
	}

	public void setNm_product(String nm_product) {
		this.nm_product = nm_product;
	}

	public String getDs_product() {
		return ds_product;
	}

	public void setDs_product(String ds_product) {
		this.ds_product = ds_product;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
