package MD5;

import java.io.File;
import java.io.FileOutputStream;
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
	String Source = "D:\\Study\\Client\\";
	byte[] buffer = new byte[8192];

	public static void main(String[] args) {
		new Thread(new Client()).start();
	}

	public Client() {
		try {
			soc = new Socket("localhost", 5024);
			oos = new ObjectOutputStream(soc.getOutputStream());
			ois = new ObjectInputStream(soc.getInputStream());
		} catch (Exception e) {

		}
	}

	public void Receive(String Source1, String name) {
		try {

			String Filename = name;
			System.out.println(Filename.toString());
			File fi = new File(Source1 + "\\" + Filename);
			FileOutputStream F = new FileOutputStream(fi);
			int cout;
			while ((cout = ois.read(buffer)) > 0) {
				System.out.println(cout + " " + Filename);
				F.write(buffer, 0, cout);
			}
			System.out.println("done " + Filename);
			F.flush();
			F.close();
			Thread.sleep(100);
		} catch (Exception e) {

		}
	}

	public void CheckFolderandFile(String ThisSource, int length) {
		try {
			int cout = 0;
			int size = length;
			while (cout < size) {
				String Data = (String) ois.readObject();
				String[] name = Data.split(":");
				if (name[0].equals("F")) {
					Receive(ThisSource, name[1]);
				} else if (name[0].equals("D")) {
					String newSource = ThisSource + "\\" + name[1];
					Path dir = Paths.get(newSource);
					Files.createDirectories(dir);
					int n = (int) ois.readObject();
					CheckFolderandFile(newSource, n);
				}
				cout++;
			}
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
		int length = 0;
		try {
			length = (int) ois.readObject();
			System.out.println(length);
		} catch (Exception e) {

		}
		while (true) {
			try {
				CheckFolderandFile(Source, length);
			} catch (Exception e) {

			}
		}
	}
}
