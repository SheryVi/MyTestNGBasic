package class01;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HardAssertion {

    WebDriver driver;  //declaration
    //go to syntax login
    //enter wrong credentials
    //verify the message is "invalid Credentials"

    //перейдите в раздел "синтаксис" входа в систему
    //введите неправильные учетные данные
    //убедитесь, что сообщение "неверные учетные данные"

    @BeforeMethod
    public void OpenBrowser() {
        WebDriverManager.chromedriver().setup(); //установили потому что используем прямо сейчас, а не фактический вэб-драййвер
        driver = new ChromeDriver();
        driver.get("http://hrm.syntaxtechs.net/humanresources/symfony/web/index.php/auth/login");

    }


    @Test
    public void VerifyCredentials() {

        String expectedText = "Invalid credentials";
        WebElement UserName = driver.findElement(By.id("txtUsername"));
        UserName.sendKeys("123456");
        driver.findElement(By.id("txtPassword")).sendKeys("123456");
        driver.findElement(By.id("btnLogin")).click();
        String text = driver.findElement(By.id("spanMessage")).getText();
        // first assertion compare the two strings
        Assert.assertEquals(text, expectedText);

        WebElement username = driver.findElement(By.id("txtUsername"));
        //assert if username text box is displayed
        boolean displayed = username.isDisplayed();
        //assertion if it is actually displayed or not
        System.out.println("helloWorld");
        Assert.assertTrue(displayed);


        //подтвердить, отображается ли текстовое поле имени пользователя
        //если первое (assert)утверждение неверно, второе проверяться не будет
        //утверждение, действительно ли оно отображается или нет

    }

    @AfterMethod
    public void CloseBrowser() {
        driver.quit();

    }

}
