package json;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.apache.commons.io.FileUtils;
import org.json.JSONObject;

public class demo1 {

	public static void main(String[] args) throws IOException {
//		demo01();
//		demo02();
//		demo03();
		deom04();
	}

	// map对象转化json
	public static void demo01() {
		Map<String, String> map = new HashMap<>();
		map.put("s1", "zs");
		map.put("s2", "ls");
		map.put("s3", "ww");

		JSONObject json = new JSONObject(map);
		System.out.println(json);
	}

	// JavaBean对象转化json
	public static void demo02() {

		/*
		 * 输出结果
		 * {"address":{"homeddress":"北京","schoolAddress":"长沙"},"name":"zs","age":14}
		 */
		Person per = new Person();
		per.setName("zs");
		per.setAge(14);
		Address address = new Address("长沙", "北京");
		per.setAddress(address);

		JSONObject json = new JSONObject(per);
		System.out.println(json);
	}
	
	// String转化json 要符合格式{name:"23",age:123,sex:true}
		public static void demo03() {
			String str="{name:\"23\",age:123,sex:true}";

			JSONObject json = new JSONObject(str);
			System.out.println(json);
		}
		
		
	//将文件转化为json
	 public static void deom04() throws IOException {
		 File file=new File("E:\\eclipseWork\\JUC\\src\\json1.json");
		 String str=FileUtils.readFileToString(file);
		 JSONObject json=new JSONObject(str);
		 System.out.println(json);
	 }
}
