package service;

import model.TaxItem;
import utils.NumberUtils;

import java.util.List;

/**
 * @author jlued
 */
public class TaxCalculator {
    private final double TAX_RATE_SALES = 0.10d;
    private final double TAX_RATE_IMPORTED = 0.05d;

    private double total = 0;
    private double totalTax = 0;

    List<TaxItem> itemsToCalculate;

    public TaxCalculator(List<TaxItem> itemsToCalculate) {
        this.itemsToCalculate = itemsToCalculate;
    }

    public TaxCalculator calculateTax() {
        for (TaxItem item : itemsToCalculate) {
            if (item.hasSalesTax()) {
                double salesTax = NumberUtils.roundDouble(item.getPrice() * TAX_RATE_SALES);
                item.setSalesTax(salesTax);
            }
            if (item.isImported()) {
                double importTax = NumberUtils.roundDouble(item.getPrice() * TAX_RATE_IMPORTED);
                item.setImportTax(importTax);
            }
            double singleItemTotalTax = item.getSalesTax() + item.getImportTax();
            double itemsTax = singleItemTotalTax * item.getAmount();

            totalTax += itemsTax;
            total += item.getPrice() * item.getAmount() + itemsTax;
        }
        return this;
    }

    public double getTotal() {
        return total;
    }

    public double getSalesTax() {
        return totalTax;
    }
}
