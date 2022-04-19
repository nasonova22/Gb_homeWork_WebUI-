package lesson6;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//b[.='Книги']")
    private WebElement sectionBooks;
    @FindBy(xpath = "//div[@class='column']//a[@href='/catalog/bestsell/']")
    private WebElement sectionBestsell;

    public BestsellerPage selectBestsellerPage() {
        action.moveToElement(sectionBooks)
                .build()
                .perform();
        action.moveToElement(sectionBestsell)
                .click()
                .build()
                .perform();
        return new BestsellerPage(driver);
    }

    @FindBy(xpath = "//span[text()='Закладки:']")
    private WebElement bookMarksElement;

    public BookMarksPage clickButtonMark() {
        webDriverWait.until(ExpectedConditions.elementToBeClickable(bookMarksElement));
        bookMarksElement.click();
        return new BookMarksPage(driver);
    }

}
