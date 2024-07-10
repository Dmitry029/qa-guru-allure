package pages;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class MainPage {

    public MainPage openPage() {
        open("");
        return this;
    }

    public IssuesPage navigateToIssuesPage() {
        $("#issues-tab").click();
        return new IssuesPage();
    }
}
