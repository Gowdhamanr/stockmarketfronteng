package com.stock.StockMarket;
import com.stock.StockMarket.Company;
import org.springframework.data.repository.CrudRepository;

public interface CompanyRepo extends CrudRepository<Company,Integer> {
	
   
}
