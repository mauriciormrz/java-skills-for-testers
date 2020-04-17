package serenitylabs.tutorials.vetclinic.sales.model;

public class StandardRateCalculator implements TaxRateCalculator {

    @Override
    public TaxRate rateFor(LineItem item) {

        return new TaxRate(0.23,"Standard");

    }
}
