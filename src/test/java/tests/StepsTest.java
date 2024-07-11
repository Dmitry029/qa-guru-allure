package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import steps.WebSteps;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;

public class StepsTest {
    private static final String REPOSITORY = "eroshenkoam/allure-example";
    private final String searchWindow = "[data-target='qbsearch-input.inputButtonText']";
    private final String searchInput = "#query-builder-test";
    private final String issueTab = "#issues-tab";
    private final String issueLocator = "#issue_89_link";
    private final String expectedText = "Another test issue";

    @BeforeEach
    void setUp(){
        SelenideLogger.addListener("allure", new AllureSelenide());
    }

    @DisplayName("Lambda steps implementation")
    @Test
    void lambdaStepsTest() {
        step("Открываем главную страницу", () -> {
            open("https://github.com");
        });
        step("Поиск репозитория " + REPOSITORY, () -> {
            $(searchWindow).click();
            $(searchInput).setValue(REPOSITORY);
            $(searchInput).submit();
        });
        step("Переходим в репозиторий " + REPOSITORY, () -> {
            $(linkText(REPOSITORY)).click();
        });
        step("Открываем таб Issue ", () -> {
            $(issueTab).click();
        });
        step("Проверяем название Issue ", () -> {
            $(issueLocator).should(Condition.text(expectedText));
        });
    }

    @DisplayName("Web steps implementation")
    @Test
    void webStepsTest() {
        WebSteps steps = new WebSteps();
        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssuesTab();
        steps.checkIssueTitle(expectedText);
    }
}