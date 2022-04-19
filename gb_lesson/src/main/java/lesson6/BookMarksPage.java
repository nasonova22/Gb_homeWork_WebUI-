package lesson6;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.util.List;

public class BookMarksPage extends BasePage {
    public BookMarksPage(WebDriver driver) {
        super(driver);
    }


    @FindBy(xpath = "//a[@class='product-card__img js-analytic-productlink']//img")
    private List<WebElement> booksChoiseList;

    public MainPage findInBookMarksElement() {
        booksChoiseList.stream().filter(p -> p.getAttribute("alt").contains("Щегол")).findFirst().get().click();
        return new MainPage(driver);
    }

}
