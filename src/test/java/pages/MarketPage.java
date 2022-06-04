package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MarketPage extends BasePage {
    public MarketPage(WebDriver browser, String url, Duration timeout) {
        super(browser, url, timeout);
    }

    public void openMarket() {
        WebElement marketBtn = this.find(Locators.SearchPageLocators.BTN_MARKET);
        marketBtn.click();
        this.switchToWindow(1);
    }

    public void goToElectronic() {
        WebElement electronicBtn = this.find(Locators.MarketPageLocators.BTN_ELECTRONIC);
        electronicBtn.click();
    }

    public void goToSmartphones() {
        WebElement smartphonesBtn = this.find(Locators.MarketPageLocators.BTN_SMARTPHONES);
        smartphonesBtn.click();
    }

    public void enterPrice(String price) {
        WebElement priceInput = this.find(Locators.MarketPageLocators.INPUT_TO_PRICE);
        priceInput.sendKeys(price);
    }

    public void enterDiagonal(String diagonal) {
        WebElement diagonalInput = this.find(Locators.MarketPageLocators.INPUT_FROM_DIAGONAL);
        diagonalInput.sendKeys(diagonal);
    }

    public void enterManufacturer(List<String> manufactures) {
        WebElement mansBtn = this.find(Locators.MarketPageLocators.BTN_ALL_MANUFACTURES);
        mansBtn.click();
        for (String element : manufactures) {
            WebElement man = this.find(String.format("//div[@data-filter-id=\"7893318\"]//span[text()=\"%s\"]", element));
            man.click();
        }
        this.checkStaleness(this.find(Locators.MarketPageLocators.CARD_PRODUCT));

    }

    public void waitForLoad() {
        this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
    }

    public String productsMustBeTen() {
        waitForLoad();
        this.executeJsScript("window.scrollTo(0, document.body.scrollHeight)");
        List<WebElement> products = this.finds(Locators.MarketPageLocators.CARD_PRODUCT);
        int count = products.size();
        assert count == 10 : String.format("Number of products per page %s. Expected 10.", count);
        return products.get(0).getText();
    }

    public void filterProducts() {
        WebElement btnFilter = this.find(Locators.MarketPageLocators.BTN_FILTER_PRICE);
        btnFilter.click();
    }
    // кошмар #2
    public void findMyProduct(String product) {
        this.checkStaleness(this.find(Locators.MarketPageLocators.CARD_PRODUCT));
        this.executeJsScript("window.scrollTo(0, document.body.scrollHeight)");
        List<WebElement> products = this.finds(Locators.MarketPageLocators.CARD_PRODUCT);
        try {
            for (WebElement item : products) {
                //String itm_text = item.getAttribute("data-zone-data");
                String itm_text = item.getText();
                if (Objects.equals(itm_text, product)) {
                    item.click();
                    return;
                } else if (products.indexOf(item) == products.size() - 1 && !Objects.equals(item.getAttribute("data-zone-data"), product)) {
                    WebElement btnNext = this.find(Locators.MarketPageLocators.BTN_NEXT_PAGE);
                    btnNext.click();
                    this.browser.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
                    findMyProduct(product);
                }

            }
        } catch (Exception e) {
            throw new NoSuchElementException("No need element");
        }
    }


    public void getRating() {
        this.switchToWindow(2);
        WebElement elementRating = this.find(Locators.MarketPageLocators.TEXT_RATING);
        String textRating = elementRating.getText();
        System.out.println(textRating);
    }

}
