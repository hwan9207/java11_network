package sec1;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;

public class MultiServer {

	public static void main(String[] args) {
		MultiServer multi = new MultiServer();
		multi.start();
	}
	public void start() {
		try {
			InetAddress local = InetAddress.getLocalHost();
			String addr = local.getHostAddress();
		} catch (UnknownHostException e1) {
			e1.printStackTrace();
		}
		ServerSocket server = null;
		Socket socket = null;
		
		try {
			server =new ServerSocket(8000);
			while(true) {
				System.out.println("Server 실행 : Client 연결 대기중입니다.");
				socket=server.accept();
				ReceiveThread receiveThread = new ReceiveThread(socket);
				receiveThread.start();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}finally {
			if(server!=null) {
				try {
					server.close();
					System.out.println("server 종료");
				} catch (IOException e) {
					System.out.println("서보 소켓 통신 오류");
					e.printStackTrace();
				}
			}
		}
	}
}
