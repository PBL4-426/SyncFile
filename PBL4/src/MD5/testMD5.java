package MD5;

import java.io.IOException;

public class testMD5 {

	public static void main(String[] args) {
		String fileName1 = "D:\\Study\\Test/TTP.png";
		String fileName2 = "D:\\Study\\Test/TTP2.png";
		String hashValue = "";
		String hashValue1 = "";
		// First Method
		try {
			if (MD5Check.CompareFiles(fileName1, fileName2) == true)
				System.out.println("No Difference encountered  using CompareFilesbyByte method");
			else
				System.out.println("Both Files are not equal using CompareFilesbyByte method");
		} catch (Exception e) {
			System.out.println("Error");
		}
		System.out.println();

		// IInd Method
		try {
			hashValue = MD5Check.MD5HashFile(fileName1);
			hashValue1 = MD5Check.MD5HashFile(fileName2);
			System.out.println(hashValue + ", " + hashValue1);
//			if (hashValue.equals(hashValue1))
//				System.out.println("No Difference encountered using method MD5Hash");
//			else
//				System.out.println("Both Files are not equal  using MD5Hash");
		} catch (Exception e) {
			System.out.println("Error");
		}
	}

}
