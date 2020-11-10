package com.function;

import java.util.function.Function;

//函数型接口
public class demo01 {

	public static void main(String[] args) {
		/*Function function=new Function<String, String>() {
			@Override
			public String apply(String str) {
				return str;
			}
		};*/
		Function function=(str)->{return str;};//lamada表达式
		System.out.println(function.apply("asf"));
	}

}
