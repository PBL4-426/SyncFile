package MD5;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class Client implements Runnable {

	ObjectOutputStream oos;
	ObjectInputStream ois;
	Socket soc;
	String Source="D:\\Study\\Client\\";
	byte[] buffer = new byte[8192];
	public static void main(String[] args) {
		new Thread(new Client()).start();
		// TODO Auto-generated method stub

	}

	public Client(){
		try {
		soc = new Socket("localhost", 5024);
			oos = new ObjectOutputStream(soc.getOutputStream());
			ois = new ObjectInputStream(soc.getInputStream());
			//ois= new ObjectInputStream(soc.getInputStream());
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	public void Receive(String Source1,String name) {
		try {
			
			String Filename=name;
			System.out.println(Filename.toString());
			//	String ThisSource = Source1+Filename;
			//	System.out.println(ThisSource);
				File fi= new File(Source1+"\\"+Filename);
				//System.out.println(fi.getAbsolutePath());
				FileOutputStream F = new FileOutputStream(fi);
				int cout;
				int s;
				while((cout=ois.read(buffer))>0) {
					//System.out.println(s+" "+name);
					//cout=ois.read(buffer);
					System.out.println(cout+" "+Filename);
					F.write(buffer, 0, cout);
				}
				System.out.println("done "+Filename);
				F.flush();
				F.close();
				
				Thread.sleep(100);
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
	}
	
	public void CheckFolderandFile(String ThisSource,int length) {
		try {
		//		String ThissSource = ThisSource;
			int cout=0;
			int size=length;
		//	System.out.println(ThissSource+ " "+size);
			while(cout<size) {
				String Data=(String)ois.readObject();
				String[] name =Data.split(":");
				if(name[0].equals("F")) {
				//	String ThissSource = ThisSource;
				//	System.out.println(ThissSource);
					Receive(ThisSource, name[1]);
				}
				else if(name[0].equals("D")) {
					String newSource=ThisSource+"\\"+name[1];
					Path dir = Paths.get(newSource);
					Files.createDirectories(dir);
					//System.out.println(newSource);
					int n=(int)ois.readObject();
					CheckFolderandFile(newSource, n);
				}
				cout++;
			}
			
			
		} catch (Exception e) {
			// TODO: handle exception
			//System.out.println(e.toString());
		}
		
		
	}
	void test() {
		String name;
		try {
			name = ois.readUTF();
			Receive(Source,name );
		} catch (IOException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
	}
	public void Reconect() {
		try {
			oos.close();
			ois.close();
			oos = new ObjectOutputStream(soc.getOutputStream());
			ois= new ObjectInputStream(soc.getInputStream());
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
		
		
	}

	@Override
	public void run() {
			//System.out.println(dis.readInt());
		int length=0;
			try {
				length=(int)ois.readObject();
				System.out.println(length);
			} catch (Exception e) {
				// TODO: handle exception
			}

		// TODO Auto-generated method stub
		while(true) {
			try {
				CheckFolderandFile(Source,length);
				//test();
				//String name;
				//name =(String) ois.readObject();
				//Receive(Source,name );
//				Object Filename=ois.readObject();
//				System.out.println(Filename.toString());
//				//	String ThisSource = Source1+Filename;
//				//	System.out.println(ThisSource);
//					File fi= new File(Source+"\\"+Filename);
//					//System.out.println(fi.getAbsolutePath());
//					FileOutputStream F = new FileOutputStream(fi);
//					int cout;
//					int s;
//					while((cout=ois.read(buffer))>0) {
//						//System.out.println(s+" "+name);
//						//cout=ois.read(buffer);
//						System.out.println(cout+" "+Filename);
//						F.write(buffer, 0, cout);
//					}
//					System.out.println("done "+Filename);
//					F.flush();
//					F.close();
//					
//					Thread.sleep(100);

			} catch (Exception e) {
				// TODO: handle exception
			//	System.out.println(e.toString());
			}
			//Reconect();
			
		}
	}

}
