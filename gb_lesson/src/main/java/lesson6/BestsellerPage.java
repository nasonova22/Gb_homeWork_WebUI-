package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;


public class BestsellerPage extends BasePage {

    public BestsellerPage(WebDriver driver) {
        super(driver);
    }

    private static final String findBookChoiсeXpathLocator = "//a[@title='Щегол']//following-sibling::div[@class='land-view__wrapper']//descendant::i";
    @FindBy(xpath = findBookChoiсeXpathLocator)
    private WebElement findBookChoiсe;

    public LoginPage addBookInMarks() {
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath(findBookChoiсeXpathLocator)));
        findBookChoiсe.click();
        return new LoginPage(driver);
    }

}
