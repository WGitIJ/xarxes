package com.paucasesnoves.xarxes.introduction.exercise2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Scanner scanner = new Scanner(System.in);
    static String response;
    public static void main(String[] args) {
        int clientNumber;
        try(Socket socket = new Socket("localhost", 2222)) {
            System.out.println("Client connected to server at " + socket.getInetAddress().getHostAddress());
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            BufferedReader reader = new BufferedReader(new java.io.InputStreamReader(socket.getInputStream()));
            do{
                System.out.println("Introduce un número entre 1 y 5:");
                clientNumber = scanner.nextInt();
                writer.write(String.valueOf(clientNumber));
                writer.newLine();
                writer.flush();
                response = reader.readLine();
                System.out.println("Respuesta del servidor: " + response);
            } while (!response.contains("Correcto")); // El client no sap el número aleatori
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
