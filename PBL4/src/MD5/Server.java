package MD5;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;


public class Server implements Runnable {
	ServerSocket server;
	static Vector<Handle> Clients = new Vector<Handle>();
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server();
	}
	Server(){	
//		try {
//			String s="E:\\\\New folder\\\\File-sender\\\\FileServer";
//			File[] ListF = new File(s).listFiles();
//			for (File i : ListF) {
//				File F= new File(i.getAbsoluteFile().toString());
//				FileInputStream f1=new FileInputStream(F);
//				System.out.println(i.getName()+ " "+f1.read(new byte[8192]));
//		}} catch (Exception e) {
//			// TODO: handle exception
//		}
		
		try {
			server = new ServerSocket(5024);
			while(true) {
				Socket soc= server.accept();
				Handle Client = new Handle(soc);
				Clients.add(Client);
				Client.start();
			}
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	

	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println("running");
	
		
	}

}
class Handle extends Thread{
	Socket soc;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	Handle(Socket S){
		try {
			this.soc =S;
			
			oos = new ObjectOutputStream(soc.getOutputStream());
			ois= new ObjectInputStream(soc.getInputStream());
//			dos.writeUTF(Filename);
//			FileInputStream f=new FileInputStream("E:\\New folder\\File-sender\\FileServer\\"+Filename);
			String s="D:\\Study\\Server\\";
//			File[] ListF = new File(s).listFiles();
//			for (File i : ListF) {
//
//			//	send(i,oos);
//			//	Thread.sleep(100);
//				//dos = new DataOutputStream(soc.getOutputStream());
//			}
			//oos.write(0);
			SendFileandFolder(s);
			oos.close();
			
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		

		

	}
	public	void SendFileandFolder(String Fsource) {
		try {
			//System.out.println(Fsource);
			File[] ListF = new File(Fsource).listFiles();
			oos.writeObject(ListF.length);
			oos.flush();
			for (File i : ListF) {
				if(i.isDirectory()==true) {
					System.out.println("path");
				//	continue;
					oos.writeObject("D:"+i.getName());
					SendFileandFolder(i.getAbsolutePath());
				}
				else send(i,oos);
				Thread.sleep(100);
				//oos.write(new byte[0], 0, 0);
				
			}
		//	dos.writeInt(0);
		} catch (Exception e) {
			// TODO: handle exception
		}
		
	}
	
	
	void send(File i,ObjectOutputStream oos) throws IOException {

		try {
			FileInputStream f;
			byte[] buffer = new byte[8192];
			int count;
		
			String Filename=i.getName();
			oos.writeObject("F:"+Filename);
			//oos.writeObject(Filename);
			oos.flush();
		//	FileReader Fr=new FileReader(i);
		//	BufferedReader br = new BufferedReader(Fr);
			//br.close();
			//String line;
			f=new FileInputStream(i);
		    while ((count=f.read(buffer))>0) {
				System.out.println(count+" "+Filename);
			//	dos.writeUTF("1");
				oos.write(buffer, 0, count);
				}
			f.close();
		//	br.close();
			oos.flush();
			//dos.writeInt(-1);

		} catch (Exception e) {
			// TODO: handle exception
			System.out.println(e.toString());
		}
		//Reconect();
		//dos.writeUTF("-1");
		//dos.flush();
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
	public void run() {
//		while(true) {
//			try {
//			
//				String Filename="hahaha.txt";
//				FileInputStream f=new FileInputStream("E:\\New folder\\File-sender\\FileServer/"+Filename);
//			//	oos = new ObjectOutputStream(soc.getOutputStream());
//				for (Handle p : Server.Clients) {
//					try {
//					//	p.dos.writeUTF(Filename);
//					//	p.oos.writeObject(f);
//					} catch (Exception e1) {
//
//					}
//
//				
//				
//			}
//				}
//					catch (Exception e) {
//				// TODO: handle exception
//			}
//		}
	}
}
