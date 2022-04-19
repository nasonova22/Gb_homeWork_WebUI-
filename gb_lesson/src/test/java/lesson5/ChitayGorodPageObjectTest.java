package lesson5;

import io.github.bonigarcia.wdm.WebDriverManager;
import lesson6.MainPage;
import org.junit.jupiter.api.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ChitayGorodPageObjectTest {
    WebDriver driver;
    WebDriverWait webDriverWait;
    Actions action;

    @BeforeAll
    static void registerDriver() {
        WebDriverManager.chromedriver().setup();
    }
    @BeforeEach
    void initDriver() {
        driver = new ChromeDriver();
    }
    @Test
    void choiceBookAddInBookmark () throws InterruptedException {
        driver.get("https://www.chitai-gorod.ru/");
        new MainPage(driver)
                .selectBestsellerPage()
                .addBookInMarks()
                .login("nasonova123@gmail.com","Fregat123&")
                .clickButtonMark()
                .findInBookMarksElement();

        Assertions.assertEquals(driver.findElement(By.xpath("//div[@class='price']")).getText() ,"1079 ₽");
    }

    @AfterEach
    void tearDown() {
        driver.quit();
    }
}
