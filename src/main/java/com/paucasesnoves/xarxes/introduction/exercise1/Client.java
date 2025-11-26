package com.paucasesnoves.xarxes.introduction.exercise1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",2222)) {
            System.out.println("Cliente conectado al servidor en " + socket.getInetAddress().getHostAddress());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Escribe un mensaje para enviar al servidor:");
            String message = scanner.nextLine();
            writer.write(message);
            writer.newLine();
            writer.flush();
            System.out.println("Mensaje enviado al servidor: " + message);

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            line = reader.readLine();
            System.out.println("Mensaje recibido del servidor: " + line);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
