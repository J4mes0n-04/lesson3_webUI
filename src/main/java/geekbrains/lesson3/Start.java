package geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Start {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://google.com");
        Thread.sleep(5000);
        driver.quit();

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver1 = new FirefoxDriver();
        driver1.get("http://ya.ru");
        Thread.sleep(5000);
        driver1.quit();
    }
}
