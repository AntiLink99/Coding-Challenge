package model;

import java.math.BigDecimal;

/**
 * @author jlued
 */
public class TaxItem {

    private String description;

    private int count;

    private BigDecimal price;

    private boolean hasSalesTax;

    private boolean isImported;

    public TaxItem() {

    }

    public TaxItem(String name, int count, BigDecimal price, boolean hasSalesTax, boolean isImported) {
        this.description = name;
        this.count = count;
        this.price = price;
        this.hasSalesTax = hasSalesTax;
        this.isImported = isImported;
    }

    public String getDescription() {
        return description;
    }

    public int getCount() {
        return count;
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

    public void setCount(int count) {
        this.count = count;
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
}
