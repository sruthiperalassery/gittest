package StockTestCases;

import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.UBQGenericLib.BaseClassLoader;

/**
 * @author Basanagouda
 *
 */
@Listeners(com.UBQGenericLib.SampleListner.class)
public class Tc_Stock_012_OpeningStockForDescriteProductTestCase extends BaseClassLoader {
	@Test
	public void openingStockForNonDescriteProduct() throws Exception {
	}
}
