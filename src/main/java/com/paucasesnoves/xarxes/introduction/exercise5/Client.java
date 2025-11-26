package com.paucasesnoves.xarxes.introduction.exercise5;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 1500)) {
            System.out.println("Connected to server at " + socket.getRemoteSocketAddress());

            System.out.println("Introduce el nombre del archivo a solicitar:");
            String filename = scanner.nextLine();

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            writer.write(filename);
            writer.newLine();
            writer.flush();

            // Recibir y mostrar la respuesta del servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String line;
            System.out.println("Respuesta del servidor:");
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
