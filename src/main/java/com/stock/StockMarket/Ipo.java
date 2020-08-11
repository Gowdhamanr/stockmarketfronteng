package com.stock.StockMarket;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Ipo {

	@Id
	private int id;
	private String comp_name;
	 private String stockexchange;
	 private long price;
	 private long totalshare;
	 private Date date_time;
	 private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	public String getStockexchange() {
		return stockexchange;
	}
	public void setStockexchange(String stockexchange) {
		this.stockexchange = stockexchange;
	}
	public long getPrice() {
		return price;
	}
	public void setPrice(long price) {
		this.price = price;
	}
	public long getTotalshare() {
		return totalshare;
	}
	public void setTotalshare(long totalshare) {
		this.totalshare = totalshare;
	}
	public Date getDate_time() {
		return date_time;
	}
	public void setDate_time(Date date_time) {
		this.date_time = date_time;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
}
