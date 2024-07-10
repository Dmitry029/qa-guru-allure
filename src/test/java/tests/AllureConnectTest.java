package tests;

import com.codeborne.selenide.Selenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AllureConnectTest {

    @DisplayName("Allure regjhn connection")
    @Test
    void connectAllureTest(){
        Selenide.open("https://github.com/eroshenkoam/allure-example");
    }
}
