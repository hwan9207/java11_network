package sec1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestClient {
	public static void main(String[] args) {
		BufferedReader in = null;
		PrintWriter out = null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		
		socket = new Socket();
		try {
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
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			try {
				sc.close();
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

}
