package com.paucasesnoves.xarxes.introduction.exercise1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try (ServerSocket servidor = new ServerSocket(2222)) {
            System.out.println("Servidor inicializado. Esperando al cliente...");

            Socket socket = servidor.accept();
            System.out.println("Cliente conectado desde " + socket.getInetAddress().getHostAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = reader.readLine();
            System.out.println("Mensaje recibido del cliente: " + message);
            String newMessage = message.toUpperCase();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(newMessage);
            writer.newLine();
            writer.flush();
            System.out.println("Mensaje enviado al cliente: " + newMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
