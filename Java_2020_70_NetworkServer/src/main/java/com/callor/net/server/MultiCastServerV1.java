package com.callor.net.server;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class MultiCastServerV1 {

	private DatagramSocket socket;
	private InetAddress group;
	private byte[] buf;

	public void multicast(String multicastMessage) throws IOException {
		socket = new DatagramSocket();
		group = InetAddress.getByName("230.0.0.0");
		buf = multicastMessage.getBytes();

		DatagramPacket packet = new DatagramPacket(buf, buf.length, group, 4446);
		socket.send(packet);
		socket.close();
	}
}