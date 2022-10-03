package model;

import java.math.BigDecimal;

/**
 * @author jlued
 */
public class TaxItem {

    private String name;

    private int count;

    private BigDecimal price;

    private boolean hasSalesTax;

    private boolean isImported;

    public String getName() {
        return name;
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

    public void setName(String name) {
        this.name = name;
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
