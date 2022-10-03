package convert;

import model.TaxItem;

import java.math.BigDecimal;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author jlued
 */

public class TaxItemParser {

    private final Pattern IMPORTED_PATTERN = Pattern.compile("imported");
    private final Pattern ITEM_PATTERN = Pattern.compile("(\\d+)([a-zA-Z0-9_\\s]+?)( at )(\\d+.\\d+)");

    private final List<String> itemsWithoutSalesTax;

    public TaxItemParser(List<String> itemsWithoutSalesTax) {
        this.itemsWithoutSalesTax = itemsWithoutSalesTax;
    }

    public TaxItem convertItemStringToTaxItem(String itemStr) {
        Matcher matcher = ITEM_PATTERN.matcher(itemStr);

        TaxItem newItem = new TaxItem();
        if (matcher.find()) {
            String name = matcher.group(2);
            newItem.setDescription(name);

            int count = Integer.parseInt(matcher.group(1));
            newItem.setAmount(count);

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
        return itemsWithoutSalesTax.stream().noneMatch(itemStr::contains);
    }
}