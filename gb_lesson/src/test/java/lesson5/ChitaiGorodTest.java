package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.List;

public class ChitaiGorodTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions actions;
    private final String URL_NAME = "https://www.chitai-gorod.ru/";

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }


    @BeforeEach
    void setupdriver() {
        driver = new ChromeDriver();
        webDriverWait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        driver.get(URL_NAME);
    }
    @Test
    void visibiliteCategoriesBestsel() {
        //проверка наличия пдборки "Лучшие из лучших"
        driver.findElement(By.xpath("//span[.='Войти']")).click();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("nasonova123@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Fregat123&");
        driver.findElement(By.id("authSubmit")).click();
        Assertions.assertEquals(driver.findElement(By.xpath("//img[@alt='Лучшие из лучших']")).isDisplayed(),true);

    }

    @Test
    void addBookInBookmark() {

        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//b[.='Книги']")));
        actions.moveToElement(driver.findElement(By.xpath("//b[.='Книги']")))
                .build()
                .perform();
        actions.moveToElement(driver.findElement(By.xpath("//div[@class='column']//a[@href='/catalog/bestsell/']")))
                .click()
                .build()
                .perform();

        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//a[@title='Щегол']//following-sibling::div[@class='land-view__wrapper']//descendant::i")));
        driver.findElement(By.xpath("//a[@title='Щегол']//following-sibling::div[@class='land-view__wrapper']//descendant::i")).click();

        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@data-chg-name='Авторизация на сайте']//div[@class='popup__body']")));
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("nasonova123@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Fregat123&");
        driver.findElement(By.id("authSubmit")).click();

        webDriverWait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[text()='Закладки:']")));
        driver.findElement(By.xpath("//span[text()='Закладки:']")).click();
        List<WebElement> books = driver.findElements(By.xpath("//a[@class='product-card__img js-analytic-productlink']//img"));
        books.stream().filter(p->p.getAttribute("alt").contains("Щегол")).findFirst().get().click();
        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='price']")).getText() ,"895 ₽");
    }


    @AfterEach
    void tearDown() {
        driver.quit();
    }


}

