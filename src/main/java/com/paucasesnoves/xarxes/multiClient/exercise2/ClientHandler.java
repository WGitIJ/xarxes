package com.paucasesnoves.xarxes.multiClient.exercise2;

import java.io.*;
import java.net.Socket;

public class ClientHandler implements Runnable{
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }


    @Override
    public void run() {
        try{
            System.out.println("Cliente conectado desde " + socket.getInetAddress().getHostAddress());

            int randomNumber = (int) (Math.random() * 5) + 1;

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            int clientNumber;
            do {
                clientNumber = Integer.parseInt(reader.readLine());
                if (clientNumber < randomNumber) {
                    System.out.println("El número " + clientNumber + " es menor que el número aleatorio.");
                    writer.write("El número " + clientNumber + " es menor que el número aleatorio.");
                    writer.newLine();
                    writer.flush();
                } else if (clientNumber > randomNumber) {
                    System.out.println("El número " + clientNumber + " es mayor que el número aleatorio.");
                    writer.write("El número " + clientNumber + " es mayor que el número aleatorio.");
                    writer.newLine();
                    writer.flush();
                } else {
                    System.out.println("El número " + clientNumber + " es igual al número aleatorio. ¡Correcto!");
                    writer.write("El número " + clientNumber + " es igual al número aleatorio. ¡Correcto!");
                    writer.newLine();
                    writer.flush();
                    break;
                }
            } while (clientNumber != randomNumber);
            socket.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
