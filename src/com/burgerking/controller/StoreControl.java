package com.burgerking.controller;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JOptionPane;

import com.burgerking.constancepool.ValueStr;
import com.burgerking.service.StoreService;
import com.burgerking.serviceimpl.StoreServiceImpl;

public class StoreControl {
	public static void main(String[] args) {
		StoreService service=new StoreServiceImpl();
		while(true) {
			switch(JOptionPane.showInputDialog(ValueStr.STR[0])) {
			case "0": return;
			case "1":
				String[] arr= {
						ValueStr.STR[2],
						ValueStr.STR[3],
						ValueStr.STR[4]
				};
				service.createMenu(arr);
				String foodname;
				while(true) {
					foodname=JOptionPane.showInputDialog(service.showListM()+"\n"
							+ ValueStr.STR[1]
							+ ValueStr.STR[5]);
					if(foodname.equals("0")) {
						break;
					}else {
						service.choseMenu(foodname);
					}
				}
				break;
			case "2":
				int pa=service.payCount(Integer.parseInt(JOptionPane.showInputDialog(service.showListM()+"\n돈 투입 하십시오")));
				File f=new File("C:\\Users\\1027\\jse\\eclipse\\workspace\\burgerking\\paying.txt");
				BufferedWriter bw=null;
				try {
					bw=new BufferedWriter(new FileWriter(f));
					bw.write(service.showListM().toString()+"남은 가격"+pa);
				} catch (IOException e) {
					e.printStackTrace();
				}finally {
					try {
						bw.flush();
						bw.close();
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
				break;
			}
		}
	}
}
