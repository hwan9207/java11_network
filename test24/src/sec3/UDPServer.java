package sec3;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPServer { //한대에서 연결 사용 안됨

	public static void main(String[] args) {
		DatagramSocket socket = null;
		DatagramPacket packet = null; 
		// 데이터를 packet에 담아서 socket으로 연결해서 보내는건가?
		int port = 7000;
		try {
			socket = new DatagramSocket(port);
			//buffer 보낼 데이터? , receive 
			while(true) {
				byte[] buffer = new byte[512];
				//수신
				packet = new DatagramPacket(buffer, buffer.length);
				System.out.println("ready");
				socket.receive(packet);	//실린 수신 데이터 패킷 받기 
				String rData = new String(packet.getData());	//패킷(byte) 데이터 => String으로 형 변환
				System.out.println("수신 데이터 : "+rData);
				
				InetAddress ip = packet.getAddress();
				port = packet.getPort();
				System.out.println("[Client IP Address] : "+ip);
				System.out.println("[Client Port] : "+port);
				//송신(발신)
				packet = new DatagramPacket(packet.getData(), packet.getData().length, ip, port);
				socket.send(packet);	//송신 데이터 패킷 실어 보내기
			}
		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}
