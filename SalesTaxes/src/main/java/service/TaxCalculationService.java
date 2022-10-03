package service;

import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * @author jlued
 */
public class TaxCalculationService {

    public void calculateTaxForInput(String inputFilePath) throws IOException {
        File inputFile = new File(inputFilePath);
        if (!inputFile.exists()) {
            throw new FileNotFoundException("The specified file does not exist!");
        }
        List<String> fileLines = FileUtils.readLines(inputFile, StandardCharsets.UTF_8);
        fileLines.forEach(System.out::println);
    }
}
