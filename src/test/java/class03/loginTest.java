package class03;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class loginTest {
    WebDriver driver;  //declaration

    @BeforeMethod(alwaysRun = true)
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup(); //установили потому что используем прямо сейчас, а не фактический вэб-драййвер
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");
    }

    @Test(groups = "regression")
    public void VerifyCredentials() {

        SoftAssert soft = new SoftAssert();

        String expectedText = "Invalid credentials";
        WebElement UserName = driver.findElement(By.id("txtUsername"));
        boolean displayed = UserName.isDisplayed();
        UserName.sendKeys("123456");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();
        //assertion to make sure that message is correct
        soft.assertEquals(text, expectedText);

        // WebElement userName = driver.findElement(By.id("txtUsername")); //при обновлении вэб страницы введенные
        //данные удаляются поэтому дублируем ввод
        //validate the display is true or not
        System.out.println("helloWorld");
        // displayed=false;
        soft.assertTrue(displayed);

        //check all assertions
        soft.assertAll();
    }

    @Test(groups = "regression")
    public void VerifyCredentials2() {

        SoftAssert soft = new SoftAssert();

        String expectedText = "Invalid credentials";
        WebElement UserName = driver.findElement(By.id("txtUsername"));
        boolean displayed = UserName.isDisplayed();
        UserName.sendKeys("123456");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();
        //assertion to make sure that message is correct
        soft.assertEquals(text, expectedText);

        // WebElement userName = driver.findElement(By.id("txtUsername")); //при обновлении вэб страницы введенные
        //данные удаляются поэтому дублируем ввод
        //validate the display is true or not
        System.out.println("helloWorld");
        // displayed=false;
        soft.assertTrue(displayed);

        //check all assertions
        soft.assertAll();
    }

    @AfterMethod(alwaysRun = true)
    public void CloseBrowser() {
        driver.quit();
    }
}
