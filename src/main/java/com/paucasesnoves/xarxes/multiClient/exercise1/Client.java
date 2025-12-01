package com.paucasesnoves.xarxes.multiClient.exercise1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class Client {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 2000)){
            System.out.println("Cliente conectado al servidor: " + socket.getInetAddress().getHostAddress());
            System.out.println("Escribe un mensaje para enviar al servidor:");
            String message = scanner.nextLine();
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(message);
            writer.newLine();
            writer.flush();
        } catch (UnknownHostException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
