package com.paucasesnoves.xarxes.introduction.exercise4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(2000)){
            System.out.println("Servidor inicializado. Esperando al cliente...");

            Socket socket = server.accept();
            System.out.println("Cliente conectado desde " + socket.getInetAddress().getHostAddress());

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            String operation = reader.readLine();
            String num1 = reader.readLine();
            String num2 = reader.readLine();

            if (operation == "1") {
                writer.write("Suma: " + (Integer.parseInt(num1) + Integer.parseInt(num2)));
            } else if (operation == "2") {
                writer.write("Resta: " + (Integer.parseInt(num1) - Integer.parseInt(num2)));
            } else if (operation == "3") {
                writer.write("Multiplicación: " + (Integer.parseInt(num1) * Integer.parseInt(num2)));
            } else if (operation == "4") {
                writer.write("División: " + (Integer.parseInt(num1) / Integer.parseInt(num2)));
            } else {
                writer.write("Operación no válida");
            }

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
