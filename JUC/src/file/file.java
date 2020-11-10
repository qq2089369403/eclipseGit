package file;

import java.io.File;

public class file {

	public static void main(String[] args) {
		File file=new File("E:\\kong");
		delFile(file);
	}
	
	public static boolean delFile(File file) {
		File[] files=file.listFiles();
		if (file.exists()) {
			for (int i = 0; i < files.length; i++) {
				if (files[i].delete()) {
					file.delete();
				}
			}
		}else {
			file.delete();
		}
		System.out.println("cg");
		return true;
	}
}
