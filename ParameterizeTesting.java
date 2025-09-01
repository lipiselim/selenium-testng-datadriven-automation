package sign_up.megnum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterizeTesting {

    public WebDriver driver;

    @Parameters({"username", "password"})
    @Test
    public void adminLogin(String username, String password) {
        System.setProperty("webdriver.chrome.driver", "C:/Users/lipi2/OneDrive/Desktop/chromedriver.exe");
        driver = new ChromeDriver();

        driver.get("http://newtours.demoaut.com/index.php");
        driver.findElement(By.name("userName")).sendKeys(username);
        driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//html/body/div/table/tbody/tr/td[2]/table/tbody/tr")).click();

        String url = driver.getCurrentUrl();
        System.out.println("Name of the url: " + url);
        Assert.assertEquals("http://newtours.demoaut.com/index.php", url);
    }

    @AfterMethod
    public void closeBrowser() {
        driver.close();
    }
}
