package com.example.demo.discount;

public interface OrderService {
	
	Order createOrder(Long memberId, String itemName, int itemPrice);

}
