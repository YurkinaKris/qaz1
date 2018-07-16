import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class FirstTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setup() {
        System.setProperty("webdriver.chrome.driver", ".\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get("https://ya.ru");
    }
    @Test
    public void search() {
        WebElement SearchInput = driver.findElement(By.id("text"));
        SearchInput.sendKeys("погода пенза");
        WebElement SearchButton = driver.findElement(By.cssSelector("[type='submit']"));
        SearchButton.click();
        WebElement FirstResultSearch = driver.findElement(By.cssSelector("[accesskey= '1']"));
        String Result = FirstResultSearch.getText();
        Assert.assertTrue(Result.contains("Погода"));
        Assert.assertTrue(Result.contains("Пенз"));
    }
    @AfterClass
    public static void tearDown() {
    }
}