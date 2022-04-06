package lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

public class SeleniumStart {
    public static void main(String[] args) throws InterruptedException {
        //System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriverManager.chromedriver().setup();

        ChromeOptions chromOptions = new ChromeOptions();
        WebDriver driver = new ChromeDriver(chromOptions);
        WebDriverWait webDriverWait =new WebDriverWait(driver, Duration.ofSeconds(5));
        driver.get("https://www.chitai-gorod.ru/");


        driver.findElement(By.xpath("//span[.='Войти']")).click();
        driver.findElement(By.xpath("//input[@name='login']")).sendKeys("nasonova123@gmail.com");
        driver.findElement(By.xpath("//input[@type='password']")).sendKeys("Fregat123&");
        driver.findElement(By.id("authSubmit")).click();

       // webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//img [@class='popup-action__img']//ancestor::div[@class='popup__wrapper']//i")));
       // driver.findElement(By.xpath("//img [@class='popup-action__img']//ancestor::div[@class='popup__wrapper']//i")).click();

        Thread.sleep(3000);
        driver.findElement(By.xpath("//img[@alt='Лучшие из лучших']")).click();
        //получить список книг "Лучшие из лучших", найти книгу "Заводной апельсин", выбрать ее и поместить "В закладки "
        List<WebElement> books =driver.findElements(By.xpath("//div[@class='product-card js_product js__product_card js__slider_item']"));
        books.stream().filter(p->p.getText().contains("Заводной апельсин")).findFirst().get().click();
        webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//img[@alt='Заводной апельсин'and @class=' lazyloaded']")));
        //webDriverWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.xpath("//div[@id='push-notification-balloon']")));
        //driver.findElement(By.xpath("//div[@id='push-notification-balloon']//button[contains(text(),'Нет, спасибо')]"));
        driver.findElement(By.xpath("//div[@data-chg-book-name='Заводной апельсин']//span[@data-book-id='2397960']")).click();
        //перейти в раздел "Книги", кликнуть, в открывшемся списке выбрать раздел "Лучшие из лучших", найти книгу "Щегол"
        //поместить "В закладки"
        driver.findElement(By.xpath("//b[.='Книги']")).click();
        driver.findElement(By.xpath("//li [@class='navigation__item']//a[.='Лучшие из лучших']")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@title='Щегол']//following-sibling::div[@class='land-view__wrapper']//descendant::i")).click();

        //открыть "Закладки", найти книгу "Щегол"
        driver.findElement(By.xpath("//div[@class='pin scrollToTop']")).click();
        driver.findElement(By.xpath("//span[text()='Закладки:']")).click();
        books = driver.findElements(By.xpath("//a[@class='product-card__img js-analytic-productlink']"));
        books.stream().filter(p->p.getText().contains("Щегол")).findFirst().get().click();

        Thread.sleep(3000);
        driver.quit();
    }

}
