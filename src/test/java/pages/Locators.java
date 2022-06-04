package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Locators {
    public static class SearchPageLocators {
        public static String BTN_MARKET = "//a[@data-id=\"market\"]";
    }

    public static class MarketPageLocators {
        public static String BTN_ELECTRONIC = "//a[contains(@href,'elektronika')]";
        public static String BTN_SMARTPHONES = "//a[text() = 'Смартфоны']";

        // какой кошмар
        public static String INPUT_TO_PRICE = "//div[@data-auto=\"filter-range-glprice\"]//span[@data-auto=\"filter-range-max\"]//input";
        public static String INPUT_FROM_DIAGONAL = "//div[contains(@data-zone-data,\"Диагональ экрана\")]//span[@data-auto=\"filter-range-min\"]//input";
        public static String BTN_ALL_MANUFACTURES = "//div[contains(@data-zone-data,\"Производитель\")]//span[@data-tid=\"8b5facc5\"]";
        //public static String CHECKBOX_XIAOMI = "//div[@data-filter-id=\"7893318\"]//span[text()=\"Xiaomi\"]";
        //public static String CARD_PRODUCT = "//article";
        public static String CARD_PRODUCT = "//article//a[@data-node-name=\"title\"]//span";
        public static String BTN_FILTER_PRICE = "//div[@data-grabber=\"SearchControls\"]//button[@data-autotest-id=\"dprice\"]";
        public static String BTN_NEXT_PAGE = "//div[@data-auto=\"pagination-next\"]";

        public static String TEXT_RATING = "//div[@class=\"f5NET\"]//div[@data-tid=\"82088f3b\"]//span";

    }
}

