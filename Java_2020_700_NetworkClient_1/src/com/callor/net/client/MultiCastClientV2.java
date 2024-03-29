package com.callor.net.client;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MultiCastClientV2 {

	public static void main(String[] args) throws IOException {

		MulticastSocket socket = new MulticastSocket(4446);
		InetAddress address = InetAddress.getByName("230.0.0.1");
		socket.joinGroup(address);

		DatagramPacket packet;

		// get a few quotes
		for (int i = 0; i < 5; i++) {

			byte[] buf = new byte[256];
			packet = new DatagramPacket(buf, buf.length);
			socket.receive(packet);

			String received = new String(packet.getData(), 0, packet.getLength());
			System.out.println("Quote of the Moment: " + received);
		}

		socket.leaveGroup(address);
		socket.close();
	}

}