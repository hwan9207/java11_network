package sec1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TestServer {
	public static void main(String[] args) {
		BufferedReader in = null;
		PrintWriter out = null;
		ServerSocket server =null;
		Socket socket = null;
		Scanner sc = new Scanner(System.in);
		
		try {
			server = new ServerSocket(2818);
			System.out.println("연결 대기중 입니다.");
			socket = server.accept();
			System.out.println("연결 가능 합니다.");
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream()); 
			while(true) {
				String inmsg = in.readLine();
				if("quit".equalsIgnoreCase(inmsg)) break;
					System.out.println("[From Client] : "+inmsg);
					System.out.println("[전송] :");
				String outmsg = sc.nextLine();
				out.print(outmsg);
				out.flush();
				if("quit".equalsIgnoreCase(outmsg)) break;
			}
				
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("연결 오류가 발생 했습니다.");
		}finally {
			try {
				sc.close();
				socket.close();
				server.close();
				System.out.println("연결 종료");
			} catch (IOException e) {
				e.printStackTrace();
				System.out.println("종료 오류");
			}
		}
	}
}
