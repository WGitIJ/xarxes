package com.paucasesnoves.xarxes.UDP;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Receptor {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int puerto = 5000; // Puerto donde recibirá mensajes

        try (DatagramSocket socket = new DatagramSocket(puerto)) {
            System.out.println("ClienteReceptor escuchando en el puerto " + puerto);

            byte[] buffer = new byte[1024];

            // Recibir mensaje
            DatagramPacket paquete = new DatagramPacket(buffer, buffer.length);
            socket.receive(paquete);

            String mensajeRecibido = new String(paquete.getData(), 0, paquete.getLength());
            System.out.println("Mensaje recibido: " + mensajeRecibido);

            // Preparar respuesta
            String respuesta = "Hola, he recibido tu mensaje: " + mensajeRecibido;
            byte[] respuestaBytes = respuesta.getBytes();

            InetAddress direccionEmisor = paquete.getAddress();
            int puertoEmisor = paquete.getPort();

            DatagramPacket paqueteRespuesta = new DatagramPacket(respuestaBytes, respuestaBytes.length, direccionEmisor, puertoEmisor);
            socket.send(paqueteRespuesta);

            System.out.println("Respuesta enviada al emisor.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
