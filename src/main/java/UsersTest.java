import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class UsersTest {
public static WebDriver driver;

@Test

    public void login () throws InterruptedException {
System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
driver=new ChromeDriver();
driver.manage().window().maximize();
driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    driver.get("http://users.bugred.ru/user/login/index.html");
    driver.findElement(By.name("login")).sendKeys("oksanakirichenko@gmail.com");
    driver.findElement(By.name("password")).sendKeys("123");
    driver.findElement(By.xpath("/html/body/div[3]/div[1]/div[1]/form/table/tbody/tr[3]/td[2]/input")).click();
    WebElement OKS = driver.findElement(By.xpath("//a[contains(text(),'Добавить пользователя')]"));
    Assert.assertEquals(true, OKS.isDisplayed());
    //User search
    driver.findElement(By.name("q")).sendKeys("oksanakirichenko@gmail.com");
    driver.findElement(By.xpath("//*[contains(text(),'Найти')]")).click();
    // User logout
    driver.findElement(By.xpath("//*[@id=\"fat-menu\"]/a")).click();
    driver.findElement(By.xpath("//*[@id=\"fat-menu\"]/ul/li[3]/a")).click();
    // User registration
    driver.findElement(By.xpath("//*[contains(text(),'Войти')]")).click();
    driver.findElement(By.name("name")).sendKeys("Oksana2023");
    driver.findElement(By.name("email")).sendKeys("Oksana2023@gmail.com");
    driver.findElement(By.cssSelector("body > div.content > div.row > div:nth-child(2) > form > table > tbody > tr:nth-child(3) > td:nth-child(2) > input[type=password]")).sendKeys("1234");
    driver.findElement(By.name("act_register_now")).click();
    //Users cabinet
    driver.findElement(By.xpath("//*[@id=\"fat-menu\"]/a")).click();
    driver.findElement(By.xpath("//*[@id=\"fat-menu\"]/ul/li[1]/a")).click();
    //Edit user info
    driver.findElement(By.name("name")).sendKeys("Oksana2024");
    driver.findElement(By.name("gender")).click();
    driver.findElement(By.xpath("//*[contains(text(),'Женский')]")).click();
    driver.findElement(By.name("hobby")).sendKeys("Sleep");
    driver.findElement(By.name("inn")).sendKeys("1234567891");
    driver.findElement(By.name("act_profile_now")).click();

    driver.close();
    }
}
