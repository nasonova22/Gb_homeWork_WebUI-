package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "popup-email")
    public WebElement emailField;

    @FindBy(id = "popup-password")
    public WebElement passwordField;

    @FindBy(id = "authSubmit")
    public WebElement submitButton;

    private static final String popAppXpathLocator = "//div[@data-chg-name='Авторизация на сайте']//div[@class='popup__body']";
    @FindBy(xpath = popAppXpathLocator)
    WebElement popApp;

    public MainPage login(String email, String password) {
        webDriverWait.until(ExpectedConditions.visibilityOf(popApp));
        emailField.sendKeys(email);
        passwordField.sendKeys(password);
        submitButton.click();
        return new MainPage(driver);
    }
}
