package service;

import model.TaxItem;
import java.util.List;

/**
 * @author jlued
 */
public class PrinterService {

    private final List<TaxItem> items;

    private final double salesTax;

    private final double total;

    public PrinterService(List<TaxItem> items, double salesTax, double total) {
        this.items = items;
        this.salesTax = salesTax;
        this.total = total;
    }

    public void print() {
        System.out.println("OUTPUT:");
        for (TaxItem item : items) {
            System.out.println(item.toString());
        }
        System.out.println("Sales Taxes: " + salesTax);
        System.out.println("Total: " + total);
    }
}
