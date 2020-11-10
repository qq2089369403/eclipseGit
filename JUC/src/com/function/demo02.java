package com.function;

import java.util.function.Predicate;

//断定型接口
public class demo02 {

	public static void main(String[] args) {
		/*Predicate<String> predicate=new Predicate<String>() {
			
			@Override
			public boolean test(String t) {
				return t.isEmpty();
			}
		};*/
		
		Predicate<String> predicate=(str)->{if(str!=null) return str.isEmpty(); else return false;};
		
		System.out.println(predicate.test(null));
	}

}
