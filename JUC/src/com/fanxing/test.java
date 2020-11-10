package com.fanxing;

import java.util.ArrayList;
import java.util.List;

public class test {

	public static void main(String[] args) {
		List list=new ArrayList();
		list.add(81);
		list.add(87);
		list.add(18);
		list.add(new String("a"));
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}
