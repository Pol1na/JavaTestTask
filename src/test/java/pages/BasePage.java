import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;

public class BasePage {
    WebDriver browser;
    String url;
    Integer timeout = 10;

    public void open() {
        browser.get(url);
    }

    public void find(String what) {
        try {
            browser.findElement(By.xpath(what));
        } catch (NoSuchElementException e) {
            throw new NoSuchElementException("No element with selector" + what);
        }
    }

    public boolean isElementPresented(String what) {
        try {
            browser.findElement(By.xpath(what));
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
