package sec1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ReceiveThread extends Thread {
	//동기화 컬렉션 : 여러 사용자가 현재 목록을 공유하고 있어야 한다.
	static List<PrintWriter> list = Collections.synchronizedList(new ArrayList<>()); //static으로 생성 하기때문에  
	
	Socket socket = null; //null로 선언해야 나중에 null!=close 사용 용의
	BufferedReader in = null;
	PrintWriter out = null;
	
	public ReceiveThread(Socket socket) {
		this.socket = socket;
		 try {
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new PrintWriter(socket.getOutputStream());
			list.add(out);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void run() {
		String name = "";
		try {
			name = in.readLine();//readLine 을 타고 들어온다?
			System.out.println("["+name+"] 새로운 연결 생성");
			sendAll("["+name+"] 님이 들어 오셨습니다.");
			
			while(in != null) {
				String inMsg = in.readLine();
				if("quit".equalsIgnoreCase(inMsg)) break;
				sendAll(name+">>"+inMsg);
			}
		} catch (IOException e) {
			System.out.println("["+name+"접속 끊김]");
			e.printStackTrace();
		} finally {
			System.out.println("["+name+"] 님이 나가셨습니다.");
			list.remove(out);
			try {
				socket.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		System.out.println("["+name+"] 연결 종료");
	}
	
	private void sendAll(String s) {
		for(PrintWriter out : list) {
			out.println(s);
			out.flush();
		}
	}
}
