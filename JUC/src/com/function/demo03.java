package com.function;

import java.util.function.Consumer;

//消费型接口
public class demo03 {

	public static void main(String[] args) {
		/*Consumer<String> consumer=new Consumer<String>() {
			@Override
			public void accept(String str) {
				System.out.println(str);
			}
		};*/
		Consumer<String> consumer=(str)->{System.out.println(str);};
		
		consumer.accept("asfhiu");
	}

}
