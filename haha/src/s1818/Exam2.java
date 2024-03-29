package s1818;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class Exam2 {
	public static void main(String[] args) {
		//1. 서버 소켓에 문제에서 제시한 포트 번호를 입력하지 않아 서버소켓이 생성되지 못하여 통신 접속 불가능하다
		//2. 클라이언트 소켓에 서버소켓의 아이피 주소와 포트 번호를 입력하지 않아 서버에 접속 불가능하다
		
		//.getConnection URL의 주소가 잘못되어 3306/kh, 데이터베이스 이름이 지정되어 있지 않으므로 해당 데이터베이스에 연결이 불가능하다
		//.query의 sql 구문 지정되어 있지 않으므로 
		// executeUpdate 메소드는 int를 반환하므로 해당 검색 결과인 
		// while 문장에서 rs는 다음 레코드를 지칭해야 레코드가 끝날때까지 반복 수행 
		// 문제 제시한 변수명 틀림
		try {
			String ip = InetAddress.getLocalHost().getHostAddress();
			System.out.println(ip);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
