package serenitylabs.tutorials.vetclinic.sales.model;

import java.util.function.Function;

public interface TaxRateCalculator extends Function<LineItem, TaxRate> {

}
