package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class BasePage {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions action;


    public BasePage(WebDriver driver) {
        this.driver = driver;
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(10));
        action = new Actions(driver);
        PageFactory.initElements(driver, this);
    }
}
