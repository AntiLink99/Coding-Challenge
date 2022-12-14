package service;

import convert.TaxItemParser;
import model.TaxItem;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author jlued
 */
public class TaxCalculationService {

    TaxItemParser parser;

    private File itemsWithoutSalesTaxFile;

    public void init() throws FileNotFoundException {
        String salesWithoutTaxesFilePath = System.getenv("NO_SALES_TAX_FILE_PATH");
        if (salesWithoutTaxesFilePath == null) {
            throw new AssertionError("Environment variable 'NO_SALES_TAX_FILE_PATH' is missing!");
        }
        itemsWithoutSalesTaxFile = new File(salesWithoutTaxesFilePath);
        if (!itemsWithoutSalesTaxFile.exists()) {
            throw new FileNotFoundException("Exclusion file does not exist!");
        }
        List<String> itemsWithoutTax = readItemsWithoutSalesTax();
        parser = new TaxItemParser(itemsWithoutTax);
    }

    public void calculateTaxForInput(String inputFilePath) throws IOException {
        File inputFile = new File(inputFilePath);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("The specified file does not exist!");
        }
        List<String> fileLines = FileUtils.readLines(inputFile, StandardCharsets.UTF_8);
        List<TaxItem> taxItems = fileLines.stream()
                .map(line -> parser.convertItemStringToTaxItem(line))
                .collect(Collectors.toList());

        TaxCalculator calculator = calculate(taxItems);
        printOutputWithData(taxItems, calculator.getSalesTax(), calculator.getTotal());
    }

    private TaxCalculator calculate(List<TaxItem> items) {
        return new TaxCalculator(items).calculateTax();
    }

    private void printOutputWithData(List<TaxItem> items, double salesTax, double total){
        PrinterService printer = new PrinterService(items, salesTax, total);
        printer.print();
    }

    private List<String> readItemsWithoutSalesTax() {
        try {
            return FileUtils.readLines(itemsWithoutSalesTaxFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }
}
