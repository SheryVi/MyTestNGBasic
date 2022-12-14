package class01;

import org.testng.annotations.Test;

public class DependsOn {

    @Test
    public void login(){
        System.out.println("This is login test");   // Набор по умолчанию
                                   // Общее количество выполненных тестов: 2, Проходов: 0, сбоев: 1, пропусков: 1
    }

    @Test(dependsOnMethods = "login")
    public void verificationOfDashboard(){
        System.out.println("This is dashboard");

    }
}
