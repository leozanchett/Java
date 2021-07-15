package com.company;

import Services.BrazilTaxService;
import Services.RentalService;
import entidades.CarRental;
import entidades.Veiculo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws ParseException {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:ss");
        System.out.println("Rental Cars: ");
        System.out.print("Modelo do carro: ");
        String carModel = sc.nextLine();
        System.out.print("Locação (dd/MM/yyyy HH:ss): ");
        Date start = sdf.parse(sc.nextLine());
        System.out.print("Entrega (dd/MM/yyyy HH:ss): ");
        Date finish = sdf.parse(sc.nextLine());

        CarRental car = new CarRental(start, finish,  new Veiculo(carModel));
        System.out.print("Preço por hora: ");
        double pricePerHour = sc.nextDouble();
        System.out.print("Preço por dia: ");
        double pricePerDay = sc.nextDouble();

        RentalService rentalService = new RentalService(pricePerDay, pricePerHour, new BrazilTaxService());

        rentalService.processInvoice(car);
        System.out.println("INVOICE");
        System.out.println("Basic payment: "+String.format("%.2f", car.getInvoice().getBasicPayment()));
        System.out.println("Tax: "+String.format("%.2f", car.getInvoice().getTax()));
        System.out.println("Total payments: "+String.format("%.2f", car.getInvoice().getTotalPayments()));
        sc.close();
    }
}
