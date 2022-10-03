package convert;

import model.TaxItem;
import org.apache.commons.io.FileUtils;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jlued
 */

public class TaxItemParser {

    private final Pattern IMPORTED_PATTERN = Pattern.compile("imported");
    private final Pattern ITEM_PATTERN = Pattern.compile("(\\d+)([a-zA-Z0-9_\\s]+?)( at )(\\d+.\\d+)");

    private final String ITEMS_WITHOUT_SALES_TAX_PATH = "SalesTaxes/data/itemsWithoutSalesTax.txt";
    private final File itemsWithoutSalesTaxFile = new File(ITEMS_WITHOUT_SALES_TAX_PATH);;

    private List<String> readItemsWithoutSalesTax() {
        System.out.println(itemsWithoutSalesTaxFile.getAbsolutePath());
        try {
            return FileUtils.readLines(itemsWithoutSalesTaxFile, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return Collections.emptyList();
    }

    public TaxItem convertItemStringToTaxItem(String itemStr) {
        Matcher matcher = ITEM_PATTERN.matcher(itemStr);

        TaxItem newItem = new TaxItem();
        if (matcher.find()) {
            String name = matcher.group(2);
            newItem.setName(name);
            int count = Integer.parseInt(matcher.group(1));
            newItem.setCount(count);
            BigDecimal price = new BigDecimal(matcher.group(4));
            newItem.setPrice(price);
        }
        newItem.setImported(isTaxItemImported(itemStr));
        newItem.setHasSalesTax(taxItemHasSalesTax(itemStr));
        return newItem;
    }

    private boolean isTaxItemImported(String itemStr) {
        Matcher matcher = IMPORTED_PATTERN.matcher(itemStr);
        return matcher.find();
    }

    private boolean taxItemHasSalesTax(String itemStr) {
        List<String> itemsWithoutSalesTax = readItemsWithoutSalesTax();
        return itemsWithoutSalesTax.stream().noneMatch(itemStr::contains);
    }
}