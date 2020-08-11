package com.stock.StockMarket;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.ManyToAny;
@Entity
public class Company {
      
	 @Id
     private int Stockcode;
	 
	 private String comp_name;
	 private String turnover;
	 private String ceo;
	 private String board_of_directors;
	 
	 private String stock_exchange;
	 private String sector;
	 private String about;
	public int getStockcode() {
		return Stockcode;
	}
	public void setStockcode(int stockcode) {
		Stockcode = stockcode;
	}
	public String getComp_name() {
		return comp_name;
	}
	public void setComp_name(String comp_name) {
		this.comp_name = comp_name;
	}
	public String getTurnover() {
		return turnover;
	}
	public void setTurnover(String turnover) {
		this.turnover = turnover;
	}
	public String getCeo() {
		return ceo;
	}
	public void setCeo(String ceo) {
		this.ceo = ceo;
	}
	public String getBoard_of_directors() {
		return board_of_directors;
	}
	public void setBoard_of_directors(String board_of_directors) {
		this.board_of_directors = board_of_directors;
	}
	public String getStock_exchange() {
		return stock_exchange;
	}
	public void setStock_exchange(String stock_exchange) {
		this.stock_exchange = stock_exchange;
	}
	public String getSector() {
		return sector;
	}
	public void setSector(String sector) {
		this.sector = sector;
	}
	public String getAbout() {
		return about;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	 
}
