package serenitylabs.tutorials.vetclinic.sales.model;

public interface TaxRateCalculator {

    TaxRate rateFor(LineItem item);
}
