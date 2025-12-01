package com.paucasesnoves.xarxes.multiClient.exercise1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;

public class Server {
    public static void main(String[] args) {
        try(ServerSocket socket = new ServerSocket(2000)){
            System.out.println("Servidor inicializado. Esperando al cliente...");
            while(true){
                new Thread(new ClientHandler(socket.accept())).start();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
