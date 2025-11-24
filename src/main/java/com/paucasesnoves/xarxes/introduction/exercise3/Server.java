package com.paucasesnoves.xarxes.introduction.exercise3;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try(ServerSocket sever = new ServerSocket(2222)){
            System.out.println("Servidor inicializado. Esperando al cliente...");

            Socket socket = sever.accept();
            System.out.println("Cliente conectado desde " + socket.getInetAddress().getHostAddress());


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
