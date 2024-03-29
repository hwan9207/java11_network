package sec3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class MyServer {
	public static void main(String[] args) {
		BufferedReader in = null; //읽기 , 입력 스트림
		PrintWriter out = null;   //쓰기, 출력 스트림
		ServerSocket server = null; //클라이언트로 연결 받는 소켓
		Socket socket = null; // 실제 통신을 담당할 소켓 
		Scanner sc = new Scanner(System.in);
		
		try {
			 server = new ServerSocket(6005); //서버 소켓 생성
			 System.out.println("Server 실행 : Client 연결 대기중입니다.");
			 socket=server.accept(); // 대기하다 클라이언트 들어오면 소켓, 클라이언트가 연결이 가능한 상태
			 System.out.println("Client 연결");
			 in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			 //입력 스트림 연결 -> 대상 : 소켓
			 out = new PrintWriter(socket.getOutputStream());
			 //클라이언트측으로 데이터 보내기 위해 출력 스트팀 연결
			 
			 while(true) {
				 String inMsg = in.readLine(); // 스트림에서 한줄의 문자를 읽고 데이터를 문자열로 반환한다.
				 if("quit".equalsIgnoreCase(inMsg)) break;
				 //equalsIgnoreCase 영 소대문자 무시하고 비교..
					 System.out.println("From Client :"+inMsg);
					 System.out.println("전송 >>>");
					
					 String outMsg = sc.next();
					 out.println(outMsg); // 송신 객체에 메세지 저장
					 out.flush(); //내가 쓸때 , 보낼때만 플러쉬해서 다 보내도록 해준다
					 if("quit".equalsIgnoreCase(outMsg)) break;
			 }
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("소켓 연결 오류");
		}finally {
			try {
				sc.close();
				socket.close();
				server.close();
				System.out.println("연결 종료");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("소켓 통신 종류 오류");
			}
		}
	}
}
