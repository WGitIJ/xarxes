package com.paucasesnoves.xarxes.multiClient.exercise4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 2000)){
            System.out.println("Conectado al servidor en " + socket.getInetAddress().getHostAddress());

            // Interfaz de la calculadora
            System.out.println("=====Bienvenido a la calculadora remota.=====");
            System.out.println("¿Que operación quieres hacer?");
            System.out.println("1. Suma\n2. Resta\n3. Multiplicación\n4. División");
            int operacion = scanner.nextInt();
            System.out.println("Introduce el primer número:");
            double num1 = scanner.nextDouble();
            System.out.println("Introduce el segundo número:");
            double num2 = scanner.nextDouble();

            //Enviar la operación y los números al servidor
            BufferedWriter writer = new BufferedWriter(new java.io.OutputStreamWriter(socket.getOutputStream()));
            String mensaje = operacion + "," + num1 + "," + num2;
            writer.write(mensaje);
            writer.newLine();
            writer.flush();

            //Recibir el resultado del servidor
            BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String resultado = reader.readLine();
            System.out.println("El resultado es: " + resultado);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
