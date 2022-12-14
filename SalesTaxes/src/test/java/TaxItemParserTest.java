import convert.TaxItemParser;
import model.TaxItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

/**
 * @author jlued
 */
public class TaxItemParserTest {

    private TaxItemParser parser;

    @Before
    public void init() {
        List<String> itemsWithoutSalesTax = List.of("book", "chocolate", "pill");
        parser = new TaxItemParser(itemsWithoutSalesTax);
    }

    @Test
    public void givenValidString_whenConvertToTaxItem_thenOK() {
        String testStr = "1 imported bottle of perfume at 27.99";
        TaxItem item = parser.convertItemStringToTaxItem(testStr);

        Assert.assertEquals(" imported bottle of perfume", item.getDescription());
        Assert.assertEquals(1, item.getAmount());
        Assert.assertEquals(27.99, item.getPrice(), 0);
        Assert.assertTrue(item.isImported());
        Assert.assertTrue(item.hasSalesTax());
    }

    @Test
    public void givenValidString_whenConvertToTaxItem_thenOK2() {
        String testStr = "9 music CD at 14.99";
        TaxItem item = parser.convertItemStringToTaxItem(testStr);

        Assert.assertEquals(" music CD", item.getDescription());
        Assert.assertEquals(9, item.getAmount());
        Assert.assertEquals(14.99, item.getPrice(), 0);
        Assert.assertFalse(item.isImported());
        Assert.assertTrue(item.hasSalesTax());
    }

    @Test
    public void givenValidString_whenConvertToTaxItem_thenOK3() {
        String testStr = "3 boxes of imported chocolates at 11.25";
        TaxItem item = parser.convertItemStringToTaxItem(testStr);

        Assert.assertEquals(" boxes of imported chocolates", item.getDescription());
        Assert.assertEquals(3, item.getAmount());
        Assert.assertEquals(11.25d, item.getPrice(), 0);
        Assert.assertTrue(item.isImported());
        Assert.assertFalse(item.hasSalesTax());
    }
}
