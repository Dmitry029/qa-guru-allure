package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;

public class AllureConnectTest extends BaseTest {
    private final MainPage mainPage = new MainPage();

    @DisplayName("Allure connection")
    @Test
    void connectAllureTest() {
        mainPage.openPage()
                .navigateToIssuesPage()
                .checkTheIssueHasText("Another test issue");
    }
}
