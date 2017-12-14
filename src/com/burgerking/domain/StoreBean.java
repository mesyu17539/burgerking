package com.burgerking.domain;

public class StoreBean {
	private String food, takeout;
	private int money=0, price;
	
	@Override
	public String toString() {
		return "명세표 [음식명=" + food + ", 가격=" + price + ", 세일=" + takeout + "총 가격"+money +"]\n";
	}
	public String getFood() {
		return food;
	}

	public void setFood(String food) {
		this.food = food;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getTakeout() {
		return takeout;
	}

	public void setTakeout(String takeout) {
		this.takeout = takeout;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
}
