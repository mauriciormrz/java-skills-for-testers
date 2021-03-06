package serenitylabs.tutorials.vetclinic.sales.model;

import java.util.HashMap;
import java.util.Map;

import static serenitylabs.tutorials.vetclinic.sales.model.ProductCategory.*;

public class SalesTaxService {

    static TaxRateCalculator STANDARD_RATE
            = (item) -> new TaxRate(0.23, "Standard");

    static TaxRateCalculator ZERO_RATE
            = (item) -> new TaxRate(0.0, "Zero");

    static TaxRateCalculator REDUCE_RATE
            = (item) -> {
        double rate = (item.getTotal() > 100.0) ? 0.135 : 0.09;
        return new TaxRate(rate, "Reduced");
    };


    private static Map<ProductCategory, TaxRateCalculator> CALCULATOR_PER_PRODUCT =
            new HashMap<>();

    static {
        CALCULATOR_PER_PRODUCT.put(Snacks, REDUCE_RATE);
        CALCULATOR_PER_PRODUCT.put(SoftDrinks, REDUCE_RATE);
        CALCULATOR_PER_PRODUCT.put(Books, ZERO_RATE);
        CALCULATOR_PER_PRODUCT.put(Medicine, ZERO_RATE);
    }

    public SalesTax salesTaxEntryFor(LineItem item) {

        TaxRate applicableTaxRate = taxRateFor(item);

        return SalesTax.atRateOf(applicableTaxRate.getRate()).
                withName(applicableTaxRate.getName())
                .forAnAmountOf(item.getTotal() * applicableTaxRate.getRate());
    }

    private TaxRate taxRateFor(LineItem item) {

        return CALCULATOR_PER_PRODUCT
                .getOrDefault(item.getCategory(), STANDARD_RATE)
                .apply(item);
    }
}