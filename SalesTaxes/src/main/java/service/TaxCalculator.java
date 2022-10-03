package service;

import model.TaxItem;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jlued
 */
public class TaxCalculator {
    private final double TAX_RATE_SALES = 0.10d;
    private final double TAX_RATE_IMPORTED = 0.05d;

    private BigDecimal total = new BigDecimal(0);
    private BigDecimal totalSalesTax = new BigDecimal(0);

    List<TaxItem> itemsToCalculate;

    public TaxCalculator(List<TaxItem> itemsToCalculate) {
        this.itemsToCalculate = itemsToCalculate;
    }

    public void calculateTax() {
        for (TaxItem item : itemsToCalculate) {
            if (item.hasSalesTax()) {
                double salesTax = item.getPrice().doubleValue() * TAX_RATE_SALES;
                item.setSalesTax(BigDecimal.valueOf(salesTax));
            }
            if (item.isImported()) {
                double importTax = item.getPrice().doubleValue() * TAX_RATE_IMPORTED;
                item.setImportTax(BigDecimal.valueOf(importTax));
            }
            BigDecimal totalTax = item.getSalesTax().add(item.getImportTax());
            total = total.add(totalTax.multiply(BigDecimal.valueOf(item.getAmount())));
            totalSalesTax = totalSalesTax.add(totalTax);
        }
    }

    public BigDecimal getTotalPlusTaxes() {
        return total.add(totalSalesTax);
    }

    public BigDecimal getTotalSalesTax() {
        return totalSalesTax;
    }
}
