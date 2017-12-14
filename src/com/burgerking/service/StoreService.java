package com.burgerking.service;

import java.util.HashMap;

import com.burgerking.domain.StoreBean;

public interface StoreService {
	public void createMenu(String[] arr);

	public HashMap<String, StoreBean> showListM();

	public void choseMenu(String foodname);

	public int payCount(int parseInt);
}
