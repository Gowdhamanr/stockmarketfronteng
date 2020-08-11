package com.stock.StockMarket;

import com.stock.StockMarket.User;

import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {

	User getByEmailAndPassword(String email, String password);

	
}
