package com.paucasesnoves.xarxes.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Emisor {
    public static void main(String[] args) {
        String mensaje;
        int puertoReceptor = 5000;
        Scanner scanner = new Scanner(System.in);

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress direccionReceptor = InetAddress.getByName("localhost");
            mensaje = scanner.nextLine();
            // Enviar mensaje
            byte[] mensajeBytes = mensaje.getBytes();
            DatagramPacket paquete = new DatagramPacket(mensajeBytes, mensajeBytes.length, direccionReceptor, puertoReceptor);
            socket.send(paquete);
            System.out.println("Mensaje enviado: " + mensaje);

            // Recibir respuesta
            byte[] buffer = new byte[1024];
            DatagramPacket paqueteRespuesta = new DatagramPacket(buffer, buffer.length);
            socket.receive(paqueteRespuesta);

            String respuesta = new String(paqueteRespuesta.getData(), 0, paqueteRespuesta.getLength());
            System.out.println("Respuesta recibida: " + respuesta);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
