package com.capgemini.java_adv.fw.hibernate_jpa.vehicle_registration.main;

import java.time.LocalDate;
import java.util.Scanner;

import com.capgemini.java_adv.fw.hibernate_jpa.vehicle_registration.service.VehicleService;

public class App {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        VehicleService service = new VehicleService();

        String brand = sc.next();
        String model = sc.next();
        String regNumber = sc.next();
        LocalDate expiryDate = LocalDate.parse(sc.next());

        service.addVehicle(brand, model, regNumber, expiryDate);

        sc.close();
    }
}