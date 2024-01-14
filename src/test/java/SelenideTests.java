import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;


public class SelenideTests {

    @BeforeAll
     static void beforeAll() {
        Configuration.browserSize = "1920x1080";
        Configuration.baseUrl = "https://demoqa.com";
        Configuration.pageLoadStrategy = "eager";
        //Configuration.holdBrowserOpen = true;
        Configuration.timeout = 5000; // default 4000
    }

    @Test
     void selenideHomework() {
        //Открыть ресурс
        open("https://github.com/");

        //Нажать на строку поиска
        $$(".flex-1").findBy(matchText("Search or jump to..."))
                .shouldBe(enabled).click();

        //Ввести в строку поиска слово "Selenide" и нажать Ввод
        $("#query-builder-test").setValue("Selenide").pressEnter();

        //Открыть страницу Selenide в Github
        $$("[data-testid='results-list']").first().$("a").click();

        //Перейти в раздел Wiki проекта
        $("#wiki-tab").click();

        //Убедиться, что в списке страниц (Pages) есть страница SoftAssertions
        $("#wiki-body").shouldHave(text("Soft assertions")).shouldBe(visible);

        //Открыть страницу SoftAssertion; проверить, что внутри есть пример кода для JUnit5
        $(byText("Soft assertions")).click();
        $(".markdown-body").shouldHave(text("@ExtendWith({SoftAssertsExtension.class})"));

    }
}