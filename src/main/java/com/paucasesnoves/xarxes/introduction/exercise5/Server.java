package com.paucasesnoves.xarxes.introduction.exercise5;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket server = new ServerSocket(1500)) {
            System.out.println("Servidor inicializado. Esperando al cliente...");

            Socket socket = server.accept();
            System.out.println("Cliente conectado desde " + server.getInetAddress().getHostAddress());

            // Leer el nombre del archivo solicitado por el cliente
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String filename = reader.readLine();
            System.out.println("El cliente ha solicitado el archivo: " + filename);

            // Comprobar si el archivo existe
            File file = new File(filename);
            if (!file.exists()){
                System.out.println("El archivo solicitado no existe.");
            } else {
                BufferedReader fileReader = new BufferedReader(new FileReader(filename));
                String line;
                System.out.println("Contenido del archivo:");
                while ((line = fileReader.readLine()) != null) {
                    System.out.println(line);
                }
                fileReader.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
