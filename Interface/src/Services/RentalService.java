package Services;

import entidades.CarRental;
import entidades.Invoice;

public class RentalService {
    private Double pricePerDay;
    private Double pricePerHour;

    private BrazilTaxService taxService;

    public RentalService(){

    };

    public RentalService(Double pricePerDay, Double pricePerHour, BrazilTaxService taxService) {
        this.pricePerDay = pricePerDay;
        this.pricePerHour = pricePerHour;
        this.taxService = taxService;
    };

    public void processInvoice(CarRental carRental){
        long tempoInicialLocacao = carRental.getStart().getTime();
        long tempoFinalLocacao = carRental.getFinish().getTime();
        //int teste = carRental.getFinish().compareTo(carRental.getStart());
        double hours = (double) (tempoInicialLocacao - tempoFinalLocacao) / 1000 / 60 / 60;

        double basicPayments;
        if(hours <= 12){
             basicPayments = Math.ceil(hours) * pricePerHour;
        }else{
            basicPayments = Math.ceil(hours / 24) * pricePerDay;
        }

        double tax = taxService.tax(basicPayments);

        carRental.setInvoice(new Invoice(basicPayments, tax));
    }
}
