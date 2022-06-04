package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class BasePage {

    public WebDriver browser;

    public String url;
    public Duration timeout = Duration.ofSeconds(5);

    public BasePage(WebDriver browser, String url, Duration timeout) {
        this.url = url;
        this.browser = browser;
        this.timeout = timeout;
    }

    public void open() {
        browser.manage().window().maximize();
        browser.get(url);
    }

    public WebElement find(String what) {
        try {
            return browser.findElement(By.xpath(what));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("No element with selector " + what);
        }

    }

    public List<WebElement> finds(String what) {
        try {
            return browser.findElements(By.xpath(what));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("No element with selector" + what);
        }

    }



    public void checkStaleness(WebElement element) {
        new WebDriverWait(this.browser, this.timeout).until(ExpectedConditions.stalenessOf(element));

    }

    public void executeJsScript(String script){
        JavascriptExecutor js = (JavascriptExecutor) this.browser;
        js.executeScript(script);
    }
    public void switchToWindow(Integer index){
        ArrayList<String> tabs = new ArrayList<String>(this.browser.getWindowHandles());
        this.browser.switchTo().window(tabs.get(index));

    }

}
