import model.TaxItem;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import service.TaxCalculator;

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
        itemsToCalculate.add(new TaxItem("A", 1, 3.5d, true, true));
        itemsToCalculate.add(new TaxItem("B", 2, 1d, false, true));
        itemsToCalculate.add(new TaxItem("C", 1, 2d, false, false));

        taxCalculator = new TaxCalculator(itemsToCalculate);
    }

    @Test
    public void givenValidItems_whenCalculate_thenOK() {
        taxCalculator.calculateTax();
        double expectedTotal = 8.2d;
        double expectedSalesTax = 0.7d;
        Assert.assertEquals(expectedTotal, taxCalculator.getTotal(), 0);
        Assert.assertEquals(expectedSalesTax, taxCalculator.getSalesTax(), 0.0001);
    }
}
