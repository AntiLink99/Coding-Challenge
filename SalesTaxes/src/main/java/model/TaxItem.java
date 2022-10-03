package model;

import java.math.BigDecimal;

/**
 * @author jlued
 */
public class TaxItem {

    private String description;

    private int amount;

    private BigDecimal price;

    private boolean hasSalesTax;

    private boolean isImported;

    private BigDecimal salesTax;

    private BigDecimal importTax;

    public TaxItem() {

    }

    public TaxItem(String name, int amount, BigDecimal price, boolean hasSalesTax, boolean isImported) {
        this.description = name;
        this.amount = amount;
        this.price = price;
        this.hasSalesTax = hasSalesTax;
        this.isImported = isImported;

        this.salesTax = new BigDecimal(0);
        this.importTax = new BigDecimal(0);
    }

    public String getDescription() {
        return description;
    }

    public int getAmount() {
        return amount;
    }

    public BigDecimal getPrice() {
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

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setHasSalesTax(boolean hasSalesTax) {
        this.hasSalesTax = hasSalesTax;
    }

    public void setImported(boolean imported) {
        isImported = imported;
    }

    public BigDecimal getSalesTax() {
        return salesTax;
    }

    public void setSalesTax(BigDecimal salesTax) {
        this.salesTax = salesTax;
    }

    public BigDecimal getImportTax() {
        return importTax;
    }

    public void setImportTax(BigDecimal importTax) {
        this.importTax = importTax;
    }
}
