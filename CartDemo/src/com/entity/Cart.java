package com.entity;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 * 购物车
 * @author Administrator
 * @date 2016-08-01
 */

public class Cart {
	//商品集合
	private HashMap<Items, Integer> goods;
	
	//总价格
	private double totalPrice;

	public Cart() {
		goods = new HashMap<>();
		totalPrice = 0.0;	
	}
	

	public HashMap<Items, Integer> getGoods() {
		return goods;
	}

	public void setGoods(HashMap<Items, Integer> goods) {
		this.goods = goods;
	}

	public double getTotalPrice() {
		return totalPrice;
	}

	public void setTotalPrice(double totalPrice) {
		this.totalPrice = totalPrice;
	}
	
	/**
	 * 添加商品进入集合
	 * @param item
	 * @param number
	 * @return boolean
	 */
	public boolean addGoodsInCart(Items item, int number) {
		
		if (goods.containsKey(item)) {
			goods.put(item, goods.get(item) + number);
		} else {
			goods.put(item, number);
		}
		
		calTotalPrice();//计算总价格
		return true;
	}
	
	/**
	 * 从购物车中移除商品
	 * @param item
	 * @return
	 */
	public boolean removeGoodsFromCart(Items item) {
		goods.remove(item);
		calTotalPrice();
		return true;
	}

	/**
	 * 计算购物车商品的总价格
	 * @return
	 */
	public double calTotalPrice() {
		// TODO Auto-generated method stub
		double sum = 0.0;
		
		Set<Items> keys = goods.keySet();
		Iterator<Items> it = keys.iterator();
		
		while(it.hasNext()) {
			Items i = it.next();
			sum += i.getPrice() * goods.get(i);
		}
		
		this.setTotalPrice(sum);
		return this.getTotalPrice();
	}
	
}
