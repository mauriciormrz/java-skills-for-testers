package serenitylabs.tutorials.vetclinic.sales.model;

import java.util.Objects;

public class LineItem {
    private final double unitCost;
    private final int quantity;
    private final String description;
    private final ProductCategory category;

    public LineItem(double unitCost, int quantity, String description, ProductCategory category) {
        this.unitCost = unitCost;
        this.quantity = quantity;
        this.description = description;
        this.category = category;
    }

    public static ItemCalled forASaleOf(int quantity) {

        return new LineItemBuilder(quantity);
    }

    public double getUnitCost() {

        return unitCost;
    }

    public int getQuantity() {

        return quantity;
    }

    public String getDescription() {

        return description;
    }

    public ProductCategory getCategory() {

        return category;
    }

    public double getTotal() {

        return quantity * unitCost;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        LineItem lineItem = (LineItem) o;
        return Double.compare(lineItem.unitCost, unitCost) == 0 &&
                quantity == lineItem.quantity &&
                Objects.equals(description, lineItem.description) &&
                category == lineItem.category;
    }

    @Override
    public int hashCode() {

        return Objects.hash(unitCost, quantity, description, category);
    }

    @Override
    public String toString() {
        return "LineItem{" +
                "unitCost=" + unitCost +
                ", quantity=" + quantity +
                ", description='" + description + '\'' +
                ", category=" + category +
                '}';
    }

    public interface ItemCalled {
        InCategory itemCalled(String itemName);
    }

    public interface InCategory {
        LineItemBuilder inCategory(ProductCategory category);
    }

    public static class LineItemBuilder implements ItemCalled, InCategory {
        private int quantity;
        private String itemName;
        private ProductCategory category;

        public LineItemBuilder(int quantity) {

            this.quantity = quantity;
        }

        public InCategory itemCalled(String itemName) {
            this.itemName = itemName;
            return this;
        }

        public LineItemBuilder inCategory(ProductCategory category) {
            this.category = category;
            return this;
        }

        public LineItem withAUnitPriceOf(double price) {

            return new LineItem(price, quantity, itemName, category);
        }
    }
}
