package s1818;

import java.io.FileOutputStream;
import java.io.IOException;

public class Exam1 {
	public static void main(String[] args) {
		output1();
	}
	public static void output1() {
		FileOutputStream fos = null;
		try {//FileOutputStream 파일에 text를 쓸 수 있게 하는 클래스
			fos = new FileOutputStream("test.txt");
			String str = "안녕하세요!";
			byte[] bytes = str.getBytes();
			fos.write(bytes);
			// Stream은 바이트로 변환하여 사용해야 한다
			// for문을 사용하여 문자 하나씩 변환해줄 필요가 없다..
//			for(int i=0; i<str.length();i++) {
//				fos.write(str.charAt(i));
//				bytes = str.charAt(i);
//			} 
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {// Stream은 사용하고 닫아주어야 한다.
				fos.close();
			} catch (IOException e) {
				e.printStackTrace();
			 }
		}
	}

}
