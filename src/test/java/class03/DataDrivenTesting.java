package class03;

import class01.SoftAssertions;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class DataDrivenTesting {
    @DataProvider(name = "Credentials")
    public Object[][] data() {
        Object[][] login = {
                {"Admin", "abc", "Invalid credentials"},
                {"Adm", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be empty"},
                {"", "Hum@nhrm123", "Username cannot be empty"}};
        return login;
    }

    @Test(dataProvider = "Credentials")
    public void loginWithVariousCredentials(String username, String password, String errorMSG) {

        SoftAssert soft = new SoftAssert();
        WebElement UserName = driver.findElement(By.id("txtUsername"));

        UserName.sendKeys(username);
        driver.findElement(By.id("txtPassword")).sendKeys(password);
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();

        //make assertion
        soft.assertEquals(text, errorMSG);
        soft.assertAll();


    }

    WebDriver driver;  //declaration
    @BeforeMethod(alwaysRun = true)
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup(); //установили потому что используем прямо сейчас, а не фактический вэб-драййвер
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

    }




    @AfterMethod(alwaysRun = true)
    public void CloseBrowser() {
        driver.quit();
    }

}
