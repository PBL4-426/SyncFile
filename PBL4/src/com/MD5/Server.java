package MD5;

import java.io.File;
import java.io.FileInputStream;
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
		new Server();
	}

	public Server() {

		try {
			server = new ServerSocket(5024);
			while (true) {
				Socket soc = server.accept();
				Handle Client = new Handle(soc);
				Clients.add(Client);
				Client.start();
			}
		} catch (Exception e) {

		}
	}

	@Override
	public void run() {

	}

}

class Handle extends Thread {
	Socket soc;
	ObjectOutputStream oos;
	ObjectInputStream ois;

	Handle(Socket S) {
		try {
			this.soc = S;

			oos = new ObjectOutputStream(soc.getOutputStream());
			ois = new ObjectInputStream(soc.getInputStream());
			String s = "D:\\Study\\Server\\";
			SendFileandFolder(s);
			oos.close();
		} catch (Exception e) {

		}
	}

	public void SendFileandFolder(String Fsource) {
		try {
			File[] ListF = new File(Fsource).listFiles();
			oos.writeObject(ListF.length);
			oos.flush();
			for (File i : ListF) {
				if (i.isDirectory() == true) {
					oos.writeObject("D:" + i.getName());
					SendFileandFolder(i.getAbsolutePath());
				} else
					send(i, oos);
				Thread.sleep(100);
			}
		} catch (Exception e) {

		}
	}

	void send(File i, ObjectOutputStream oos) throws IOException {
		try {
			FileInputStream f;
			byte[] buffer = new byte[8192];
			int count;

			String Filename = i.getName();
			oos.writeObject("F:" + Filename);
			oos.flush();
			f = new FileInputStream(i);
			while ((count = f.read(buffer)) > 0) {
				System.out.println(count + " " + Filename);
				oos.write(buffer, 0, count);
			}
			f.close();
			oos.flush();
		} catch (Exception e) {

		}
	}

	public void Reconect() {
		try {
			oos.close();
			ois.close();
			oos = new ObjectOutputStream(soc.getOutputStream());
			ois = new ObjectInputStream(soc.getInputStream());

		} catch (Exception e) {

		}
	}

	@Override
	public void run() {

	}
}
