package MD5;

import java.io.File;

public class test {
	public static void dirTree(String path) {
		
		File sf = new File(path);
		
		if(!sf.exists()) {
			System.out.println("Not");
			return;
		}
		
		if(sf.isDirectory()) {
			
			File listFile[] = sf.listFiles();
			for (File file : listFile) {
				System.out.println(file.getAbsolutePath());
			}
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		dirTree("/Icon");
	}

}
