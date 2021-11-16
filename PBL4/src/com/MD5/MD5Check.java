package MD5;

import java.io.FileInputStream;
import java.io.InputStream;
// Lib for encrypting file to MD5
import java.security.MessageDigest;

public class MD5Check {
	// Compare to 2 files by hash
	// Return true: equal - false: not equal
	public static boolean CompareFiles(String hashSrc, String hashDes){
		return hashSrc.equals(hashDes);
	}
	// Hashing file by MD5
	// Return the hexadecimal series 32-bits
	public static String MD5HashFile(String fileName) throws Exception {
		// Checksum file
		byte[] buf = ChecksumFile(fileName);
		// Format hexa
		String res = "";
		for (int i = 0; i < buf.length; i++) {
			res += Integer.toString((buf[i] & 0xff) + 0x100, 16).substring(1);
		}
		return res;
	}
	// Checksum file
	// Return hashing MD5
	public static byte[] ChecksumFile(String fileName) throws Exception {
		InputStream fis = new FileInputStream(fileName);
		byte[] buf = new byte[1024];
		MessageDigest complete = MessageDigest.getInstance("MD5");
		int n;
		// Read file by bytes
		do {
			n = fis.read(buf);
			if (n > 0) {
				// create hashing
				complete.update(buf, 0, n);
			}
		} while (n != -1);
		fis.close();
		// return value of digest by bytes 
		return complete.digest();
	}
}
