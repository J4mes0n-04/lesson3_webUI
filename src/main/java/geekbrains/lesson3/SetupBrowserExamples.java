package geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.util.ArrayList;
import java.util.List;


public class SetupBrowserExamples {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox")
               .addArguments("--disable-notifications")
               .addArguments("user-agent=Googlebot/2.1 (+http://www.google.com/bot.html)");
        WebDriver driver = new ChromeDriver(options);
        driver.get("http://google.com");
        //driver.manage().window().setSize(new Dimension(300,300));

        ((JavascriptExecutor) driver).executeScript("window.open()");

        List<String> tabs = new ArrayList<>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(0));

        Thread.sleep(5000);
        driver.quit();


    }
}
