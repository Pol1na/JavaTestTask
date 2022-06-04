import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pages.MarketPage;

import java.sql.Array;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TestMarketPage {
    public ChromeDriver browser;

    @BeforeTest
    public void onStartUp() {
        //System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"/src/test/chromedriver/chromedriver.exe");
        browser = new ChromeDriver();
        System.out.println("Test started");
    }

    @AfterTest
    public void onTearDown() {
        browser.quit();
        System.out.println("Browser is closed");
    }
    @Test
    public void testProduct() {
        MarketPage page = new MarketPage(browser, "https://yandex.ru/", Duration.ofSeconds(5));
        page.open();
        page.openMarket();
        page.waitForLoad();
        page.goToElectronic();
        page.goToSmartphones();
        page.enterPrice("20000");
        page.enterDiagonal("3");
        List<String> manufacturer = Arrays.asList("Apple", "Xiaomi", "HONOR", "HUAWEI", "OPPO");
        page.enterManufacturer(manufacturer);
        String product = page.productsMustBeTen();
        page.filterProducts();
        page.findMyProduct(product);
        page.getRating();

    }
}
