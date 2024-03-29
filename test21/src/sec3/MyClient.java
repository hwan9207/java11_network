package sec3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class MyClient {

	public static void main(String[] args) {
		BufferedReader in = null; 
		PrintWriter out = null;
		
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		
		try {// 서버는 연결 대기만 하고 연결은 클라이언트에서 소켓 생성해서 !!
			socket = new Socket("192.168.20.219", 6005); //상대 컴퓨터 ip 폰트 연결 시키면 채팅 가능
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			while(true) {
			System.out.println("전송하기>>>");
			String outMsg = sc.next(); //입력
			out.print(outMsg); //아웃메세지를 Writer에 저장
			out.flush();
			if("quit".equalsIgnoreCase(outMsg)) break;
			
			String inMsg = in.readLine(); // 읽어오기
			System.out.println("From Server"+inMsg);
			if("quit".equalsIgnoreCase(inMsg)) break;
			}
		} catch (UnknownHostException e) {
			e.printStackTrace();
			System.out.println("정보 오류??");
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("소켓 통신 오류");
			
		}finally {
			try {
				sc.close();
				if(socket!=null) socket.close(); //if(socket!=null) 없이 그냥 닫아줘도 된다
				System.out.println("서버 연결 종료");
			} catch (IOException e) {
				System.out.println("소켓통신 종료 오류");
				e.printStackTrace();
			}
		}
	}
}
