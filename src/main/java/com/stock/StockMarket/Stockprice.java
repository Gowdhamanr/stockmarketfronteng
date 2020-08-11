package com.stock.StockMarket;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Stockprice {
 
	
	@Id
	private String Companycode;
	 private String StockExchange;
	 private double StockPrice;
	 private Date Dateofstock;
	 private String stocktime;
	public String getCompanycode() {
		return Companycode;
	}
	public void setCompanycode(String companycode) {
		Companycode = companycode;
	}
	public String getStockExchange() {
		return StockExchange;
	}
	public void setStockExchange(String stockExchange) {
		StockExchange = stockExchange;
	}
	public double getStockPrice() {
		return StockPrice;
	}
	public void setStockPrice(double stockPrice) {
		StockPrice = stockPrice;
	}
	public Date getDateofstock() {
		return Dateofstock;
	}
	public void setDateofstock(Date dateofstock) {
		Dateofstock = dateofstock;
	}
	public String getStocktime() {
		return stocktime;
	}
	public void setStocktime(String stocktime) {
		this.stocktime = stocktime;
	}
}
