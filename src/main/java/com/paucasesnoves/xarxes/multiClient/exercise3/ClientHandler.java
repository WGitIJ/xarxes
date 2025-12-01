package com.paucasesnoves.xarxes.multiClient.exercise3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class ClientHandler implements Runnable {
    private Socket socket;

    public ClientHandler(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
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
