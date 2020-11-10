package com.function;

import java.util.function.Supplier;

public class demo04 {

	public static void main(String[] args) {
		Supplier<String> supplier=new Supplier<String>() {
			
			@Override
			public String get() {
				return "asygufh";
			}
		};
		
		System.out.println(supplier.get());
	}

}
