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

            //Recibir la operación y los números del cliente
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String operationMessage = reader.readLine();

            String[] parts = operationMessage.split(",");
            int operation = Integer.parseInt(parts[0]);
            double num1 = Double.parseDouble(parts[1]);
            double num2 = Double.parseDouble(parts[2]);

            double result = 0;
            String response = "";

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            switch (operation+"") {
                case "1":
                    response = "Resultado de la suma: " + (num1 + num2);
                    break;
                case "2":
                    response = "Resultado de la resta: " + (num1 - num2);
                    break;
                case "3":
                    response = "Resultado de la multiplicación: " + (num1 * num2);
                    break;
                case "4":
                    if (num2 != 0) {
                        response = "Resultado de la división: " + (num1 / num2);
                    } else {
                        writer.write("Error: División por cero.");
                    }
                    break;
                default:
                    writer.write("Operación no válida.");
            }

            //Enviar el resultado al cliente
            writer.write(response);
            writer.newLine();
            writer.flush();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
