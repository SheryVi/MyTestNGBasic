package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginExample {
public static WebDriver driver;

    //to login into Syntax HRMS application with following credentials
    //userName: Admin
    //password: 12345

    @Test (priority = 2)
    public  void ainvalidCredentials1(){
        driver.findElement(By.id("txtUsername")).sendKeys("Admin");
        driver.findElement(By.id("txtPassword")).sendKeys("12345");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();
        System.out.println("atest "+text);

    }

    //to login into Syntax HRMS application with following credentials
    //userName: NoAdmin
    //password: 123456

    @Test (priority = 1)
    public  void binvalidCredentials2(){
        driver.findElement(By.id("txtUsername")).sendKeys("NoAdmin");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();
        System.out.println("btest "+text);

    }

    // precondition --> open the browser and navigate to the URL
    @BeforeMethod
    public void openBrowser(){

        WebDriverManager.chromedriver().setup(); //установили потому что используем прямо сейчас, а не фактический вэб-драййвер
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @AfterMethod
    public void closeBrowser(){

        driver.quit();

    }

}
