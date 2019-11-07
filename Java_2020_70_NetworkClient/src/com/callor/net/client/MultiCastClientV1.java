package com.callor.net.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MultiCastClientV1 implements Runnable {

	protected MulticastSocket socket = null;
	protected byte[] buf = new byte[256];

	public void run() {
		try {
			socket = new MulticastSocket(4446);
			InetAddress group = InetAddress.getByName("230.0.0.0");
			socket.joinGroup(group);
			while (true) {
				DatagramPacket packet = new DatagramPacket(buf, buf.length);
				socket.receive(packet);
				String received = new String(packet.getData(), 0, packet.getLength());
				if ("end".equals(received)) {
					break;
				}
			}
			socket.leaveGroup(group);
			socket.close();

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
