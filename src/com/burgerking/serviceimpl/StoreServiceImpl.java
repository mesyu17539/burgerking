package com.burgerking.serviceimpl;

import java.util.HashMap;
import java.util.Set;

import com.burgerking.domain.StoreBean;
import com.burgerking.service.StoreService;

public class StoreServiceImpl implements StoreService {
	private HashMap<String, StoreBean> hMap;
	
	public StoreServiceImpl() {
		hMap=new HashMap<String, StoreBean>();
	}

	@Override
	public void createMenu(String[] arr) {//메뉴 세팅 (이름/가격/할인률)
		String[] str;//arr 단위별 분리한 것 담기용도.
		StoreBean bean;//맵에 추가하기 위한 bean객체의 데이터 셋팅용
		for(int i=0;i<arr.length;i++) {
			str=null;
			str=arr[i].split("/");
			bean=new StoreBean();
			bean.setFood(str[0]);
			bean.setPrice(Integer.parseInt(str[1]));
			bean.setTakeout(str[2]);
			hMap.put(bean.getFood(), bean);
		}
	}

	@Override
	public HashMap<String, StoreBean> showListM() {//맵 리턴
		return hMap;
	}

	@Override
	public void choseMenu(String foodname) {//메뉴 선택 (이름/수량) => (key/수량*가격+누적금액)
		String[] arr=foodname.split("/");
		for(int i=0;i<arr.length;i+=2) {
			hMap.get(arr[i]).setMoney(
					(hMap.get(arr[i]).getPrice()*Integer.parseInt(arr[i+1]))+hMap.get(arr[i]).getMoney());;
		}
	}

	@Override
	public int payCount(int parseInt) {//돈 받은 후에 잔돈 return
		Set<String> keys=hMap.keySet();
		for(String key:keys) {
			parseInt-=hMap.get(key).getMoney();
		}
		return parseInt;
	}
}
