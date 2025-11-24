package com.paucasesnoves.xarxes.introduction.exercise4;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost",2000)) {
            System.out.println("Conectado al servidor en " + socket.getInetAddress().getHostAddress());

            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
            System.out.println("Que operación quieres hacer?");
            System.out.println("1. Sumar");
            System.out.println("2. Restar");
            System.out.println("3. Multiplicar");
            System.out.println("4. Dividir");
            String operation = scanner.nextLine();
            writer.write(operation);
            writer.newLine();
            writer.flush();

            System.out.println("Introduce el primer número:");
            String num1 = scanner.nextLine();
            writer.write(num1);
            writer.newLine();
            writer.flush();

            System.out.println("Introduce el segundo número:");
            String num2 = scanner.nextLine();
            writer.write(num2);
            writer.newLine();
            writer.flush();

            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String result = reader.readLine();
            System.out.println("Resultado del servidor: " + result);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
