package MD5;

import java.io.BufferedInputStream;
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
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Vector;

public class Server1 implements Runnable {
	ServerSocket server;
	static Vector<Handle> Clients = new Vector<Handle>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Server1();
	}

	Server1() {

//		String s="E:\\\\New folder\\\\File-sender\\\\FileServer\\";
//
//
//		Path dir = Paths.get(s+"test");
//		try {
//			Files.createDirectories(dir);
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}

		try {
			server = new ServerSocket(5000);
			while (true) {
				Socket soc = server.accept();
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

class Handle extends Thread {
	Socket soc;
	ObjectOutputStream oos;
	ObjectInputStream ois;
	DataOutputStream dos;
	DataInputStream dis;

	Handle(Socket S) {
		try {
			this.soc = S;

			dos = new DataOutputStream(soc.getOutputStream());
			dis = new DataInputStream(soc.getInputStream());
//			dos.writeUTF(Filename);
//			FileInputStream f=new FileInputStream("E:\\New folder\\File-sender\\FileServer\\"+Filename);
			String s = "D:\\Study\\Server";
//			File[] ListF = new File(s).listFiles();
//			for (File i : ListF) {
//				send(i,dos);
//				Thread.sleep(100);
//				//dos = new DataOutputStream(soc.getOutputStream());
//			}
			SendFileandFolder(s);

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void SendFileandFolder(String Fsource) {
		try {
			// System.out.println(Fsource);
			File[] ListF = new File(Fsource).listFiles();
			dos.writeInt(ListF.length);
			for (File i : ListF) {
				if (i.isDirectory() == true) {
					System.out.println("path");
					// continue;
					dos.writeUTF("D:" + i.getName());
					SendFileandFolder(i.getAbsolutePath());
				} else
					send(i, dos);
				Thread.sleep(100);

			}
			dos.writeInt(0);
		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	void send(File i, DataOutputStream dos) throws IOException {
		try {
			byte[] buffer = new byte[8192];
			int count;

			String Filename = i.getName();
			dos.writeUTF("F:" + Filename);
			// dos.writeUTF(Filename);
			BufferedInputStream br = new BufferedInputStream(new FileInputStream(i));
			byte[] fileBytes = new byte[(int) i.length()];
			// get file info

			// String line;
			while ((count = br.read(fileBytes, 0, fileBytes.length)) >= 0) {
				System.out.println(count + " " + Filename);
				dos.writeInt(1);
				dos.write(buffer, 0, count);
			}
			dos.writeInt(-1);
		} catch (Exception e) {
			// TODO: handle exception
			dos.writeInt(-1);
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
