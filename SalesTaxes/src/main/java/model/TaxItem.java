package model;

import java.math.BigDecimal;

public class TaxItem {

    private final String name;

    private final int count;

    private final BigDecimal price;

    private final boolean hasSalesTax;

    private final boolean isImported;

    public TaxItem(String name, int count, BigDecimal price, boolean hasSalesTax, boolean isImported) {
        this.name = name;
        this.count = count;
        this.price = price;
        this.hasSalesTax = hasSalesTax;
        this.isImported = isImported;
    }

    public String getName() {
        return name;
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public boolean isHasSalesTax() {
        return hasSalesTax;
    }

    public boolean isImported() {
        return isImported;
    }
}
