package service;

import model.TaxItem;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author jlued
 */
public class PrinterService {

    private final List<TaxItem> items;

    private final BigDecimal salesTax;

    private final BigDecimal totalTax;


    public PrinterService(List<TaxItem> items, BigDecimal salesTax, BigDecimal totalTax) {
        this.items = items;
        this.salesTax = salesTax;
        this.totalTax = totalTax;
    }

    public void print() {

    }
}
