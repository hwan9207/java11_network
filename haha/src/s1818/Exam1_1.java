package s1818;

import java.io.FileWriter;
import java.io.IOException;

public class Exam1_1 {
	public static void main(String[] args) {
		output1();
	}
	public static void output1() {
		FileWriter fos = null;
		try { //FileOutputStream은 저장되는 데이터 전송할때는 바이트 단위로 전송하기 때문에 한글이 정상적으로 인코딩 되지 않는다 FileWriter로 변경하여 
			fos = new FileWriter("test.txt");
			String str = "안녕하세요!"; 
			fos.write(str);
//			for(int i=0; i<str.length();i++) {
//				fos.write(str.charAt(i)); 
//			} 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			  }
		 }
	}

}
