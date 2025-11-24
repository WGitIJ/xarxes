package com.paucasesnoves.xarxes.introduction.exercise3;

import com.fasterxml.jackson.core.type.TypeReference;

import java.io.BufferedWriter;
import java.io.File;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 2222)){
            System.out.println("Conectado al servidor en " + socket.getInetAddress().getHostAddress());

            BufferedWriter writer = new BufferedWriter(new java.io.OutputStreamWriter(socket.getOutputStream()));
            System.out.print("Introduce el nombre de la calle: ");
            String street = scanner.nextLine();
            System.out.print("Introduce el código postal: ");
            String zipCode = scanner.nextLine();
            System.out.print("Introduce el país: ");
            String country = scanner.nextLine();
            System.out.print("Introduce el número: ");
            int number = Integer.parseInt(scanner.nextLine());

            Address address = new Address(street, zipCode, country, number);

            //Generate a JSON representation of the address object
            File file = new File("address.json");

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
