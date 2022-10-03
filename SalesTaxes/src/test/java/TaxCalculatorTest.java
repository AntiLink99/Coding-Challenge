import convert.TaxItemParser;
import model.TaxItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.TaxCalculator;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author jlued
 */
public class TaxCalculatorTest {

    private TaxCalculator taxCalculator;

    @Before
    public void init() {
        List<TaxItem> itemsToCalculate = new ArrayList<>();
        itemsToCalculate.add(new TaxItem("A", 1, BigDecimal.valueOf(3.5), true, true));
        itemsToCalculate.add(new TaxItem("B", 2, BigDecimal.valueOf(1), false, true));
        itemsToCalculate.add(new TaxItem("C", 1, BigDecimal.valueOf(2), false, false));

        taxCalculator = new TaxCalculator(itemsToCalculate);
    }

    @Test
    public void givenValidItems_whenCalculate_thenOK() {
        taxCalculator.calculateTax();
        BigDecimal expected = BigDecimal.valueOf(0.63d);
        Assert.assertEquals(expected, taxCalculator.getTotalSalesTax());
    }
}
