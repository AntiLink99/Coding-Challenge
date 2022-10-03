import service.TaxCalculationService;

import java.io.IOException;

/**
 * @author jlued
 */
public class Main {

    private static final TaxCalculationService taxCalculationService = new TaxCalculationService();

    public static void main(String[] args) {
        if (args.length == 0) {
            System.out.println("Please enter the file path of the input you want to calculate.");
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
