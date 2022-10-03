import service.TaxCalculationService;

import java.io.IOException;

/**
 * @author jlued
 */
public class Main {

    private static final TaxCalculationService taxCalculationService = new TaxCalculationService();

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("The first argument needs to be the file path to your input file.");
            return;
        }
        String inputFilePath = args[0];
        try {
            taxCalculationService.init();
            taxCalculationService.calculateTaxForInput(inputFilePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
