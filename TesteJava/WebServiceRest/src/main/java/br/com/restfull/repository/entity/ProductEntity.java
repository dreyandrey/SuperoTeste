package br.com.restfull.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="tasklist")
public class ProductEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="cd_product")
	private Integer cd_product;
	
	@Column(name="nm_product")	
	private String nm_product;
	
	@Column(name="ds_product")
	private String ds_product;
	
	@Column(name="status")
	private Integer status;

	public Integer getCdProduct() {
		return cd_product;
	}

	public void setCdProduct(Integer cd_product) {
		this.cd_product = cd_product;
	}

	public String getNmProduct() {
		return nm_product;
	}

	public void setNmProduct(String nm_product) {
		this.nm_product = nm_product;
	}

	public String getDsProduct() {
		return ds_product;
	}

	public void setDsProduct(String ds_product) {
		this.ds_product = ds_product;
	}
	
	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}
		
}
