package com.paucasesnoves.xarxes.introduction.exercise3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.util.Scanner;

public class Server {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try(ServerSocket sever = new ServerSocket(2222)){
            System.out.println("Servidor inicializado. Esperando al cliente...");

            Socket socket = sever.accept();
            System.out.println("Cliente conectado desde " + socket.getInetAddress().getHostAddress());

            //Recibir el JSON del cliente
            BufferedReader reaedr = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String jsonAddress = reaedr.readLine();
            System.out.println("Dirección recibida del cliente: " + jsonAddress);

            //Guardar el JSON en un archivo de texto
            FileWriter file = new FileWriter("direcciones.txt");
            BufferedWriter writer = new BufferedWriter(file);
            writer.write(jsonAddress);
            writer.newLine();
            writer.flush();
            writer.close();

            //Enviar respuesta al cliente
            BufferedWriter responseWriter = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()) );
            responseWriter.write("OK");
            responseWriter.newLine();
            responseWriter.flush();
            responseWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
