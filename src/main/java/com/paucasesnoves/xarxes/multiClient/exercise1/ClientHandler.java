package com.paucasesnoves.xarxes.multiClient.exercise1;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            System.out.println("Cliente conectado desde " + socket.getInetAddress().getHostAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String message = reader.readLine();
            System.out.println("Mensaje recibido del cliente: " + message);
            String newMessage = message.toUpperCase();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(newMessage);
            writer.newLine();

            System.out.println(newMessage);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
