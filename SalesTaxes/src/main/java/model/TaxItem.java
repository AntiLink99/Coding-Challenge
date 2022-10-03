package model;

/**
 * @author jlued
 */
public class TaxItem {

    private String description;

    private int amount;

    private double price;

    private boolean hasSalesTax;

    private boolean isImported;

    private double salesTax = 0;

    private double importTax = 0;

    public TaxItem() {

    }

    public TaxItem(String name, int amount, double price, boolean hasSalesTax, boolean isImported) {
        this.description = name;
        this.amount = amount;
        this.price = price;
        this.hasSalesTax = hasSalesTax;
        this.isImported = isImported;
    }

    public String toString() {
        String total = price + " " + importTax + " " + salesTax;
        return amount + description + ": " + total;
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public double getPrice() {
        return price;
    }

    public boolean hasSalesTax() {
        return hasSalesTax;
    }

    public boolean isImported() {
        return isImported;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setHasSalesTax(boolean hasSalesTax) {
        this.hasSalesTax = hasSalesTax;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public double getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(double salesTax) {
        this.salesTax = salesTax;
    }

    public double getImportTax() {
        return importTax;
    }

    public void setImportTax(double importTax) {
        this.importTax = importTax;
    }
}
