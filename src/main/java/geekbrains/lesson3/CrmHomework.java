package geekbrains.lesson3;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;


public class CrmHomework {
    private static WebDriver driver;
    private static final String CRM_URL = "https://crm.geekbrains.space";

    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();


        WebDriverWait webDriverWait = new WebDriverWait(driver, 10);

        driver.get(CRM_URL);

        login();

        //Thread.sleep(5000);
        List<WebElement> navMenuElements = driver.findElements(By.xpath("//div[@id='main-menu']/ul/li/a"));
        WebElement expenceElement = navMenuElements.stream().filter(e -> e.getText().equals("Проекты")).findFirst().get();

        Actions actions = new Actions(driver);
        actions.moveToElement(expenceElement).build().perform();
        driver.findElement(By.xpath("//span[.='Все проекты']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[.='Создать проект']")));
        webDriverWait.until(ExpectedConditions.visibilityOf(driver.findElement(By.xpath("//a[.='Создать проект']"))));
        driver.findElement(By.xpath("//a[.='Создать проект']")).click();

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[contains(@id, 'crm_project_name-uid')]")));
        driver.findElement(By.xpath("//input[contains(@id, 'crm_project_name-uid')]")).sendKeys("test project");

        webDriverWait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("textarea")));
        driver.findElement(By.cssSelector("textarea")).sendKeys("test");


        Select organisationSelect = new Select(
                driver.findElement(By.xpath("//span[@class='select2-chosen']")));
        organisationSelect.selectByVisibleText("«Все организации»");

        Select prioritySelect = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[priority]']")));
        prioritySelect.selectByVisibleText("Средний");

        Select financeSourceSelect = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[financeSource]']")));
        financeSourceSelect.selectByVisibleText("Из средств заказчика");

        Select businessUnitSelect = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[businessUnit]']")));
        businessUnitSelect.selectByVisibleText("Из средств заказчика");

        Select curatorSelect = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[curator]']")));
        curatorSelect.selectByVisibleText("Гумённый Пётр");

        Select RPSelect = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[rp]']")));
        RPSelect.selectByVisibleText("Авласёнок Денис");

        Select managerSelect = new Select(
                driver.findElement(By.xpath("//select[@name='crm_project[manager]']")));
        managerSelect.selectByVisibleText("Амелин Владимир");


        driver.findElement(By.xpath("//button[contains(., 'Сохранить и закрыть')]")).click();

        Thread.sleep(5000);

        driver.quit();

    }

    public static void login() {
        WebElement element = driver.findElement(By.id("prependedInput"));
        element.sendKeys("Applanatest1");
        driver.findElement(By.id("prependedInput2")).sendKeys("Student2020!");
        driver.findElement(By.id("_submit")).click();
    }
}
