package geekbrains.lesson3;
//glazyrin
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.support.ui.WebDriverWait;


public class SQLhomework {
    private static WebDriver driver;
    private static final String CRM_URL = "https://www.sql-ex.ru";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();

        //driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);

        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        driver.get(CRM_URL);

        login();

        Thread.sleep(5000);

        driver.findElement(By.xpath("/html/body/table[1]/tbody/tr/td[3]/a/img")).click();

        Thread.sleep(5000);

        driver.quit();

    }

    public static void login() {
        WebElement element = driver.findElement(By.name("login"));
        element.sendKeys("SQL-King");
        driver.findElement(By.name("psw")).sendKeys("rec!5jlb!qwlG");
        driver.findElement(By.name("subm1")).click();
    }
}
