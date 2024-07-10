package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.Selenide.$;

public class IssuesPage {
    public void checkTheIssueHasText(String text) {
        $("#issue_89_link")
                .should(Condition.text(text));
    }
}
