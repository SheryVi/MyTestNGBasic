package class01;

import org.testng.annotations.Test;

public class EnableAndDisable {

    @Test(enabled = false)  //если обнаружен баг и разработчики приступили к исправлению, то можно этот
    public void FirstTest() {           //тест отметить как false и работать над другими тестами
        System.out.println("1st");
    }

    @Test(enabled = true)
    public void SecondTest() {
        System.out.println("2nd");
    }

    @Test(enabled = true)
    public void ThirdTest() {
        System.out.println("3rd");
    }

}
